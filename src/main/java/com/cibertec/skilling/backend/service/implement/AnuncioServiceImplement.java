package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.AnuncioNotFoundException;
import com.cibertec.skilling.backend.mapper.AnuncioMapper;
import com.cibertec.skilling.backend.model.dto.request.AnuncioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AnuncioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Anuncio;
import com.cibertec.skilling.backend.repository.AnuncioRepository;
import com.cibertec.skilling.backend.service.AnuncioService;

@Service
public class AnuncioServiceImplement implements AnuncioService {
    @Autowired
    private final AnuncioRepository anuncioRepository;

    @Autowired
    private final AnuncioMapper anuncioMapper;

    public AnuncioServiceImplement(AnuncioRepository anuncioRepository, AnuncioMapper anuncioMapper) {
        this.anuncioRepository = anuncioRepository;
        this.anuncioMapper = anuncioMapper;
    }

    @Override
    public List<AnuncioResponseDTO> findAllAnuncios() {
        return anuncioRepository.findAll()
            .stream()
            .map(anuncioMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public AnuncioResponseDTO findAnuncioById(Integer id) {
        return anuncioRepository.findById(id)
            .map(anuncioMapper::toResponseDTO)
            .orElseThrow(() -> new AnuncioNotFoundException("[Error 404] Anuncio no encontrado con id: " + id));
    }

    @Override
    public AnuncioResponseDTO createAnuncio(AnuncioRequestDTO requestDTO) {
        Anuncio anuncio = anuncioMapper.toEntity(requestDTO);
        Anuncio savedAnuncio = anuncioRepository.save(anuncio);
        return anuncioMapper.toResponseDTO(savedAnuncio); 
    }

    @Override
    public AnuncioResponseDTO updateAnuncio(Integer id, AnuncioRequestDTO requestDTO) {
        Anuncio existingAnuncio = anuncioRepository.findById(id)
            .orElseThrow(() -> new AnuncioNotFoundException("[Error 404] Anuncio no encontrado con id: " + id));
        existingAnuncio.setTitulo(requestDTO.getTitulo());
        existingAnuncio.setDescripcion(requestDTO.getDescripcion());
        existingAnuncio.setFecha(requestDTO.getFecha());
        if (requestDTO.getClaseId() != null) existingAnuncio.setClase(null);
        Anuncio updatedAnuncio = anuncioRepository.save(existingAnuncio);
        return anuncioMapper.toResponseDTO(updatedAnuncio);

    }

    @Override
    public void deleteAnuncio(Integer id) {
        Anuncio existingAnuncio = anuncioRepository.findById(id)
            .orElseThrow(() -> new AnuncioNotFoundException("[Error 404] Anuncio no encontrado con id: " + id));
        anuncioRepository.delete(existingAnuncio);
    }
}
