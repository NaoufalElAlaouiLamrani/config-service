package emsi.projet.commandeservicev2.service;


import emsi.projet.commandeservicev2.entities.Commandev2;
import emsi.projet.commandeservicev2.repository.Commandev2Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Commandev2Service {

    private final Commandev2Repository commandev2Repository;


    public Commandev2Service(Commandev2Repository commandev2Repository) {
        this.commandev2Repository = commandev2Repository;

    }

    public List<Commandev2> getAllCommandes() {
        return commandev2Repository.findAll();
    }

    public Optional<Commandev2> getCommandeById(Long id) {
        return commandev2Repository.findById(id);
    }

    public Commandev2 saveCommande(Commandev2 commande) {
        return commandev2Repository.save(commande);
    }

    public void deleteCommande(Long id) {
        commandev2Repository.deleteById(id);
    }


}