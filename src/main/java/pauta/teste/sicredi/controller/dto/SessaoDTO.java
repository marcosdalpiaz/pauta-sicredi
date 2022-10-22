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
public class SessaoDTO {

    @JsonProperty("id_pauta")
    private Long pautaId;

    @JsonProperty("minutagem")
    private Integer minutagem;

}
