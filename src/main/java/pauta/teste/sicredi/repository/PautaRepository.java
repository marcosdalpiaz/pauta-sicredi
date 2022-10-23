package pauta.teste.sicredi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pauta.teste.sicredi.domain.Pauta;

import java.util.List;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

    //List<Pauta> findAllByName(String name);

    List<Pauta> findAllByStatus(String status);
}
