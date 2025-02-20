package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.cibertec.skilling.backend.model.dto.request.LeccionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LeccionResponseDTO;
import com.cibertec.skilling.backend.service.LeccionService;

@RestController
@RequestMapping("/api/lecciones")
@CrossOrigin({"*"})
public class LeccionController {

    @Autowired
    private final LeccionService leccionService;

    public LeccionController(LeccionService leccionService) {
        this.leccionService = leccionService;
    }

    @GetMapping
    public ResponseEntity<List<LeccionResponseDTO>> getAllLecciones() {
        List<LeccionResponseDTO> lecciones = leccionService.findAllLecciones();
        return ResponseEntity.ok(lecciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeccionResponseDTO> getLeccionById(@PathVariable("id") Integer id) {
        LeccionResponseDTO leccion = leccionService.findLeccionById(id);
        return ResponseEntity.ok(leccion);
    }

    @PostMapping
    public ResponseEntity<LeccionResponseDTO> createLeccion(@RequestBody LeccionRequestDTO requestDTO) {
        LeccionResponseDTO createdLeccion = leccionService.createLeccion(requestDTO);
        return new ResponseEntity<>(createdLeccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeccionResponseDTO> updateLeccion(@PathVariable("id") Integer id,
                                                            @RequestBody LeccionRequestDTO requestDTO) {
        LeccionResponseDTO updatedLeccion = leccionService.updateLeccion(id, requestDTO);
        return ResponseEntity.ok(updatedLeccion);                                                        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeccion(@PathVariable("id") Integer id) {
        leccionService.deleteLeccion(id);
        return ResponseEntity.noContent().build();
    }
}
