package com.clientui.proxies;

import com.clientui.beans.ProductBean;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "localhost:8084")

public interface MicroserviceProduitsProxy {

//  ProductController.java : Récupérer les memes signatures des méthodes
//  Affiche la liste de tous les produits disponibles : 
//  @GetMapping(value = "/Produits")
//  public List<Product> listeDesProduits()

    @GetMapping(value = "/api/produits")
    String getProduits();
    }
