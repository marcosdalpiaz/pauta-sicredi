package pauta.teste.sicredi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pauta.teste.sicredi.domain.Pauta;

import java.util.List;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

    @Query(value = "SELECT id from pauta WHERE pauta_nome = ?1", nativeQuery = true)
    Long getPautaIdByPautaName(String pautaName);

    @Query(value = "SELECT pauta_nome from pauta WHERE pauta_nome = ?1", nativeQuery = true)
    String getPautaName(String pautaName);

    List<Pauta> findAllByStatus(String status);
}
