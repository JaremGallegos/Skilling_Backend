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

import com.cibertec.skilling.backend.model.dto.request.ExamenRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ExamenResponseDTO;
import com.cibertec.skilling.backend.service.ExamenService;

@RestController
@RequestMapping("/api/examenes")
@CrossOrigin({"*"})
public class ExamenController {

    @Autowired
    private final ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @GetMapping
    public ResponseEntity<List<ExamenResponseDTO>> getAllExamenes() {
        List<ExamenResponseDTO> examenes = examenService.findAllExamenes();
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenResponseDTO> getExamenById(@PathVariable("id") Integer id){
        ExamenResponseDTO examen = examenService.findExamenById(id);
        return ResponseEntity.ok(examen);
    } 

    @PostMapping
    public ResponseEntity<ExamenResponseDTO> createExamen(@RequestBody ExamenRequestDTO requestDTO) {
        ExamenResponseDTO createdExamen = examenService.createExamen(requestDTO);
        return new ResponseEntity<>(createdExamen, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenResponseDTO> updateExamen(@PathVariable("id") Integer id,
                                                          @RequestBody ExamenRequestDTO requestDTO) {
        ExamenResponseDTO updatedExamen = examenService.updateExamen(id, requestDTO);
        return ResponseEntity.ok(updatedExamen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamen(@PathVariable("id") Integer id) {
        examenService.deleteExamen(id);
        return ResponseEntity.noContent().build();
    }
}
