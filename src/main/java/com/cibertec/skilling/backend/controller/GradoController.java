package com.cibertec.skilling.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.GradoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GradoResponseDTO;
import com.cibertec.skilling.backend.service.GradoService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/grados")
public class GradoController {

    @Autowired
    private final GradoService gradoService;
    
    public GradoController(GradoService gradoService) {
        this.gradoService = gradoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradoResponseDTO> getGradoById(@PathVariable("id") Integer id) {
        GradoResponseDTO grado = gradoService.findGradoById(id);
        return ResponseEntity.ok(grado);
    }

    @PostMapping
    public ResponseEntity<GradoResponseDTO> createGrado(@RequestBody GradoRequestDTO requestDTO) {
        GradoResponseDTO createdGrado = gradoService.createGrado(requestDTO);
        return new ResponseEntity<>(createdGrado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradoResponseDTO> updateGrado(@PathVariable("id") Integer id,
                                                        @RequestBody GradoRequestDTO requestDTO) {
        GradoResponseDTO updatedGrado = gradoService.updateGrado(id, requestDTO);
        return ResponseEntity.ok(updatedGrado);               
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrado(@PathVariable("id") Integer id) {
        gradoService.deleteGrado(id);
        return ResponseEntity.noContent().build();
    }
}
