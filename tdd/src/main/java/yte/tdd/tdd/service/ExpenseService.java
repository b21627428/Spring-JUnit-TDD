package yte.tdd.tdd.service;

import yte.tdd.tdd.model.Person;
import yte.tdd.tdd.model.Product;

import java.util.Collection;
import java.util.List;

public interface ExpenseService {

    void buy(Person person, Collection<Product> products);
}
