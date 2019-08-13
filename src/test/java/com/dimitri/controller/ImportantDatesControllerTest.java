package com.dimitri.controller;

import com.dimitri.domain.ImportantDates;
import com.dimitri.factory.ImportantDatesFactory;
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
public class ImportantDatesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/importantDates";

    @Test
    public void a_create() {
        ImportantDates importantDates = ImportantDatesFactory.getImportantDates("12/09/19","12/10/19");

        ResponseEntity<ImportantDates> postResponse = restTemplate.postForEntity(baseURL + "/create", importantDates, ImportantDates.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        ImportantDates importantDates = restTemplate.getForObject(baseURL + "/importantDates/" + id, ImportantDates.class);

        restTemplate.put(baseURL + "/importantDates/" + id, importantDates);
        ImportantDates updatedDates = restTemplate.getForObject(baseURL + "/ImportantDates/" + id, ImportantDates.class);
        assertNotNull(updatedDates);
    }

    @Test
    public void c_read() {
        ImportantDates importantDates = restTemplate.getForObject(baseURL + "/importantDates/1", ImportantDates.class);
        System.out.println(importantDates.getsDate());
        assertNotNull(importantDates);
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
        ImportantDates importantDates = restTemplate.getForObject(baseURL + "/importantDates/" + id, ImportantDates.class);
        assertNotNull(importantDates);
        restTemplate.delete(baseURL + "/importantDates1/" + id);
        try {
            importantDates = restTemplate.getForObject(baseURL + "/importantDates1/" + id, ImportantDates.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}