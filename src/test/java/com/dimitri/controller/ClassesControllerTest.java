package com.dimitri.controller;

import com.dimitri.domain.Classes;
import com.dimitri.factory.ClassesFactory;
import org.junit.Test;
import org.junit.Ignore;
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
public class ClassesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/classes";

    @Test
    public void a_create() {
        Classes classes = ClassesFactory.getClasses("122"," 222","10.30");

        ResponseEntity<Classes> postResponse = restTemplate.postForEntity(baseURL + "/create", classes, Classes.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Classes classes = restTemplate.getForObject(baseURL + "/classes/" + id, Classes.class);

        restTemplate.put(baseURL + "/classes/" + id, classes);
        Classes updatedClasses = restTemplate.getForObject(baseURL + "/Classes/" + id, Classes.class);
        assertNotNull(updatedClasses);
    }

    @Test
    public void c_read() {
        Classes classes = restTemplate.getForObject(baseURL + "/classes/1", Classes.class);
        System.out.println(classes.getClass());
        assertNotNull(classes);
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
        Classes classes = restTemplate.getForObject(baseURL + "/classes1/" + id, Classes.class);
        assertNotNull(classes);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            classes = restTemplate.getForObject(baseURL + "/classes1/" + id, Classes.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}