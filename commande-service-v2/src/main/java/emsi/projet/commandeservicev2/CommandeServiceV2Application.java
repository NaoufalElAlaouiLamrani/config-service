package emsi.projet.commandeservicev2;

import emsi.projet.commandeservicev2.entities.Commandev2;
import emsi.projet.commandeservicev2.repository.Commandev2Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class CommandeServiceV2Application {

    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceV2Application.class, args);
    }

    @Bean
    CommandLineRunner commandeLineRunner (Commandev2Repository commandeRepository){
        return args -> {
            commandeRepository.save(Commandev2.builder().description("Ordinateur").quantite(2).date(LocalDate.now().minusDays(5)).montant(2000).build());
            commandeRepository.save(Commandev2.builder().description("Imprimante").quantite(1).date(LocalDate.now().minusDays(10)).montant(500).build());
            commandeRepository.save(Commandev2.builder().description("Scanner").quantite(1).date(LocalDate.now().minusDays(15)).montant(300).build());
            commandeRepository.save(Commandev2.builder().description("serveur").quantite(1).date(LocalDate.now().minusDays(2)).montant(1000).idProduit(1L).build());
            commandeRepository.findAll().forEach(c->{
                System.out.println("===================================");
                System.out.println(c.getId());
                System.out.println(c.getDescription());
                System.out.println(c.getQuantite());
                System.out.println(c.getDate());
                System.out.println(c.getMontant());
                System.out.println(c.getIdProduit());
                System.out.println("===================================");
            });
        };
    }
}
