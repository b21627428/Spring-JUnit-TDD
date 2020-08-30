package yte.tdd.tdd.unittest.person;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import yte.tdd.tdd.unittest.EntityBuilder;
import yte.tdd.tdd.model.Person;
import yte.tdd.tdd.model.Product;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class TestPerson {

    @Test
    public void testCreatePerson(){
        Person person = EntityBuilder.createPerson();
        Assert.assertNotNull(person);
    }

    @Test
    public void testPersonCanHaveProducts(){
        Person person = EntityBuilder.createPerson();
        Product product = EntityBuilder.createProduct();
        person.addProducts(Arrays.asList(product));

        Assert.assertEquals(1,person.getProductSet().size());
    }
}
