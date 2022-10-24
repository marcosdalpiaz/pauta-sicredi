package pauta.teste.sicredi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pauta.teste.sicredi.domain.Pauta;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

    @JsonProperty("usuarioId")
    private Long usuarioId;

    @JsonProperty("pautaNome")
    private String pautaNome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("voto")
    private String voto;

}
