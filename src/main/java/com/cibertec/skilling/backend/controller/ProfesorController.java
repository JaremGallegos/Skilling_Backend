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

import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.service.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponseDTO>> getAllProfesores() {
        List<ProfesorResponseDTO> profesores = profesorService.findAllProfesores();
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> getProfesorById(@PathVariable("id") String id) {
        ProfesorResponseDTO profesor = profesorService.findProfesorById(id);
        return ResponseEntity.ok(profesor); 
    }

    @PostMapping
    public ResponseEntity<ProfesorResponseDTO> createProfesor(@RequestBody ProfesorRequestDTO requestDTO) {
        ProfesorResponseDTO createdProfesor = profesorService.createProfesor(requestDTO);
        return new ResponseEntity<>(createdProfesor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> updateProfesor(@PathVariable("id") String id,
                                                              @RequestBody ProfesorRequestDTO requesstDTO) {
        ProfesorResponseDTO updatedProfesor = profesorService.updateProfesor(id, requesstDTO);
        return ResponseEntity.ok(updatedProfesor);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable("id") String id) {
        profesorService.deleteProfesor(id);
        return ResponseEntity.noContent().build();
    }
}
