package emsi.projet.commandeservice.controller;

import emsi.projet.commandeservice.entities.Commande;
import emsi.projet.commandeservice.service.CommandeService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@RefreshScope
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/commandes-derniers-jours")
    public List<Commande> getCommandesDerniersJours() {
        List<Commande> commandes = commandeService.getCommandesDerniersJours();
        System.out.println("Commandes renvoyées par le service : " + commandes); // Ajoutez ce log
        return commandes;
    }
}