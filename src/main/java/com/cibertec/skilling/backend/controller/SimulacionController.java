package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;
import com.cibertec.skilling.backend.service.SimulacionService;

@RestController
@RequestMapping("/api/simulaciones")
@CrossOrigin({"*"})
public class SimulacionController {

    private final SimulacionService simulacionService;

    public SimulacionController(SimulacionService simulacionService) {
        this.simulacionService = simulacionService;
    }

    @GetMapping
    public ResponseEntity<List<SimulacionResponseDTO>> getAllSimulaciones() {
        List<SimulacionResponseDTO> simulaciones = simulacionService.findAllSimulaciones();
        return new ResponseEntity<>(simulaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulacionResponseDTO> getSimulacionById(@PathVariable String id) {
        SimulacionResponseDTO simulacion = simulacionService.findSimulacionById(id);
        return new ResponseEntity<>(simulacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SimulacionResponseDTO> createSimulacion(@RequestBody SimulacionRequestDTO requestDTO) {
        SimulacionResponseDTO created = simulacionService.createSimulacion(requestDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimulacionResponseDTO> updateSimulacion(@PathVariable String id, @RequestBody SimulacionRequestDTO requestDTO) {
        SimulacionResponseDTO updated = simulacionService.updateSimulacion(id, requestDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSimulacion(@PathVariable String id) {
        simulacionService.deleteSimulacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     *  Endpoint para procesar 100 registros JSON de simulacion de forma optima y rapida
     * */
    @PostMapping("/procesar")
    public ResponseEntity<List<SimulacionResponseDTO>> processSimulaciones(@RequestBody List<SimulacionRequestDTO> simulaciones) {
        // Se espera recibir 100 registros en el body
        List<SimulacionResponseDTO> processed = simulacionService.procesarSimulacionesConThreads(simulaciones);
        return new ResponseEntity<>(processed, HttpStatus.OK);
    }

    /**
     * Endpoint para descargar todos los registros de una tabla
     */
    @GetMapping("/descargar")
    public ResponseEntity<Resource> descargarCsvArchivo() {
        try {
            Resource resource = simulacionService.descargarCsvFile();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=simulaciones.csv");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}