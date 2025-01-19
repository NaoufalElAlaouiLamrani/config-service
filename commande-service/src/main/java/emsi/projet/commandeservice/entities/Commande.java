package emsi.projet.commandeservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Commande {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;

}
