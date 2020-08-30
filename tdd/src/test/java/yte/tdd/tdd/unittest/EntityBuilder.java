package yte.tdd.tdd.unittest;

import yte.tdd.tdd.model.Category;
import yte.tdd.tdd.model.Person;
import yte.tdd.tdd.model.Product;

import java.math.BigDecimal;
import java.util.HashSet;

public class EntityBuilder {

    public static Person createPerson(){
        return new Person("avenged","sevenfold","as@as.com",new BigDecimal(9500), new HashSet<>());
    }
    public static Product createProduct(){
        return new Product("ESP", Category.ELECTRONICS,new BigDecimal(9000),5);
    }
    public static Person createPersonOnlyUsername(){
        return new Person("avenged");
    }
    public static Product createProductOnlyId(){
        return new Product(1L);
    }
}
