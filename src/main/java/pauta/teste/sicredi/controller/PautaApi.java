package pauta.teste.sicredi.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pauta.teste.sicredi.controller.dto.PautaDTO;
import pauta.teste.sicredi.controller.mapper.PautaMapper;
import pauta.teste.sicredi.domain.Pauta;
import pauta.teste.sicredi.services.PautaService;

import static pauta.teste.sicredi.controller.mapper.PautaMapper.toPautaDto;

@RestController
@RequestMapping(value = "api/v1/pauta")
public class PautaApi {

    private final PautaService pautaService;

    @Autowired
    public PautaApi(PautaService pautaService) { this.pautaService = pautaService; }

    @PostMapping("cadastroPauta")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastroPauta(@RequestBody PautaDTO pautaDTO) {
        Pauta cadastro = pautaService.pautaCadastro(PautaMapper.toPauta(pautaDTO));
        return new ResponseEntity<>(toPautaDto(cadastro), HttpStatus.CREATED);
    }

}
