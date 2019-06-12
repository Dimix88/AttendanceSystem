package com.dimitri.controller;

import com.dimitri.domain.Subjects;
import com.dimitri.factory.SubjectsFactory;
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
public class SubjectsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/subjects";

    @Test
    public void a_create() {
        Subjects subjects = SubjectsFactory.getSubjects("2019","20");

        ResponseEntity<Subjects> postResponse = restTemplate.postForEntity(baseURL + "/create", subjects, Subjects.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Subjects subjects = restTemplate.getForObject(baseURL + "/subjects/" + id, Subjects.class);

        restTemplate.put(baseURL + "/subjects/" + id, subjects);
        Subjects updatedSubjects = restTemplate.getForObject(baseURL + "/Subjects/" + id, Subjects.class);
        assertNotNull(updatedSubjects);
    }

    @Test
    public void c_read() {
        Subjects subjects = restTemplate.getForObject(baseURL + "/subjects/1", Subjects.class);
        System.out.println(subjects.getSubName());
        assertNotNull(subjects);
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
        Subjects subjects = restTemplate.getForObject(baseURL + "/subjects2/" + id, Subjects.class);
        assertNotNull(subjects);
        restTemplate.delete(baseURL + "/subjects2/" + id);
        try {
            subjects = restTemplate.getForObject(baseURL + "/subjects2/" + id, Subjects.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}