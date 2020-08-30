package yte.tdd.tdd.unittest.expense;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import yte.tdd.tdd.model.Person;
import yte.tdd.tdd.model.Product;
import yte.tdd.tdd.repository.PersonRepository;
import yte.tdd.tdd.repository.ProductRepository;
import yte.tdd.tdd.service.ExpenseService;
import yte.tdd.tdd.service.impl.ExpenseServiceImpl;
import yte.tdd.tdd.unittest.EntityBuilder;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class TestExpense {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ExpenseService expenseService = new ExpenseServiceImpl(personRepository,productRepository);

    @Test
    public void testBuy(){

        Person person = EntityBuilder.createPersonOnlyUsername();
        Product product = EntityBuilder.createProductOnlyId();

        Person personDB = EntityBuilder.createPerson();
        Product productDB = EntityBuilder.createProduct();

        //1.aşama
        Mockito.when(personRepository.findByUsername(person.getUsername())).thenReturn(personDB);
        Mockito.when(productRepository.findByIdIn(Arrays.asList(product.getId()))).thenReturn(Arrays.asList(productDB));

        //2.aşama
        expenseService.buy(person, Arrays.asList(product));

        //3.aşama
        Assert.assertEquals(Integer.valueOf(4),productDB.getStock());
        Assert.assertEquals(new BigDecimal(500),personDB.getMoney());
        Assert.assertEquals(1,personDB.getProductSet().size());

        //4.aşama
        Mockito.verify(personRepository).findByUsername(person.getUsername());
        Mockito.verify(productRepository).findByIdIn(Arrays.asList(product.getId()));
        Mockito.verify(personRepository).save(personDB);
        Mockito.verify(productRepository).saveAll(Arrays.asList(productDB));

        //5.aşama
        Mockito.verifyNoMoreInteractions(personRepository,productRepository);
    }
}
