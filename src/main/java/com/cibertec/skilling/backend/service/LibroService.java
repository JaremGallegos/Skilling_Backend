package com.cibertec.skilling.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cibertec.skilling.backend.model.dto.request.LibroRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LibroResponseDTO;

public interface LibroService {
    List<LibroResponseDTO> findAllLibros();
    LibroResponseDTO findLibroById(String id);
    LibroResponseDTO createLibro(LibroRequestDTO requestDTO);
    LibroResponseDTO updateLibro(String id, LibroRequestDTO requestDTO);
    void deleteLibro(String id);
    
    List<LibroResponseDTO> uploadLibrosFromCSV(MultipartFile file) throws Exception;
}