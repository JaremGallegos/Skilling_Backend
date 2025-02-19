package com.cibertec.skilling.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.AdministradorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AdministradorResponseDTO;
import com.cibertec.skilling.backend.service.AdministradorService;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {
    
    @Autowired
    private final AdministradorService administradorService;
    
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> getAdministradorById(@PathVariable("id") String id) {
        AdministradorResponseDTO administrador = administradorService.findAdministradorById(id);
        return ResponseEntity.ok(administrador);
    }

    @PostMapping
    public ResponseEntity<AdministradorResponseDTO> createAdministrador(@RequestBody AdministradorRequestDTO requestDTO) {
        AdministradorResponseDTO createdAdministrador = administradorService.createAdministrador(requestDTO);
        return new ResponseEntity<>(createdAdministrador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> updateAdministrador(@PathVariable("id") String id,
                                                                        @RequestBody AdministradorRequestDTO requestDTO) {
        AdministradorResponseDTO updatedAdministrador = administradorService.updateAdministrador(id, requestDTO);
        return ResponseEntity.ok(updatedAdministrador);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdministradorResponseDTO> patchAdministrador(@PathVariable("id") String id,
                                                                       @RequestBody AdministradorRequestDTO requestDTO) {
        // Para este ejemplo, usaremos el mismo método update, pero en un escenario real podrías
        // tener una lógica de merge que actualice solo los campos enviados.
        AdministradorResponseDTO patchedAdministrador = administradorService.updateAdministrador(id, requestDTO);
        return ResponseEntity.ok(patchedAdministrador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable("id") String id) {
        administradorService.deleteAdministrador(id);
        return ResponseEntity.noContent().build();
    }
}
