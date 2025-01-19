package emsi.projet.productservice.controller;

import emsi.projet.productservice.service.ProduitService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/produits")
@RefreshScope
public class ProduitController {

    private final ProduitService produitService;
    private static final Logger log = LoggerFactory.getLogger(ProduitController.class);

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @CircuitBreaker(name = "produitService", fallbackMethod = "fallbackGetProduits")
    @GetMapping("/{id}")
    public String getProduitById(@PathVariable Long id) throws InterruptedException {
        log.info("Processing request for ID: {}", id);
        // Simulate a long delay
        Thread.sleep(5000);
        log.info("Returning product details for ID: {}", id);
        return "Produit with ID: " + id;
    }

    // Fallback method
    public List<String> fallbackGetProduits(Long id, Throwable throwable) {
        log.error("Fallback triggered for ID: {} due to {}", id, throwable.getMessage());
        return Arrays.asList("Service temporarily unavailable. Please try again later.");
    }
}
