package com.clientui.controller;

import com.clientui.proxies.MicroserviceProduitsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceProduitsProxy produitsProxy;

    @GetMapping("/")
    public String accueil(Model model) {
        // Appeler le proxy pour récupérer les produits
        String produits = produitsProxy.getProduits();

        // Ajouter les produits au modèle pour l'envoyer à la vue
        model.addAttribute("produits", produits);

        // Retourner la vue Accueil.html (ou tout autre nom de vue)
        return "Accueil";
    }
}
