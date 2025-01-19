package emsi.projet.commandeservicev2.repository;

import emsi.projet.commandeservicev2.entities.Commandev2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface Commandev2Repository extends JpaRepository<Commandev2, Long> {




}
