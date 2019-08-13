package com.dimitri.controller;

import com.dimitri.domain.Course;
import com.dimitri.factory.CourseFactory;
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
public class CourseControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/course";

    @Test
    public void a_create() {
        Course course = CourseFactory.getCourse("Marketing");

        ResponseEntity<Course> postResponse = restTemplate.postForEntity(baseURL + "/create", course, Course.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Course course = restTemplate.getForObject(baseURL + "/course/" + id, Course.class);

        restTemplate.put(baseURL + "/course/" + id, course);
        Course updatedCourse = restTemplate.getForObject(baseURL + "/Course/" + id, Course.class);
        assertNotNull(updatedCourse);
    }

    @Test
    public void c_read() {
        Course course = restTemplate.getForObject(baseURL + "/course/1", Course.class);
        System.out.println(course.getCourseName());
        assertNotNull(course);
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
        Course course = restTemplate.getForObject(baseURL + "/courses/" + id, Course.class);
        assertNotNull(course);
        restTemplate.delete(baseURL + "/courses/" + id);
        try {
            course = restTemplate.getForObject(baseURL + "/courses/" + id, Course.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}