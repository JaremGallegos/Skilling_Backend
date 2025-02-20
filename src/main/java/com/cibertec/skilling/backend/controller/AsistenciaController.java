package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cibertec.skilling.backend.model.dto.request.AsistenciaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AsistenciaResponseDTO;
import com.cibertec.skilling.backend.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin({"*"})
public class AsistenciaController {

    @Autowired
    private final AsistenciaService asistenciaService;

    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping
    public ResponseEntity<List<AsistenciaResponseDTO>> getAllAsistencias() {
        List<AsistenciaResponseDTO> asistencias = asistenciaService.findAllAsistencias();
        return ResponseEntity.ok(asistencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaResponseDTO> getAsistenciaById(@PathVariable("id") Integer id) {
        AsistenciaResponseDTO asistencia = asistenciaService.findAsistenciaById(id);
        return ResponseEntity.ok(asistencia);
    } 

    @PostMapping
    public ResponseEntity<AsistenciaResponseDTO> createdAsistencia(@RequestBody AsistenciaRequestDTO requestDTO) {
        AsistenciaResponseDTO asistencias = asistenciaService.createAsistencia(requestDTO);
        return ResponseEntity.ok(asistencias);
    }   

    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaResponseDTO> updateAsistencia(@PathVariable("id") Integer id,
                                                                  @RequestBody AsistenciaRequestDTO requestDTO) {
        AsistenciaResponseDTO updatedAsistencia = asistenciaService.updateAsistencia(id, requestDTO);
        return ResponseEntity.ok(updatedAsistencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable("id") Integer id) {
        asistenciaService.deleteAsistencia(id);
        return ResponseEntity.noContent().build();
    }
}
