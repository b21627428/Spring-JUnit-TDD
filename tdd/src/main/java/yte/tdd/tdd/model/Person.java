package yte.tdd.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AbstractEntity {

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "EMAIL")
    private String eMail;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MONEY")
    private BigDecimal money;

    @ManyToMany
    @JoinTable(
            name = "EXPENSE",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )
    private Set<Product> productSet;

    public Person(String username){
        this.username = username;
    }

    public void addProducts(Collection<Product> products) {
        productSet.addAll(products);
    }
}
