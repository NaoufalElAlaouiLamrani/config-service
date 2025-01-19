package emsi.projet.commandeservice.repository;

import emsi.projet.commandeservice.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;


@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long> {


    List<Commande> findByDateGreaterThanEqual(LocalDate dateLimite);

    long count();


}
