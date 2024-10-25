package team5.session3.model;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name="Products")
@AllArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name;
    private String description;
    private int price;
    private String image;
    private String category;
    private int priceDiscount;
    private int quantity;
    private String unit;

    public void setProduct(Product product) {
         product.setProduct(this);
    }
}
