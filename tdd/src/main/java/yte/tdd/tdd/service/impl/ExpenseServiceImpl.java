package yte.tdd.tdd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yte.tdd.tdd.model.Person;
import yte.tdd.tdd.model.Product;
import yte.tdd.tdd.repository.PersonRepository;
import yte.tdd.tdd.repository.ProductRepository;
import yte.tdd.tdd.service.ExpenseService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private PersonRepository personRepository;
    private ProductRepository productRepository;

    @Autowired
    public ExpenseServiceImpl(PersonRepository personRepository, ProductRepository productRepository) {
        this.personRepository = personRepository;
        this.productRepository = productRepository;
    }



    @Override
    public void buy(Person person, Collection<Product> products) {
        Person personDB =  personRepository.findByUsername(person.getUsername());
        List<Product> productListDB = productRepository.findByIdIn(products.stream().map(Product::getId).collect(Collectors.toList()));

        BigDecimal totalCostOfProducts = productListDB.stream().map(product -> product.getValue()).reduce(BigDecimal.ZERO,BigDecimal::add);

        if(personDB.getMoney().compareTo(totalCostOfProducts) > 0 && productListDB.stream().noneMatch(Product::isStockNotEnough)){
            productListDB.stream().forEach(product -> product.setStock(product.getStock()-1));
            personDB.setMoney(personDB.getMoney().subtract(totalCostOfProducts));
            productRepository.saveAll(productListDB);
            personDB.addProducts(productListDB);
            personRepository.save(personDB);
        }
    }
}
