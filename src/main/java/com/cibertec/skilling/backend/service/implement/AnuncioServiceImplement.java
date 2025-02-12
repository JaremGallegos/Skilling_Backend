package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.AnuncioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AnuncioResponseDTO;
import com.cibertec.skilling.backend.service.AnuncioService;

@Service
public class AnuncioServiceImplement implements AnuncioService {

    @Override
    public List<AnuncioResponseDTO> findAllAnuncios() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllAnuncios'");
    }

    @Override
    public AnuncioResponseDTO findAnuncioById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findAnuncioById'");
    }

    @Override
    public AnuncioResponseDTO createAnuncio(AnuncioRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createAnuncio'");
    }

    @Override
    public AnuncioResponseDTO updateAnuncio(Integer id, AnuncioRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateAnuncio'");
    }

    @Override
    public void deleteAnuncio(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAnuncio'");
    }
}
