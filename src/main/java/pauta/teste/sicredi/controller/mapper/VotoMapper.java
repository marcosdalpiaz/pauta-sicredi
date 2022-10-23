package pauta.teste.sicredi.controller.mapper;

import pauta.teste.sicredi.controller.dto.VotoDTO;
import pauta.teste.sicredi.domain.Votos;

public class VotoMapper {

    public static Votos toVoto(VotoDTO votoDTO) {
        return Votos.builder()
                .usuarioId(votoDTO.getUsuarioId())
                .pautaId(votoDTO.getPautaId())
                .cpf(votoDTO.getCpf())
                .voto(votoDTO.getVoto())
                .build();
    }

    public static VotoDTO toVotoDto(Votos voto) {
        return VotoDTO.builder()
                .usuarioId(voto.getUsuarioId())
                .pautaId(voto.getPautaId())
                .cpf(voto.getCpf())
                .voto(voto.getVoto())
                .build();
    }

}
