package com.cibertec.skilling.backend.service.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.mapper.LibroMapper;
import com.cibertec.skilling.backend.model.dto.request.LibroRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LibroResponseDTO;
import com.cibertec.skilling.backend.model.entity.Libro;
import com.cibertec.skilling.backend.repository.LibroRepository;
import com.cibertec.skilling.backend.service.LibroService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroServiceImplement implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public LibroServiceImplement(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }

    @Override
    public List<LibroResponseDTO> findAllLibros() {
        return libroRepository.findAll()
                .stream()
                .map(libroMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibroResponseDTO findLibroById(String id) {
        Libro libro = libroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado con id " + id));
        return libroMapper.toResponseDTO(libro);
    }

    @Override
    public LibroResponseDTO createLibro(LibroRequestDTO requestDTO) {
        Libro libro = libroMapper.toEntity(requestDTO);
        Libro saved = libroRepository.save(libro);
        return libroMapper.toResponseDTO(saved);
    }

    @Override
    public LibroResponseDTO updateLibro(String id, LibroRequestDTO requestDTO) {
        Libro libro = libroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrad con id " + id));
        libro.setTitulo(requestDTO.getTitulo());
        libro.setAutor(requestDTO.getAutor());
        libro.setIsbn(requestDTO.getIsbn());
        libro.setFechaPublicacion(requestDTO.getFechaPublicacion());
        libro.setResumen(requestDTO.getResumen());
        Libro updated = libroRepository.save(libro);
        return libroMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteLibro(String id) {
        Libro libro = libroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado con id " + id));
        libroRepository.delete(libro);
    }


    /**
     * Procesa un archivo CSV y carga los libros de manera asincrónica.
     *
     * Este método lee un archivo CSV, extrae los datos de los libros y los procesa de manera concurrente
     * utilizando {@link CompletableFuture} para mejorar la eficiencia
     *
     * @param file Archivo CSV que contiene los datos de los libros. Debe estar codificado en UTF-8.
     * @return Lista de objetos {@link LibroResponseDTO} representando los libros cargados.
     * @throws Exception Si ocurre un error durante la lectura o el procesamiento del archivo.
     */
    @Override
    public List<LibroResponseDTO> uploadLibrosFromCSV(MultipartFile file) throws Exception {
        List<CompletableFuture<LibroResponseDTO>> libros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String linea;
            boolean encabezado = true;
            while ((linea = br.readLine()) != null) {
                if (encabezado) {
                    encabezado = false;
                    continue;
                }
                String[] campos = linea.split(",");
                if (campos.length < 5) {
                    continue;
                }
                LibroRequestDTO dto = LibroRequestDTO.builder()
                        .titulo(campos[0].trim())
                        .autor(campos[1].trim())
                        .isbn(campos[2].trim())
                        .fechaPublicacion(parseLocalDateTime(campos[3].trim()))
                        .resumen(campos[4].trim())
                        .build();
                CompletableFuture<LibroResponseDTO> future = CompletableFuture.supplyAsync(() -> createLibro(dto), executor);
                libros.add(future);
            }
        }
        return libros.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private LocalDateTime parseLocalDateTime(String fechaStr) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(fechaStr, formato);
    }

}
