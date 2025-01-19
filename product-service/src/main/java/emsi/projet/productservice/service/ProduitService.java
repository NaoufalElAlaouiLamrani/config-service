package emsi.projet.productservice.service;



import org.springframework.stereotype.Service;

import emsi.projet.productservice.repository.ProduitRepository;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;


    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;

    }


}