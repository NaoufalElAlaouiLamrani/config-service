package emsi.projet.commandeservice;

import emsi.projet.commandeservice.entities.Commande;
import emsi.projet.commandeservice.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandeLineRunner (CommandeRepository commandeRepository){
        return args -> {
            commandeRepository.save(Commande.builder().description("Ordinateur").quantite(2).date("2021-09-01").montant(2000).build());
            commandeRepository.save(Commande.builder().description("Imprimante").quantite(1).date("2021-09-01").montant(500).build());
            commandeRepository.save(Commande.builder().description("Scanner").quantite(1).date("2021-09-01").montant(300).build());
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
