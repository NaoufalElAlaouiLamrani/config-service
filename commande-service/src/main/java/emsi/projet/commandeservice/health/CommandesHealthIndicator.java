package emsi.projet.commandeservice.health;

import emsi.projet.commandeservice.repository.CommandeRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class CommandesHealthIndicator implements HealthIndicator {

    private final CommandeRepository commandeRepository;

    // Injection du repository via le constructeur
    public CommandesHealthIndicator(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Health health() {
        // Utiliser la méthode count() du repository
        long count = commandeRepository.count();

        if (count > 0) {
            return Health.up()
                    .withDetail("message", "Le microservice contient des commande.")
                    .withDetail("commandeCount", count)
                    .build();
        } else {
            return Health.down()
                    .withDetail("message", "Aucune commande trouvée dans la table COMMANDE.")
                    .build();
        }
    }
}
