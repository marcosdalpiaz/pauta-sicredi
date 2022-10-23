package pauta.teste.sicredi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pauta.teste.sicredi.controller.dto.ResultadoDTO;
import pauta.teste.sicredi.domain.Pauta;

@Service
@EnableScheduling
public class ScheduleService {

    private PautaService pautaService;
    private ResultadoService resultadoService;
    private OutboundEventProducer outboundEventProducer;

    @Scheduled(fixedDelay = 1000)
    public void pautaScheduler() {
        pautaService.getPautasAbertas().stream()
                .filter(Pauta::isClosed)
                .filter(Pauta::naoEnviadoParaFila).forEach(pauta -> {
                    ResultadoDTO resultadoDTO = resultadoService.resultadoSessao(pauta.getId());
                    resultadoService.atualizaResult(resultadoDTO);
                    try {
                        outboundEventProducer.outboundEvent(convertToJson(resultadoDTO));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    setEnvioParaFila(pauta);
                    pautaService.atualizar(pauta);
                });
    }

    private String convertToJson(ResultadoDTO resultadoDTO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(resultadoDTO);
        return jsonString;
    }

    private void setEnvioParaFila(Pauta pauta) {
        pauta.setEnviadoParaFila(true);
    }
}
