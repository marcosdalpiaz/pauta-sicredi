package pauta.teste.sicredi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pauta.teste.sicredi.controller.dto.SessaoDTO;
import pauta.teste.sicredi.domain.Pauta;
import pauta.teste.sicredi.repository.PautaRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PautaService {

    PautaRepository pautaRepository;

    public Pauta pautaCadastro(Pauta pauta) {
        String pautaFromDb = pautaRepository.getPautaName(pauta.getPautaNome());
        if (!pauta.getPautaNome().equals(pautaFromDb)) {
            return pautaRepository.save(pauta);
        }
        throw new RuntimeException("Nome já existente para pauta!");
    }

    public Pauta votacao(SessaoDTO sessaoDTO) {
        Pauta pauta = getPautaById(sessaoDTO.getPautaId());
        pauta.votacao(sessaoDTO);
        return pautaRepository.save(pauta);
    }

    public Pauta getPautaById(Long id) {
        return pautaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Pauta não encontrada!");
        });
    }

    public List<Pauta> getPautasAbertas() {
        return pautaRepository.findAllByStatus("ABERTA");
    }

    public Pauta atualizar(Pauta pauta) {
        return this.pautaRepository.save(pauta);
    }
}
