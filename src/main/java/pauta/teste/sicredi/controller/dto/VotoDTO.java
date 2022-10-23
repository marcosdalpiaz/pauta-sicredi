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

    @JsonProperty("id_usuario")
    private Long usuarioId;

    @JsonProperty("pauta_id")
    private Pauta pautaId;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("voto")
    private String voto;

}
