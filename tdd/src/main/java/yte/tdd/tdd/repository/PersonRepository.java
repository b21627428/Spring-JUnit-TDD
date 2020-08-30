package yte.tdd.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yte.tdd.tdd.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {


    Person findByUsername(String username);
}
