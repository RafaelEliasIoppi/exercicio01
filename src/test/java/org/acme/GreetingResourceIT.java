package org.acme;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest // Indica que é um teste de integração
public class GreetingResourceIT extends ConversionResourceTest {
    // Todos os testes de ConversionResourceTest serão herdados e executados aqui
}
