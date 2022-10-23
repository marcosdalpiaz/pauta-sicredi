package pauta.teste.sicredi.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PautaDTO implements Serializable {

    @JsonProperty("pauta_id")
    private Long id;

    @JsonProperty("pautaNome")
    private String pautaNome;

    @JsonProperty("status")
    private String status;

    @JsonProperty("pautaTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime pautaTime;
}
