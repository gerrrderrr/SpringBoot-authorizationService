package ru.netology.authorizationservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void devConnection() {
        Integer devAppPort = devApp.getMappedPort(8080);
        ResponseEntity<String> devEntity = restTemplate
                .getForEntity("http://localhost:" + devAppPort + "/profile", String.class);
        String expected = "Welcome to Dev profile";
        String actual = devEntity.getBody();
        assert expected.equals(actual);
    }

    @Test
    void prodConnection() {
        Integer prodAppPort = prodApp.getMappedPort(8081);
        ResponseEntity<String> prodEntity = restTemplate
                .getForEntity("http://localhost:" + prodAppPort + "/profile", String.class);
        String expected = "Welcome to Dev profile";
        String actual = prodEntity.getBody();
        assert expected.equals(actual);
    }
}
