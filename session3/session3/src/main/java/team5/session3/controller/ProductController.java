package team5.session3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team5.session3.model.Product;
import team5.session3.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private final ProductRepo productRepo;

    @Autowired
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/getProductList")
    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            List<Product> productList = new ArrayList<>(productRepo.findAll());

            if (productList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productList")
    public String getProductList(Model model) {
        try {
            List<Product> productList = productRepo.findAll();
            model.addAttribute("products", productList);
            return "productList";
        } catch (Exception ex) {
            return "error";
        }
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        try {
            Optional<Product> findProduct =  productRepo.findById(id);
            return findProduct.map(product -> new ResponseEntity<Product>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<Product>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        try {
            List<Product> savedProducts = products.stream()
                    .map(productRepo::save)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @RequestBody Product product) {
       try {
           Optional<Product> findProduct = productRepo.findById(id);

           if (findProduct.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

           Product updateProduct = getProduct(product, findProduct);

           productRepo.save(updateProduct);
           return new ResponseEntity<>("Product updated", HttpStatus.OK);
       } catch (Exception ex) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    private static Product getProduct(Product product, Optional<Product> findProduct) {
        Product updateProduct = findProduct.get();
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setCategory(product.getCategory());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setCategory(product.getCategory());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setQuantity(product.getQuantity());
        return updateProduct;
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        try {
            Optional<Product> findProduct = productRepo.findById(id);

            if (findProduct.isEmpty()) return new ResponseEntity<>("delete error",HttpStatus.NOT_FOUND);
            productRepo.deleteById(id);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

