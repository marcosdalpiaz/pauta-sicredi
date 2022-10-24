package pauta.teste.sicredi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pauta.teste.sicredi.controller.dto.SessaoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pauta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Uma pauta tem vários votos
    @OneToMany(mappedBy = "pautaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Votos> votos;

    @JoinColumn(name = "pautaNome")
    private String pautaNome;

    @Column(name = "status")
    private String status;

    @Column(name = "pautaTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime pautaTime;

    @Column(name = "enviadoParaFila", columnDefinition = "boolean default false")
    private boolean enviadoParaFila;

    public LocalDateTime votacao(SessaoDTO sessaoDTO) {
        this.status = "INICIADA";
        return this.pautaTime = getTime(sessaoDTO);
    }

    private LocalDateTime getTime(SessaoDTO sessaoDTO) {
        if (sessaoDTO.getMinutagem() == null) {
            return LocalDateTime.now().plusMinutes(1);
        } else {
            return LocalDateTime.now().plusMinutes(sessaoDTO.getMinutagem());
        }
    }

    private boolean tempoExcedido() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.isAfter(pautaTime);
    }

    public boolean isClosed() {
        if (pautaFechada() || tempoExcedido()) {
            this.status = "FECHADA";
            return true;
        } else {
            return false;
        }
    }

    private boolean pautaFechada() { return this.status.equalsIgnoreCase("FECHADA"); }

    public boolean naoEnviadoParaFila() {
        return this.enviadoParaFila;
    }

    public Integer getVotosSim() {
        return votos.stream().filter(v -> v.getVoto().equalsIgnoreCase("SIM")).collect(Collectors.toList()).size();
    }

    public Integer getVotosNao() {
        return votos.stream().filter(v -> v.getVoto().equalsIgnoreCase("NÃO")).collect(Collectors.toList()).size();
    }
}
