package pauta.teste.sicredi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import pauta.teste.sicredi.controller.dto.SessaoDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pauta")
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Uma pauta tem vários votos
    @OneToMany(mappedBy = "pauta")
    private Set<Votos> votos;

    @JoinColumn(name = "pautaNome")
    private String pautaNome;

    @Column(name = "status")
    private String pautaStatus;

    @Column(name = "pautaTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime pautaTime;

    public LocalDateTime votacao(SessaoDTO sessaoDTO) {
        this.pautaStatus = "INICIADA";
        return this.pautaTime = getTime(sessaoDTO);
    }

    private LocalDateTime getTime(SessaoDTO sessaoDTO) {
        if (sessaoDTO.getMinutagem() == null) {
            return LocalDateTime.now().plusMinutes(1);
        } else {
            return LocalDateTime.now().plusMinutes(sessaoDTO.getMinutagem());
        }
    }
}
