package com.cibertec.skilling.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.RolRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.service.RolService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/roles")
@CrossOrigin({"*"})
public class RolController {

    @Autowired
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolResponseDTO>> getAllRoles() {
        List<RolResponseDTO> roles = rolService.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> getRolById(@PathVariable("id") Integer id) {
        RolResponseDTO rol = rolService.findRolById(id);
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<RolResponseDTO> createRol(@RequestBody RolRequestDTO requestDTO) {
        RolResponseDTO createdRol = rolService.createRol(requestDTO);
        return new ResponseEntity<>(createdRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolResponseDTO> updatedRol(@PathVariable("id") Integer id, 
                                                     @RequestBody RolRequestDTO requestDTO) {
        RolResponseDTO updatedRol = rolService.updateRol(id, requestDTO);
        return ResponseEntity.ok(updatedRol);                                                                
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable("id") Integer id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    } 
    
}
