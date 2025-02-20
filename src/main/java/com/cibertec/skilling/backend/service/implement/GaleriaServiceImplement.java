package com.cibertec.skilling.backend.service.implement;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.mapper.GaleriaMapper;
import com.cibertec.skilling.backend.model.dto.request.GaleriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GaleriaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Galeria;
import com.cibertec.skilling.backend.repository.GaleriaRepository;
import com.cibertec.skilling.backend.service.GaleriaService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GaleriaServiceImplement implements GaleriaService {
    
    private final GaleriaRepository galeriaRepository;
    private final GaleriaMapper galeriaMapper;
    
    public GaleriaServiceImplement(GaleriaRepository galeriaRepository, GaleriaMapper galeriaMapper) {
        this.galeriaRepository = galeriaRepository;
        this.galeriaMapper = galeriaMapper;
    }

    @Override
    public List<GaleriaResponseDTO> findAllGalerias() {
        return galeriaRepository.findAll()
                .stream()
                .map(galeriaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GaleriaResponseDTO findGaleriaById(String id) {
        Galeria galeria = galeriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Galeria not found with id " + id));
        return galeriaMapper.toResponseDTO(galeria);
    }

    @Override
    public GaleriaResponseDTO createGaleria(GaleriaRequestDTO requestDTO) {
        Galeria galeria = galeriaMapper.toEntity(requestDTO);
        // Asignar fecha de creación
        galeria.setFechaCreacion(LocalDateTime.now());
        Galeria saved = galeriaRepository.save(galeria);
        return galeriaMapper.toResponseDTO(saved);
    }

    @Override
    public GaleriaResponseDTO updateGaleria(String id, GaleriaRequestDTO requestDTO) {
        Galeria galeria = galeriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Galeria not found with id " + id));
        galeria.setNombre(requestDTO.getNombre());
        galeria.setDescripcion(requestDTO.getDescripcion());
        galeria.setImagen(requestDTO.getImagen());
        galeria.setEstado(requestDTO.getEstado());
        Galeria updated = galeriaRepository.save(galeria);
        return galeriaMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteGaleria(String id) {
        Galeria galeria = galeriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Galeria not found with id " + id));
        galeriaRepository.delete(galeria);
    }

    @Override
    public GaleriaResponseDTO uploadGaleria(MultipartFile file, GaleriaRequestDTO requestDTO) throws Exception {
        try {
            byte[] imageBytes = file.getBytes();
            GaleriaRequestDTO updatedDTO = GaleriaRequestDTO.builder()
                .nombre(requestDTO.getNombre())
                .descripcion(requestDTO.getDescripcion())
                .imagen(imageBytes) 
                .estado(requestDTO.getEstado())
                .build();
            return createGaleria(updatedDTO);
        } catch (IOException e) {
            throw new Exception("Error al procesar la imagen", e);
        }
    }

}
