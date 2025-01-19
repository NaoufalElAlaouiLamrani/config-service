package emsi.projet.productservice;


import emsi.projet.productservice.entities.Produit;
import emsi.projet.productservice.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandeLineRunner (ProduitRepository produitRepository) {
        return args -> {
            produitRepository.save(Produit.builder().nom("prdt1").prix(120).quantiteStock(2).build());
            produitRepository.save(Produit.builder().nom("prdt2").prix(150).quantiteStock(3).build());
            produitRepository.save(Produit.builder().nom("prdt3").prix(200).quantiteStock(4).build());
            produitRepository.save(Produit.builder().nom("prdt4").prix(250).quantiteStock(5).build());
            produitRepository.findAll().forEach(p -> {
                System.out.println("===================================");
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getPrix());
                System.out.println(p.getQuantiteStock());
                System.out.println("===================================");
            });
        };
    }
}
