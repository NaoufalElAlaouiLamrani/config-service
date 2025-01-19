package emsi.projet.commandeservice.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mes-config-ms")
@Data
public class CommandeProperties {

    private int commandesLast;


    @PostConstruct
    public void logProperties() {
        System.out.println("Valeur de commandesLast : " + commandesLast);
    }


}
