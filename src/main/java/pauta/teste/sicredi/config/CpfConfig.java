package pauta.teste.sicredi.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class CpfConfig {

    @Value("${cpf.url}")
    private String url;
}
