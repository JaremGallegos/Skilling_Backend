package com.cibertec.skilling.backend.service;

import java.util.List;

import com.cibertec.skilling.backend.model.dto.request.ResultadoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ResultadoResponseDTO;

public interface ResultadoService {
    List<ResultadoResponseDTO> findAllResultados();
    ResultadoResponseDTO findResultadoById(Integer id);
    ResultadoResponseDTO createResultado(ResultadoRequestDTO requestDTO);
    ResultadoResponseDTO updateResultado(Integer id, ResultadoRequestDTO requestDTO);
    void deleteResultado(Integer id);
}
