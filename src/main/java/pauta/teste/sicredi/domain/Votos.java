package pauta.teste.sicredi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Votos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usuario_id")
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "pauta_id", referencedColumnName = "id")
    private Pauta pautaId;

    @Column(name = "voto")
    private String voto;

    @Column(name = "CPF")
    private String cpf;

}
