package com.dimitri.controller;

import com.dimitri.domain.Department;
import com.dimitri.factory.DepartmentFactory;
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
public class DepartmentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/department";

    @Test
    public void a_create() {
        Department department = DepartmentFactory.getDepartment("Marketing","Informatics");

        ResponseEntity<Department> postResponse = restTemplate.postForEntity(baseURL + "/create", department, Department.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Department department = restTemplate.getForObject(baseURL + "/department/" + id, Department.class);

        restTemplate.put(baseURL + "/departments/" + id, department);
        Department updatedDepartment = restTemplate.getForObject(baseURL + "/Department/" + id, Department.class);
        assertNotNull(updatedDepartment);
    }

    @Test
    public void c_read() {
        Department department = restTemplate.getForObject(baseURL + "/department/1", Department.class);
        System.out.println(department.getDeptName());
        assertNotNull(department);
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
        Department department = restTemplate.getForObject(baseURL + "/departments/" + id, Department.class);
        assertNotNull(department);
        restTemplate.delete(baseURL + "/departments/" + id);
        try {
            department = restTemplate.getForObject(baseURL + "/departments/" + id, Department.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}