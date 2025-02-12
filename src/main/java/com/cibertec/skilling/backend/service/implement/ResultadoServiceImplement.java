package com.cibertec.skilling.backend.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.model.dto.request.ResultadoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ResultadoResponseDTO;
import com.cibertec.skilling.backend.service.ResultadoService;

@Service
public class ResultadoServiceImplement implements ResultadoService {

    @Override
    public List<ResultadoResponseDTO> findAllResultados() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllResultados'");
    }

    @Override
    public ResultadoResponseDTO findResultadoById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'findResultadoById'");
    }

    @Override
    public ResultadoResponseDTO createResultado(ResultadoRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createResultado'");
    }

    @Override
    public ResultadoResponseDTO updateResultado(Integer id, ResultadoRequestDTO requestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateResultado'");
    }

    @Override
    public void deleteResultado(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteResultado'");
    }
}
