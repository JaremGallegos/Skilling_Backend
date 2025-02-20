package com.cibertec.skilling.backend.controller;

import java.util.List;

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

import com.cibertec.skilling.backend.model.dto.request.LibroRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LibroResponseDTO;
import com.cibertec.skilling.backend.service.LibroService;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin({"*"})
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> getAllLibros() {
        List<LibroResponseDTO> libros = libroService.findAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> getLibroById(@PathVariable String id) {
        LibroResponseDTO libro = libroService.findLibroById(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LibroResponseDTO> createLibro(@RequestBody LibroRequestDTO requestDTO) {
        LibroResponseDTO created = libroService.createLibro(requestDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> updateLibro(@PathVariable String id, @RequestBody LibroRequestDTO requestDTO) {
        LibroResponseDTO updated = libroService.updateLibro(id, requestDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable String id) {
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para carga masiva de libros desde CSV
    @PostMapping("/upload")
    public ResponseEntity<List<LibroResponseDTO>> uploadLibros(@RequestParam("file") MultipartFile file) {
        try {
            List<LibroResponseDTO> result = libroService.uploadLibrosFromCSV(file);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            // Manejo de error básico
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}