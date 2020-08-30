package yte.tdd.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.tdd.tdd.model.Category;
import yte.tdd.tdd.model.AbstractEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.function.Predicate;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "VALUE")
    private BigDecimal value;

    @Column(name = "STOCK")
    private Integer stock;

    public Product(long id) {
        this.setId(id);
    }
//    public static Predicate<Product> isStockNotEnoughPredicate(Product product){
//        return p -> p.stock == 0;
//    }
    public boolean isStockNotEnough(){
        return stock == 0;
    }
}
