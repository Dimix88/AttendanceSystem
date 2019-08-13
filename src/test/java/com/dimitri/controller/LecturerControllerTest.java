package com.dimitri.controller;

import com.dimitri.domain.Lecturer;
import com.dimitri.factory.LecturerFactory;
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
public class LecturerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/lecturer";

    @Test
    public void a_create() {
        Lecturer lecturer = LecturerFactory.getLecturer("Dimitri"," Ferus","111111","D@gmail.com");

        ResponseEntity<Lecturer> postResponse = restTemplate.postForEntity(baseURL + "/create", lecturer, Lecturer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Lecturer lecturer = restTemplate.getForObject(baseURL + "/lecturer/" + id, Lecturer.class);

        restTemplate.put(baseURL + "/lecturer/" + id, lecturer);
        Lecturer updatedLecturer = restTemplate.getForObject(baseURL + "/Lecturer/" + id, Lecturer.class);
        assertNotNull(updatedLecturer);
    }

    @Test
    public void c_read() {
        Lecturer lecturer = restTemplate.getForObject(baseURL + "/lecturer/1", Lecturer.class);
        System.out.println(lecturer.getFirstName());
        assertNotNull(lecturer);
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
        Lecturer lecturer = restTemplate.getForObject(baseURL + "/lecturers/" + id, Lecturer.class);
        assertNotNull(lecturer);
        restTemplate.delete(baseURL + "/lecturers/" + id);
        try {
            lecturer = restTemplate.getForObject(baseURL + "/lecturers/" + id, Lecturer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}