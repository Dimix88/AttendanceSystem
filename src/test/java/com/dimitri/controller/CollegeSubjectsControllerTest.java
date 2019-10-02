package com.dimitri.controller;

import com.dimitri.domain.CollegeSubjects;
import com.dimitri.factory.SubjectsFactory;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class CollegeSubjectsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/subjects";

    @Test
    public void a_create() {
        CollegeSubjects collegeSubjects = SubjectsFactory.getSubjects("2019","20");

        ResponseEntity<CollegeSubjects> postResponse = restTemplate.postForEntity(baseURL + "/create", collegeSubjects, CollegeSubjects.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        CollegeSubjects collegeSubjects = restTemplate.getForObject(baseURL + "/collegeSubjects/" + id, CollegeSubjects.class);

        restTemplate.put(baseURL + "/collegeSubjects/" + id, collegeSubjects);
        CollegeSubjects updatedCollegeSubjects = restTemplate.getForObject(baseURL + "/CollegeSubjects/" + id, CollegeSubjects.class);
        assertNotNull(updatedCollegeSubjects);
    }

    @Test
    public void c_read() {
        CollegeSubjects collegeSubjects = restTemplate.getForObject(baseURL + "/collegeSubjects/1", CollegeSubjects.class);
        System.out.println(collegeSubjects.getSubName());
        assertNotNull(collegeSubjects);
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
        CollegeSubjects collegeSubjects = restTemplate.getForObject(baseURL + "/subjects2/" + id, CollegeSubjects.class);
        assertNotNull(collegeSubjects);
        restTemplate.delete(baseURL + "/subjects2/" + id);
        try {
            collegeSubjects = restTemplate.getForObject(baseURL + "/subjects2/" + id, CollegeSubjects.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}