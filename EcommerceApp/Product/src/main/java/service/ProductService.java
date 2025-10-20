package service;

import entity.Product;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProductById (String id){
        return productRepository.findById(id);
    }

    public Product updateProduct (String id, Product product) {
        return productRepository.findById(id).map(existingProduct -> {
                    existingProduct.setProductName(product.getProductName());
                    existingProduct.setProductCurrentPrice(product.getProductCurrentPrice());
                    existingProduct.setProductDetails(product.getProductDetails());
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> {
                    log.error("Product not found with id: " + id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
                });
                }
}
