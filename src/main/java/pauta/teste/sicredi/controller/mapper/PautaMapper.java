package pauta.teste.sicredi.controller.mapper;

import pauta.teste.sicredi.controller.dto.PautaDTO;
import pauta.teste.sicredi.domain.Pauta;

public class PautaMapper {

    public static Pauta toPauta(PautaDTO pautaDto) {
        return Pauta.builder()
                .id(pautaDto.getId())
                .pautaNome(pautaDto.getPautaNome())
                .pautaTime(pautaDto.getPautaTime())
                .status(pautaDto.getStatus())
                .build();
    }

    public static PautaDTO toPautaDto(Pauta pauta) {
        return PautaDTO.builder()
                .id(pauta.getId())
                .pautaNome(pauta.getPautaNome())
                .pautaTime(pauta.getPautaTime())
                .status(pauta.getStatus())
                .build();
    }

}
