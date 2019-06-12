package com.dimitri.controller;

import com.dimitri.domain.Security;
import com.dimitri.factory.SecurityFactory;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SecurityControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/security";

    @Test
    public void a_create() {
        Security security = SecurityFactory.getSecurity("Dimitri"," Ferus","111111","D@gmail.com");

        ResponseEntity<Security> postResponse = restTemplate.postForEntity(baseURL + "/create", security, Security.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Security security = restTemplate.getForObject(baseURL + "/security/" + id, Security.class);

        restTemplate.put(baseURL + "/security/" + id, security);
        Security updatedSecurity = restTemplate.getForObject(baseURL + "/Security/" + id, Security.class);
        assertNotNull(updatedSecurity);
    }

    @Test
    public void c_read() {
        Security security = restTemplate.getForObject(baseURL + "/security/1", Security.class);
        System.out.println(security.getSecurityName());
        assertNotNull(security);
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void e_delete() {
        int id = 2;
        Security security = restTemplate.getForObject(baseURL + "/securities/" + id, Security.class);
        assertNotNull(security);
        restTemplate.delete(baseURL + "/securities/" + id);
        try {
            security = restTemplate.getForObject(baseURL + "/securities/" + id, Security.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}