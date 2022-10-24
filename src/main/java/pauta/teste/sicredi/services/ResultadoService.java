package pauta.teste.sicredi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pauta.teste.sicredi.controller.dto.ResultadoDTO;
import pauta.teste.sicredi.domain.Pauta;
import pauta.teste.sicredi.domain.Votos;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultadoService {

    PautaService pautaService;

    public ResultadoDTO resultadoSessao(Long id) {
        Pauta pauta = pautaService.getPautaById(id);
        return calculaResultadoSessao(pauta);
    }

    private ResultadoDTO calculaResultadoSessao(Pauta pauta) {

        String resultadoSessao;

        if (pauta.getVotosSim().equals(pauta.getVotosNao())) {
            resultadoSessao = "Sessão Empatada!";
        } else if(pauta.getVotosSim() > pauta.getVotosNao()) {
            resultadoSessao = "Mais votos SIM!";
        } else {
            resultadoSessao = "Mais votos NÃO!";
        }

        return ResultadoDTO.builder()
                .pautaId(pauta.getId())
                .pautaNome(pauta.getPautaNome())
                .pautaStatus(pauta.getStatus())
                .votoNao(pauta.getVotosNao())
                .votoSim(pauta.getVotosSim())
                .result(resultadoSessao)
                .build();
    }

    public void atualizaResult(ResultadoDTO resultadoDTO) {
        resultadoDTO.setPautaStatus("FECHADA");
    }
}
