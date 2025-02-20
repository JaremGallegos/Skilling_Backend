package com.cibertec.skilling.backend.service.implement;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.skilling.backend.mapper.SimulacionMapper;
import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Simulacion;
import com.cibertec.skilling.backend.repository.SimulacionRepository;
import com.cibertec.skilling.backend.service.SimulacionService;

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
     * Procesa de forma paralela una lista de 100 registros JSON de simulacion
     */
    @Override
    public List<SimulacionResponseDTO> procesarSimulacionesConThreads(List<SimulacionRequestDTO> dtos) {
        List<CompletableFuture<SimulacionResponseDTO>> futures = dtos.stream()
                .map(dto -> CompletableFuture.supplyAsync(() -> createSimulacion(dto), executor))
                .collect(Collectors.toList());
        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /**
     * Descarga todos los registros de la entidad
     */
    @Override
    public Resource descargarCsvFile() throws Exception {
        List<Simulacion> simulaciones = simulacionRepository.findAll();
        StringBuilder sb = new StringBuilder();
        
        // Escribir la cabecera
        sb.append("id,nombre,descripcion,estado,tiempoInicio,tiempoFin\n");
        for (Simulacion s : simulaciones) {
            sb.append(s.getId()).append(",")
              .append(s.getNombre()).append(",")
              .append(s.getDescripcion()).append(",")
              .append(s.getEstado()).append(",")
              .append(s.getTiempoInicio()).append(",")
              .append(s.getTiempoFin()).append("\n");
        }

        // Convertir el CSV en un arreglo de Bytes
        byte[] csvBytes = sb.toString().getBytes(StandardCharsets.UTF_8);
        
        // Retornar el CSV como recurso
        return new ByteArrayResource(csvBytes);
    }

}
