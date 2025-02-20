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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.model.dto.request.EstudianteRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.EstudianteResponseDTO;
import com.cibertec.skilling.backend.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin({"*"})
public class EstudianteController {

    @Autowired
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> getAllEstudiantes() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findAllEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> getEstudianteById(@PathVariable("id") String id) {
        EstudianteResponseDTO estudiante = estudianteService.findEstudianteById(id);
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> createEstudiante(@RequestBody EstudianteRequestDTO requestDTO) {
        EstudianteResponseDTO createEstudiante = estudianteService.createEstudiante(requestDTO);
        return new ResponseEntity<>(createEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> updateEstudiante(@PathVariable("id") String id,
                                                                  @RequestBody EstudianteRequestDTO requestDTO) {
        EstudianteResponseDTO updatedEstudiante = estudianteService.updateEstudiante(id, requestDTO);
        return ResponseEntity.ok(updatedEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable("id") String id) {
        estudianteService.deleteEstudiante(id);
        return ResponseEntity.noContent().build();
    }

}
