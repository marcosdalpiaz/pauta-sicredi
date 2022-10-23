package pauta.teste.sicredi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pauta.teste.sicredi.controller.dto.ResultadoDTO;
import pauta.teste.sicredi.services.ResultadoService;

@RestController
@RequestMapping(value = "api/v1/resultado")
public class ResultadoApi {

    private final ResultadoService resultadoService;

    @Autowired
    public ResultadoApi(ResultadoService resultadoService) { this.resultadoService = resultadoService; }

    @GetMapping(value = "/{resultadoId}")
    public ResponseEntity<Object> resultadoSessao(@PathVariable Long id) {
        ResultadoDTO result = resultadoService.resultadoSessao(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
