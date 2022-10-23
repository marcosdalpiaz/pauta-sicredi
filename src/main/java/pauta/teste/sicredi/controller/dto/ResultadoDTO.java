package pauta.teste.sicredi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTO implements Serializable {

    @JsonProperty("pauta_id")
    private Long pautaId;

    @JsonProperty("pautaNome")
    private String pautaNome;

    @JsonProperty("status")
    private String pautaStatus;

    @JsonProperty("voto_nao")
    private Integer votoNao;

    @JsonProperty("voto_sim")
    private Integer votoSim;

    @JsonProperty("resultado")
    private String result;

}
