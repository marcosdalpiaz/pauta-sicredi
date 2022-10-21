package pauta.teste.sicredi.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PautaDTO implements Serializable {

    @JsonProperty("id_pauta")
    private Long id;

    @JsonProperty("pautaNome")
    private String pautaNome;

}
