package com.cibertec.skilling.backend.service.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.mapper.SimulacionMapper;
import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Simulacion;
import com.cibertec.skilling.backend.repository.SimulacionRepository;
import com.cibertec.skilling.backend.service.SimulacionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class SimulacionServiceImplement implements SimulacionService {

    private final SimulacionRepository simulacionRepository;
    private final SimulacionMapper simulacionMapper;
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public SimulacionServiceImplement(SimulacionRepository simulacionRepository, SimulacionMapper simulacionMapper) {
        this.simulacionRepository = simulacionRepository;
        this.simulacionMapper = simulacionMapper;
    }

    @Override
    public List<SimulacionResponseDTO> findAllSimulaciones() {
        return simulacionRepository.findAll()
                .stream()
                .map(simulacionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SimulacionResponseDTO findSimulacionById(String id) {
        Simulacion simulacion = simulacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Simulacion not found with id " + id));
        return simulacionMapper.toResponseDTO(simulacion);
    }

    @Override
    public SimulacionResponseDTO createSimulacion(SimulacionRequestDTO requestDTO) {
        Simulacion simulacion = simulacionMapper.toEntity(requestDTO);
        Simulacion saved = simulacionRepository.save(simulacion);
        return simulacionMapper.toResponseDTO(saved);
    }

    @Override
    public SimulacionResponseDTO updateSimulacion(String id, SimulacionRequestDTO requestDTO) {
        Simulacion simulacion = simulacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Simulacion not found with id " + id));
        simulacion.setNombre(requestDTO.getNombre());
        simulacion.setDescripcion(requestDTO.getDescripcion());
        simulacion.setEstado(requestDTO.getEstado());
        simulacion.setTiempoInicio(requestDTO.getTiempoInicio());
        simulacion.setTiempoFin(requestDTO.getTiempoFin());
        Simulacion updated = simulacionRepository.save(simulacion);
        return simulacionMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteSimulacion(String id) {
        Simulacion simulacion = simulacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Simulacion not found with id " + id));
        simulacionRepository.delete(simulacion);
    }

    /**
     * Procesa una lista de simulaciones de forma concurrente utilizando hilos.
     *
     * Este método recibe una lista de solicitudes de simulación y las procesa en paralelo
     * usando {@link CompletableFuture} y un executor personalizado para mejorar la eficiencia.
     *
     * @param dtos Lista de objetos {@link SimulacionRequestDTO} que contienen los datos de las simulaciones a procesar.
     * @return Lista de objetos {@link SimulacionResponseDTO} con los resultados de las simulaciones procesadas.
     */
    @Override
    public List<SimulacionResponseDTO> procesarSimulacionesConThreads(List<SimulacionRequestDTO> dtos) {
        List<CompletableFuture<SimulacionResponseDTO>> futures = dtos.stream()
                .map(dto -> CompletableFuture.supplyAsync(() -> {
                    String threadNombre = Thread.currentThread().getName();
                    System.out.println("Ejecutando en el hilo: " + threadNombre);
                    return createSimulacion(dto);
                }, executor))
                .collect(Collectors.toList());
    
        List<SimulacionResponseDTO> resultados = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    
        System.out.println("Cargado con éxito");
        return resultados;
    }

    /**
     * Procesa un archivo JSONL que contiene registros de simulación y los registra en la base de datos de forma concurrente.
     *
     * Este método lee un archivo JSONL en el cual cada línea es un registro en formato JSON que representa
     * un objeto {@link SimulacionRequestDTO}. Utiliza {@link CompletableFuture} y un executor personalizado para
     * procesar cada registro de manera asíncrona, lo que mejora la eficiencia en el procesamiento de 100 registros.
     *
     * @param file Archivo JSONL que contiene los registros de simulación. Debe estar codificado en UTF-8.
     * @return Lista de objetos {@link SimulacionResponseDTO} con los resultados de las simulaciones registradas.
     * @throws Exception Si ocurre un error durante la lectura o el procesamiento del archivo.
     */
    @Override
    public List<SimulacionResponseDTO> uploadSimulacionesFromJsonl(MultipartFile file) throws Exception {
        List<CompletableFuture<SimulacionResponseDTO>> futures = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                SimulacionRequestDTO dto = objectMapper.readValue(line, SimulacionRequestDTO.class);
                CompletableFuture<SimulacionResponseDTO> future = CompletableFuture.supplyAsync(() -> createSimulacion(dto), executor);
                futures.add(future);
            }
        }
        
        List<SimulacionResponseDTO> resultados = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        
        System.out.println("Registro de simulaciones desde JSONL completado con éxito.");
        return resultados;
    }

    /**
     * Procesa una lista de simulaciones de forma concurrente utilizando hilos.
     *
     * Este método recibe una lista de solicitudes de simulación y las procesa en paralelo
     * usando {@link CompletableFuture} y un executor personalizado para mejorar la eficiencia.
     *
     * @param dtos Lista de objetos {@link SimulacionRequestDTO} que contienen los datos de las simulaciones a procesar.
     * @return Lista de objetos {@link SimulacionResponseDTO} con los resultados de las simulaciones procesadas.
     */
    @Override
    public Resource descargarCsvFile() throws Exception {
        String threadNombre = Thread.currentThread().getName();
        System.out.println("Generando CSV en el hilo: " + threadNombre);

        List<Simulacion> simulaciones = simulacionRepository.findAll();
        StringBuilder sb = new StringBuilder();
        
        sb.append("id,nombre,descripcion,estado,tiempoInicio,tiempoFin\n");
        for (Simulacion s : simulaciones) {
            sb.append(s.getId()).append(",")
              .append(s.getNombre()).append(",")
              .append(s.getDescripcion()).append(",")
              .append(s.getEstado()).append(",")
              .append(s.getTiempoInicio()).append(",")
              .append(s.getTiempoFin()).append("\n");
        }

        byte[] csvBytes = sb.toString().getBytes(StandardCharsets.UTF_8);
        System.out.println("Archivo CSV generado con éxito.");
        return new ByteArrayResource(csvBytes);
    }

}
