package com.dimitri.controller;

import com.dimitri.domain.Student;
import com.dimitri.factory.StudentFactory;
import org.junit.*;
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
public class StudentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/student";


    @Test
    public void a_create() {
        Student student = StudentFactory.getStudent("Dimitri"," Ferus","111111","D@gmail.com");

        ResponseEntity<Student> postResponse = restTemplate.postForEntity(baseURL + "/create", student, Student.class);
        Assert.assertEquals(HttpStatus.OK,postResponse.getStatusCode());
        System.out.println(postResponse.toString());

    }

    @Test
    public void b_update() {
        int id = 1;
        Student student = restTemplate.getForObject(baseURL + "/student/" + id, Student.class);

        restTemplate.put(baseURL + "/student/" + id, student);
        Student updatedStudent = restTemplate.getForObject(baseURL + "/Student/" + id, Student.class);
        Assert.assertNotNull(updatedStudent);
    }


    @Test
    public void c_read() {
        Student student = restTemplate.getForObject(baseURL + "/student/1", Student.class);
        System.out.println(student.getStudentName());
        Assert.assertNotNull(student);
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll/all",
                HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
    }


    @Test
    public void e_delete() {
        int id = 2;
        Student student = restTemplate.getForObject(baseURL + "/students/" + id, Student.class);
        assertNotNull(student);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            student = restTemplate.getForObject(baseURL + "/students/" + id, Student.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }


}