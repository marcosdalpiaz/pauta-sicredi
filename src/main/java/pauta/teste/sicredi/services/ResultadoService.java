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

        Integer votosSim = retornaVotosPorTipo(pauta.getVotos(), "Sim");
        Integer votosNao = retornaVotosPorTipo(pauta.getVotos(), "Não");
        String resultadoSessao;

        if (votosSim.equals(votosNao)) {
            resultadoSessao = "Sessão Empatada!";
        } else if(votosSim > votosNao) {
            resultadoSessao = "Votos SIM venceram!";
        } else {
            resultadoSessao = "Votos NÃO venceram!";
        }

        return ResultadoDTO.builder()
                .pautaId(pauta.getId())
                .pautaNome(pauta.getPautaNome())
                .pautaStatus(pauta.getStatus())
                .votoNao(votosNao)
                .votoSim(votosSim)
                .result(resultadoSessao)
                .build();
    }

    private Integer retornaVotosPorTipo(Set<Votos> votos, String tipo) {

        List<Votos> votosPorTipo = votos.stream().filter(voto -> tipo.equalsIgnoreCase(voto.getVoto())).collect(Collectors.toList());
        return votosPorTipo.size();
    }

    public void atualizaResult(ResultadoDTO resultadoDTO) {
        resultadoDTO.setPautaStatus("Pauta Fechada");
    }


}
