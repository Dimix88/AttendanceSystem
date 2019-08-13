package com.dimitri.controller;

import com.dimitri.domain.Cleaner;
import com.dimitri.factory.CleanerFactory;
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
public class CleanerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/cleaner";

    @Test
    public void a_create() {
        Cleaner cleaner = CleanerFactory.getCleaner("Dimitri"," Ferus","111111","D@gmail.com");

        ResponseEntity<Cleaner> postResponse = restTemplate.postForEntity(baseURL + "/create", cleaner, Cleaner.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/cleaner/" + id, Cleaner.class);

        restTemplate.put(baseURL + "/cleaners/" + id, cleaner);
        Cleaner updatedCleaner = restTemplate.getForObject(baseURL + "/Cleaner/" + id, Cleaner.class);
        assertNotNull(updatedCleaner);
    }

    @Test
    public void c_read() {
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/cleaner/1", Cleaner.class);
        System.out.println(cleaner.getCleanerName());
        assertNotNull(cleaner);
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void e_delete() {
        int id = 2;
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/cleaners/" + id, Cleaner.class);
        assertNotNull(cleaner);
        restTemplate.delete(baseURL + "/cleaners/" + id);
        try {
            cleaner = restTemplate.getForObject(baseURL + "/students/" + id, Cleaner.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}