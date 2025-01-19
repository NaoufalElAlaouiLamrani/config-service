package emsi.projet.commandeservice;

import emsi.projet.commandeservice.entities.Commande;
import emsi.projet.commandeservice.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CommandeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandeLineRunner (CommandeRepository commandeRepository){
        return args -> {
            commandeRepository.save(Commande.builder().description("Ordinateur").quantite(2).date(LocalDate.now().minusDays(5)).montant(2000).build());
            commandeRepository.save(Commande.builder().description("Imprimante").quantite(1).date(LocalDate.now().minusDays(10)).montant(500).build());
            commandeRepository.save(Commande.builder().description("Scanner").quantite(1).date(LocalDate.now().minusDays(15)).montant(300).build());
            commandeRepository.save(Commande.builder().description("serveur").quantite(1).date(LocalDate.now().minusDays(2)).montant(1000).build());
            commandeRepository.findAll().forEach(c->{
                System.out.println("===================================");
                System.out.println(c.getId());
                System.out.println(c.getDescription());
                System.out.println(c.getQuantite());
                System.out.println(c.getDate());
                System.out.println(c.getMontant());
                System.out.println("===================================");
            });
        };
    }
}
