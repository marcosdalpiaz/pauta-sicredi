package pauta.teste.sicredi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pauta.teste.sicredi.domain.Pauta;
import pauta.teste.sicredi.repository.PautaRepository;

@Service
@AllArgsConstructor
public class PautaService {

    PautaRepository pautaRepository;

    public Pauta pautaCadastro(Pauta pauta) {
        return pautaRepository.save(pauta);
    }
}
