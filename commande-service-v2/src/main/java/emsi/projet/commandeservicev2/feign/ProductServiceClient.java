package emsi.projet.commandeservicev2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", path = "/api/produits")
public interface ProductServiceClient {

    @GetMapping
    List<Object> getAllProducts();

    @GetMapping("/{id}")
    Object getProductById(@PathVariable Long id);

    @PostMapping
    Object createProduct(@RequestBody Object product);

    @PutMapping("/{id}")
    Object updateProduct(@PathVariable Long id, @RequestBody Object product);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id);
}
