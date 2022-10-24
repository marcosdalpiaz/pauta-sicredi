package pauta.teste.sicredi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pauta.teste.sicredi.domain.Votos;

import java.util.List;
import java.util.Optional;

public interface VotoRepository extends JpaRepository<Votos, Long> {

    @Query(value = "SELECT * from votos WHERE pauta_id = ?1 and cpf = ?2", nativeQuery = true)
    Optional<Votos> getVotoByCpf(Long pautaId, String cpf);
}
