package pauta.teste.sicredi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

    @JsonProperty("id_usuario")
    private Long usuarioId;

    @JsonProperty("pauta_id")
    private Long pautaId;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("voto")
    private String voto;

}
