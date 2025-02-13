package com.cibertec.skilling.backend.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.skilling.backend.exceptions.ResultadoNotFoundException;
import com.cibertec.skilling.backend.mapper.ResultadoMapper;
import com.cibertec.skilling.backend.model.dto.request.ResultadoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ResultadoResponseDTO;
import com.cibertec.skilling.backend.model.entity.Resultado;
import com.cibertec.skilling.backend.repository.ResultadoRepository;
import com.cibertec.skilling.backend.service.ResultadoService;

@Service
public class ResultadoServiceImplement implements ResultadoService {
    @Autowired
    private final ResultadoRepository resultadoRepository;
    
    @Autowired
    private final ResultadoMapper resultadoMapper;

    public ResultadoServiceImplement(ResultadoRepository resultadoRepository, ResultadoMapper resultadoMapper) {
        this.resultadoRepository = resultadoRepository;
        this.resultadoMapper = resultadoMapper;
    }
    
    @Override
    public List<ResultadoResponseDTO> findAllResultados() {
        return resultadoRepository.findAll()
            .stream()
            .map(resultadoMapper::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ResultadoResponseDTO findResultadoById(Integer id) {
        return resultadoRepository.findById(id)
            .map(resultadoMapper::toResponseDTO)
            .orElseThrow(() -> new ResultadoNotFoundException("[Error 404] Resultado no encontrado con id: " + id));
    }

    @Override
    public ResultadoResponseDTO createResultado(ResultadoRequestDTO requestDTO) {
        Resultado resultado = resultadoMapper.toEntity(requestDTO);
        Resultado savedResultado = resultadoRepository.save(resultado);
        return resultadoMapper.toResponseDTO(savedResultado);
    }

    @Override
    public ResultadoResponseDTO updateResultado(Integer id, ResultadoRequestDTO requestDTO) {
        Resultado existingResultado = resultadoRepository.findById(id)
            .orElseThrow(() -> new ResultadoNotFoundException("[Error 404] Resultado no encontrado con id: " + id));
        existingResultado.setPuntaje(requestDTO.getPuntaje());
        Resultado updatedResultado = resultadoRepository.save(existingResultado);
        return resultadoMapper.toResponseDTO(updatedResultado);
    }

    @Override
    public void deleteResultado(Integer id) {
        Resultado existingResultado = resultadoRepository.findById(id)
            .orElseThrow(() -> new ResultadoNotFoundException("[Error 404] Resultado no encontrado con id: " + id));
        resultadoRepository.delete(existingResultado);
    }
}
