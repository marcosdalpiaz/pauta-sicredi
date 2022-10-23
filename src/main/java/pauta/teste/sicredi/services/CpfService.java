package pauta.teste.sicredi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pauta.teste.sicredi.config.CpfConfig;
import pauta.teste.sicredi.controller.dto.CpfDTO;

@Service
public class CpfService {

    private CpfConfig cpfConfig;
    private RestTemplate restTemplate;

    public void validarCpf(String cpf) {
        String url = cpfConfig.getUrl();
        try {
            CpfDTO cpfDto = restTemplate.getForObject(url, CpfDTO.class);
            checkCpf(cpfDto);
        } catch (HttpClientErrorException exception) {
            throw new RuntimeException("CPF inválido!");
        }
    }

    private void checkCpf(CpfDTO cpfDTO) {
        if (!cpfDTO.getStatus().equalsIgnoreCase("ABLE_TO_VOTE")) {
            throw new RuntimeException("Este CPF não é capaz de votar!");
        }
    }
}
