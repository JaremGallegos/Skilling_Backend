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

import com.cibertec.skilling.backend.model.dto.request.TareaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.TareaResponseDTO;
import com.cibertec.skilling.backend.service.TareaService;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin({"*"})
public class TareaController {

    @Autowired
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public ResponseEntity<List<TareaResponseDTO>> getAllTareas() {
        List<TareaResponseDTO> tareas = tareaService.findAllTareas();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaResponseDTO> getTareaById(@PathVariable("id") Integer id) {
        TareaResponseDTO tarea = tareaService.findTareaById(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping
    public ResponseEntity<TareaResponseDTO> createTarea(@RequestBody TareaRequestDTO requestDTO) {
        TareaResponseDTO createdTarea = tareaService.createTarea(requestDTO);
        return new ResponseEntity<>(createdTarea, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaResponseDTO> updateTarea(@PathVariable("id") Integer id,
                                                        @RequestBody TareaRequestDTO requestDTO) {
        TareaResponseDTO updatedTarea = tareaService.updateTarea(id, requestDTO);
        return ResponseEntity.ok(updatedTarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable("id") Integer id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }
}
