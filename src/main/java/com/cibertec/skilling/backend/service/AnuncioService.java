package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.AnuncioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AnuncioResponseDTO;

public interface AnuncioService {
    List<AnuncioResponseDTO> findAllAnuncios();
    AnuncioResponseDTO findAnuncioById(Integer id);
    AnuncioResponseDTO createAnuncio(AnuncioRequestDTO requestDTO);
    AnuncioResponseDTO updateAnuncio(Integer id, AnuncioRequestDTO requestDTO);
    void deleteAnuncio(Integer id);
}
