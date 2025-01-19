package emsi.projet.commandeservicev2.controller;

import emsi.projet.commandeservicev2.entities.Commandev2;
import emsi.projet.commandeservicev2.feign.ProductServiceClient;
import emsi.projet.commandeservicev2.service.Commandev2Service;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/commandes") // Pas besoin d'ajouter "/api", car il est ajouté par spring.data.rest.base-path
public class Commandev2Controller {

    private final Commandev2Service commandev2Service;
    private final ProductServiceClient productServiceClient;

    public Commandev2Controller(Commandev2Service commandev2Service, ProductServiceClient productServiceClient) {
        this.commandev2Service = commandev2Service;
        this.productServiceClient = productServiceClient;
    }

    // Fetch all commandes
    @GetMapping
    public List<Commandev2> getAllCommandes() {
        return commandev2Service.getAllCommandes();
    }

    // Fetch a single commande by ID
    @GetMapping("/{id}")
    public Commandev2 getCommandeById(@PathVariable Long id) {
        return commandev2Service.getCommandeById(id).orElseThrow(() -> new RuntimeException("Commande not found"));
    }

    // Create a new commande
    @PostMapping
    public Commandev2 createCommande(@RequestBody Commandev2 commande) {
        // Example: Validate product existence via Feign
        Object product = productServiceClient.getProductById(commande.getIdProduit());
        if (product == null) throw new RuntimeException("Product not found");
        return commandev2Service.saveCommande(commande);
    }

    // Update an existing commande
    @PutMapping("/{id}")
    public Commandev2 updateCommande(@PathVariable Long id, @RequestBody Commandev2 commande) {
        commande.setId(id);
        return commandev2Service.saveCommande(commande);
    }

    // Delete a commande
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandev2Service.deleteCommande(id);
    }





}