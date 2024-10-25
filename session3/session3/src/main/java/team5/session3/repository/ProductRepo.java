package team5.session3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team5.session3.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
