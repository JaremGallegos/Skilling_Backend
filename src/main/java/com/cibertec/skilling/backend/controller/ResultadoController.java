package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.skilling.backend.model.dto.request.ResultadoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ResultadoResponseDTO;
import com.cibertec.skilling.backend.service.ResultadoService;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public ResponseEntity<List<ResultadoResponseDTO>> getAllResultados() {
        List<ResultadoResponseDTO> resultados = resultadoService.findAllResultados();
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoResponseDTO> getResultadoById(@PathVariable("id") Integer id) {
        ResultadoResponseDTO resultado = resultadoService.findResultadoById(id);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<ResultadoResponseDTO> createResultado(@RequestBody ResultadoRequestDTO requestDTO) {
        ResultadoResponseDTO createdResultado = resultadoService.createResultado(requestDTO);
        return new ResponseEntity<>(createdResultado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoResponseDTO> updateResultado(@PathVariable("id") Integer id, 
                                                                @RequestBody ResultadoRequestDTO requestDTO) {
        ResultadoResponseDTO updatedResultado = resultadoService.updateResultado(id, requestDTO);
        return ResponseEntity.ok(updatedResultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable("id") Integer id) {
        resultadoService.deleteResultado(id);
        return ResponseEntity.noContent().build();
    }
}
