package pauta.teste.sicredi.controller.mapper;

import pauta.teste.sicredi.controller.dto.VotoDTO;
import pauta.teste.sicredi.domain.Pauta;
import pauta.teste.sicredi.domain.Votos;

public class VotoMapper {

    public static Votos toVoto(VotoDTO votoDTO) {
        return Votos.builder()
                .usuarioId(votoDTO.getUsuarioId())
                .pautaName(votoDTO.getPautaNome())
                .cpf(votoDTO.getCpf())
                .voto(votoDTO.getVoto())
                .build();
    }

    public static VotoDTO toVotoDto(Votos voto) {
        return VotoDTO.builder()
                .usuarioId(voto.getUsuarioId())
                .pautaNome(voto.getPautaName())
                .cpf(voto.getCpf())
                .voto(voto.getVoto())
                .build();
    }

}
