package pauta.teste.sicredi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
}
