package com.cibertec.skilling.backend.controller;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;
import com.cibertec.skilling.backend.service.SimulacionService;

@RestController
@RequestMapping("/api/simulaciones")
@CrossOrigin({"*"})
public class SimulacionController {

    private final SimulacionService simulacionService;

    public SimulacionController(SimulacionService simulacionService) {
        this.simulacionService = simulacionService;
    }

    @GetMapping
    public ResponseEntity<List<SimulacionResponseDTO>> getAllSimulaciones() {
        List<SimulacionResponseDTO> simulaciones = simulacionService.findAllSimulaciones();
        return new ResponseEntity<>(simulaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulacionResponseDTO> getSimulacionById(@PathVariable String id) {
        SimulacionResponseDTO simulacion = simulacionService.findSimulacionById(id);
        return new ResponseEntity<>(simulacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SimulacionResponseDTO> createSimulacion(@RequestBody SimulacionRequestDTO requestDTO) {
        SimulacionResponseDTO created = simulacionService.createSimulacion(requestDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimulacionResponseDTO> updateSimulacion(@PathVariable String id, @RequestBody SimulacionRequestDTO requestDTO) {
        SimulacionResponseDTO updated = simulacionService.updateSimulacion(id, requestDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSimulacion(@PathVariable String id) {
        simulacionService.deleteSimulacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Procesa un lote de registros JSON de simulacion de manera optima y rapida.
     * 
     * Este endpoint recibe una lista de objetos de simulacion en formato JSON y los procesa
     * de forma concurrente utilizando hilos para mejorar el rendimiento.
     * 
     * @param simulaciones Lista de objetos {@link SimulacionesRequestDTO} que contiene los datos de simulación a procesar.
     * @return ResponseEntity con un mensaje indicando que el procesamiento ha comenzado.
     *              - {@code 200 OK} si el procesamiento se inicia correctamente.
     */
    @PostMapping("/procesar")
    public ResponseEntity<String> processSimulaciones(@RequestBody List<SimulacionRequestDTO> simulaciones) {
        simulacionService.procesarSimulacionesConThreads(simulaciones);
        return new ResponseEntity<>("Procesamiento iniciado. Ver consola para detalles.", HttpStatus.OK);
    }

    /**
     * Carga simulaciones desde un archivo JSONL y las registra en la base de datos de forma concurrente.
     *
     * Este endpoint permite subir un archivo JSONL en el cual cada línea representa un registro JSON.
     * Cada registro se deserializa a un objeto {@code SimulacionRequestDTO} y se procesa de forma asíncrona
     * utilizando hilos, aprovechando un executor personalizado para mejorar el rendimiento.
     *
     * @param file Archivo JSONL con los registros de simulación. Debe enviarse como un parámetro de tipo {@code multipart/form-data}.
     * @return ResponseEntity que contiene una lista de objetos {@link SimulacionResponseDTO} con el resultado del registro,
     *         o un estado {@code 500 INTERNAL_SERVER_ERROR} en caso de error.
     */
    @PostMapping("/jsonl/procesar")
    public ResponseEntity<List<SimulacionResponseDTO>> uploadSimulacionesFromJsonl(@RequestParam("file") MultipartFile file) {
        try {
            List<SimulacionResponseDTO> resultados = simulacionService.uploadSimulacionesFromJsonl(file);
            return new ResponseEntity<>(resultados, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Descargar todos los registros de la tabla en un archivo CSV.
     * 
     * Este endpoint permite a los usuarios descargar un archivo CSV
     * que contiene todos los registros de la tabla relacionada con las simulaciones
     * 
     * @return ResponseEntity que contiene el archivo CSV como un recursos descargable.
     *              - {@code 200 OK} si el archivo se genera correctamente.
     *              - {@code 500 INTERNAL_SERVER_ERROR} si ocurre un error durante la generacion del archivo.
     */
    @GetMapping("/descargar")
    public ResponseEntity<Resource> downloadCsvFile() {
        try {
            Resource file = simulacionService.descargarCsvFile();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=simulaciones.csv")
                    .contentType(MediaType.parseMediaType("text/csv"))
                    .body(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}