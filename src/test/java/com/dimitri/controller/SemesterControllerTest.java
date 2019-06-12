package com.dimitri.controller;

import com.dimitri.domain.Semester;
import com.dimitri.factory.SemesterFactory;
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
public class SemesterControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/semester";

    @Test
    public void a_create() {
        Semester semester = SemesterFactory.getSemester("2019"," 4","01/10/19","12/12/19");

        ResponseEntity<Semester> postResponse = restTemplate.postForEntity(baseURL + "/create", semester, Semester.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Semester semester = restTemplate.getForObject(baseURL + "/semester/" + id, Semester.class);

        restTemplate.put(baseURL + "/semester/" + id, semester);
        Semester updatedSemester = restTemplate.getForObject(baseURL + "/semester/" + id, Semester.class);
        assertNotNull(updatedSemester);
    }

    @Test
    public void c_read() {
        Semester semester = restTemplate.getForObject(baseURL + "/semester/1", Semester.class);
        System.out.println(semester.getSemesterYear());
        assertNotNull(semester);
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
        Semester semester = restTemplate.getForObject(baseURL + "/semesters/" + id, Semester.class);
        assertNotNull(semester);
        restTemplate.delete(baseURL + "/semesters/" + id);
        try {
            semester = restTemplate.getForObject(baseURL + "/semesters/" + id, Semester.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}