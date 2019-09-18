package com.dimitri.controller;

import com.dimitri.domain.Name;
import com.dimitri.factory.NameFactory;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class NameControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/name";

    @Test
    public void a_create() {
        Name name = NameFactory.getName("Dimitri"," Ferus","Ferus");

        ResponseEntity<Name> postResponse = restTemplate.withBasicAuth("admin","admin").postForEntity(baseURL + "/create", name, Name.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.toString());
    }

    @Test
    public void b_update() {
        int id = 1;
        Name name = restTemplate.getForObject(baseURL + "/name/" + id, Name.class);

        restTemplate.put(baseURL + "/names/" + id, name);
        Name updatedName = restTemplate.getForObject(baseURL + "/Name/" + id, Name.class);
        assertNotNull(updatedName);
    }

    @Test
    public void c_read() {
        Name name = restTemplate.withBasicAuth("admin","admin").getForObject(baseURL + "/name/1", Name.class);
        System.out.println(name.getFirstname());
        assertNotNull(name);
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","admin").exchange(baseURL + "/getAll/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.toString());
    }

    @Test
    public void e_delete() {
        int id = 2;
        Name name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        assertNotNull(name);
        restTemplate.delete(baseURL + "/names/" + id);
        try {
            name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}