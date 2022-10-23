package pauta.teste.sicredi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pauta.teste.sicredi.domain.Pauta;
import pauta.teste.sicredi.domain.Votos;
import pauta.teste.sicredi.repository.VotoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VotoService {

    private VotoRepository votoRepository;
    private CpfService cpfService;
    private PautaService pautaService;

    public Votos realizarVoto(Votos voto) {
        validarVoto(voto);
        validarPauta(voto.getPautaId().getId());
        return votoRepository.save(voto);
    }

    private void validarPauta(Long pautaId) {
        Pauta pauta = pautaService.getPautaById(pautaId);
        if (pauta.isClosed()) {
            throw new RuntimeException("Esta sessão está fechada!");
        }
    }

    private void validarVoto(Votos voto) {
        Optional<Votos> validandoVotoByCpf = votoRepository.getVotoByCpf(voto.getPautaId().getId(), voto.getCpf());
        votoValido(voto.getVoto());
        votoExistente(validandoVotoByCpf);
        cpfService.validarCpf(voto.getCpf());
    }

    private void votoValido(String voto) {
        if (!(voto.equalsIgnoreCase("Sim") || voto.equalsIgnoreCase("Não"))) {
            throw new RuntimeException("Voto inválido!");
        }
    }

    private void votoExistente(Optional<Votos> voto) {
        if (voto.isPresent()) {
            throw new RuntimeException("Voto existente!");
        }
    }
}
