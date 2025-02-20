package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.model.dto.request.GaleriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GaleriaResponseDTO;
import com.cibertec.skilling.backend.service.GaleriaService;

@RestController
@RequestMapping("/api/galerias")
public class GaleriaController {

    private final GaleriaService galeriaService;

    @Autowired
    public GaleriaController(GaleriaService galeriaService) {
        this.galeriaService = galeriaService;
    }

    @GetMapping
    public ResponseEntity<List<GaleriaResponseDTO>> getAllGalerias() {
        List<GaleriaResponseDTO> galerias = galeriaService.findAllGalerias();
        return new ResponseEntity<>(galerias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GaleriaResponseDTO> getGaleriaById(@PathVariable String id) {
        GaleriaResponseDTO galeria = galeriaService.findGaleriaById(id);
        return new ResponseEntity<>(galeria, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GaleriaResponseDTO> createGaleria(@RequestBody GaleriaRequestDTO requestDTO) {
        GaleriaResponseDTO created = galeriaService.createGaleria(requestDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GaleriaResponseDTO> updateGaleria(@PathVariable String id, @RequestBody GaleriaRequestDTO requestDTO) {
        GaleriaResponseDTO updated = galeriaService.updateGaleria(id, requestDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGaleria(@PathVariable String id) {
        galeriaService.deleteGaleria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para subir imagen y crear una Galeria, utilizando MultipartFile
    @PostMapping("/upload")
    public ResponseEntity<GaleriaResponseDTO> uploadGaleria(
            @RequestParam MultipartFile file,
            @ModelAttribute GaleriaRequestDTO requestDTO) {
        try {
            GaleriaResponseDTO created = galeriaService.uploadGaleria(file, requestDTO);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
