package pauta.teste.sicredi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pauta.teste.sicredi.controller.dto.VotoDTO;
import pauta.teste.sicredi.controller.mapper.VotoMapper;
import pauta.teste.sicredi.domain.Votos;
import pauta.teste.sicredi.services.VotoService;

@RestController
@RequestMapping(value = "api/v1/voto")
public class VotoApi {

    private final VotoService votoService;

    @Autowired
    public VotoApi(VotoService votoService) { this.votoService = votoService; }

    @PostMapping("realizarVoto")
    public ResponseEntity<Object> realizarVoto(@RequestBody VotoDTO votoDTO) {
        Votos voto = votoService.realizarVoto(VotoMapper.toVoto(votoDTO));
        return new ResponseEntity<>(VotoMapper.toVotoDto(voto), HttpStatus.CREATED);
    }

}
