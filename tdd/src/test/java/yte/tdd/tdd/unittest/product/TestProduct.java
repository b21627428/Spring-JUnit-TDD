package yte.tdd.tdd.unittest.product;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import yte.tdd.tdd.unittest.EntityBuilder;
import yte.tdd.tdd.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class TestProduct {

    @Test
    public void testCreateProduct(){
        Product product = EntityBuilder.createProduct();
        Assert.assertNotNull(product);
    }
}
