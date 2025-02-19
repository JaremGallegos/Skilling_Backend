package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.ClaseRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.service.ClaseService;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public ResponseEntity<List<ClaseResponseDTO>> getAllClases() {
        List<ClaseResponseDTO> clases = claseService.findAllClases();
        return ResponseEntity.ok(clases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseResponseDTO> getClaseById(@PathVariable("id") Integer id) {
        ClaseResponseDTO clase = claseService.findClaseById(id);
        return ResponseEntity.ok(clase);
    }

    @PostMapping
    public ResponseEntity<ClaseResponseDTO> createClase(@RequestBody ClaseRequestDTO requestDTO) {
        ClaseResponseDTO createdClase = claseService.createClase(requestDTO);
        return new ResponseEntity<>(createdClase, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseResponseDTO> updateClase(@PathVariable("id") Integer id,
                                                       @RequestBody ClaseRequestDTO requestDTO) {
        ClaseResponseDTO updatedClase = claseService.updateClase(id, requestDTO);
        return ResponseEntity.ok(updatedClase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable("id") Integer id) {
        claseService.deleteClase(id);
        return ResponseEntity.noContent().build();
    }
}
