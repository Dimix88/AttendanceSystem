package com.dimitri.controller;

import com.dimitri.domain.School;
import com.dimitri.factory.SchoolFactory;
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
public class SchoolControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/school";

    @Test
    public void a_create() {
        School school = SchoolFactory.getSchool("CPUT");

        ResponseEntity<School> postResponse = restTemplate.postForEntity(baseURL + "/create", school, School.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        School school = restTemplate.getForObject(baseURL + "/school/" + id, School.class);

        restTemplate.put(baseURL + "/school/" + id, school);
        School updatedSchool = restTemplate.getForObject(baseURL + "/School/" + id, School.class);
        assertNotNull(updatedSchool);
    }

    @Test
    public void c_read() {
        School school = restTemplate.getForObject(baseURL + "/school/1", School.class);
        System.out.println(school.getSchoolName());
        assertNotNull(school);
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
        School school = restTemplate.getForObject(baseURL + "/schools/" + id, School.class);
        assertNotNull(school);
        restTemplate.delete(baseURL + "/schools/" + id);
        try {
            school = restTemplate.getForObject(baseURL + "/schools/" + id, School.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}