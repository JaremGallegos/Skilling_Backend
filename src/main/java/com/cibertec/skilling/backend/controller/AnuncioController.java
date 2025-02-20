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

import com.cibertec.skilling.backend.model.dto.request.AnuncioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AnuncioResponseDTO;
import com.cibertec.skilling.backend.service.AnuncioService;

@RestController
@RequestMapping("/api/anuncios")
@CrossOrigin({"*"})
public class AnuncioController {

    @Autowired
    private final AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @GetMapping
    public ResponseEntity<List<AnuncioResponseDTO>> getAllAnuncio() {
        List<AnuncioResponseDTO> anuncios = anuncioService.findAllAnuncios();
        return ResponseEntity.ok(anuncios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnuncioResponseDTO> getAnuncioById(@PathVariable("id") Integer id) {
        AnuncioResponseDTO anuncio = anuncioService.findAnuncioById(id);
        return ResponseEntity.ok(anuncio);
    }

    @PostMapping
    public ResponseEntity<AnuncioResponseDTO> createAnuncio(@RequestBody AnuncioRequestDTO requestDTO) {
        AnuncioResponseDTO createdAnuncio = anuncioService.createAnuncio(requestDTO);
        return new ResponseEntity<>(createdAnuncio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnuncioResponseDTO> updateAnuncio(@PathVariable("id") Integer id,
                                                            @RequestBody AnuncioRequestDTO requestDTO) {
        AnuncioResponseDTO updatedAnuncio = anuncioService.updateAnuncio(id, requestDTO);
        return ResponseEntity.ok(updatedAnuncio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnuncio(@PathVariable("id") Integer id) {
        anuncioService.deleteAnuncio(id);
        return ResponseEntity.noContent().build();
    }
}
