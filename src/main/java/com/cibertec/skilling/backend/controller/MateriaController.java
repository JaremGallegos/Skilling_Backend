package com.cibertec.skilling.backend.controller;

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

import com.cibertec.skilling.backend.model.dto.request.MateriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.MateriaResponseDTO;
import com.cibertec.skilling.backend.service.MateriaService;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> getMateriaById(@PathVariable("id") Integer id) {
        MateriaResponseDTO materia = materiaService.findMateriaById(id);
        return ResponseEntity.ok(materia);    
    } 

    @PostMapping
    public ResponseEntity<MateriaResponseDTO> createMateria(@RequestBody MateriaRequestDTO requestDTO) {
        MateriaResponseDTO createdMateria = materiaService.createMateria(requestDTO);
        return new ResponseEntity<>(createdMateria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponseDTO> updatedMateria(@PathVariable("id") Integer id,
                                                             @RequestBody MateriaRequestDTO requestDTO) {
        MateriaResponseDTO updatedMateria = materiaService.updateMateria(id, requestDTO);
        return ResponseEntity.ok(updatedMateria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable("id") Integer id) {
        materiaService.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }
}
