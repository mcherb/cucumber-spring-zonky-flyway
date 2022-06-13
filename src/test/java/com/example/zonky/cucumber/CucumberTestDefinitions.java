package com.example.zonky.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.FlywayTestExecutionListener;
import org.flywaydb.test.annotation.FlywayTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static org.assertj.core.api.Assertions.assertThat;

@FlywayTest
@TestExecutionListeners(FlywayTestExecutionListener.class)
@SpringBootTest
@CucumberContextConfiguration
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
public class CucumberTestDefinitions {

    @Autowired
    private AnyEntityRepository repository;

    @Given("^Create entities$")
    public void saveData() {
        AnyEntity entity1 = new AnyEntity();
        entity1.setId(1L);
        entity1.setName("E1");

        AnyEntity entity2 = new AnyEntity();
        entity2.setId(2L);
        entity2.setName("E2");

        AnyEntity entity3 = new AnyEntity();
        entity3.setId(3L);
        entity3.setName("E3");

        repository.saveAll(List.of(entity1, entity2, entity3));
    }

    @Then("^Count entities equals 3$")
    public void assertDataCount() {
        assertThat(repository.count()).isEqualTo(3);
    }
}
