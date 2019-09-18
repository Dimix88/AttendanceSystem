package com.dimitri.controller;

import org.junit.Test;
import com.dimitri.domain.Admin;
import com.dimitri.factory.AdminFactory;
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
public class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/admin";

    @Test
    public void a_create() {
        Admin admin = AdminFactory.getAdmin("2");

        ResponseEntity<Admin> postResponse = restTemplate.withBasicAuth("admin","admin").postForEntity(baseURL + "/create", admin, Admin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.toString());
    }

    @Test
    public void b_update() {
        int id = 1;
        Admin admin = restTemplate.getForObject(baseURL + "/admin/" + id, Admin.class);

        restTemplate.put(baseURL + "/admins/" + id, admin);
        Admin updatedAdmin = restTemplate.getForObject(baseURL + "/Admin/" + id, Admin.class);
        assertNotNull(updatedAdmin);
    }

    @Test
    public void c_read() {
        Admin admin = restTemplate.withBasicAuth("admin","admin").getForObject(baseURL + "/admin/1", Admin.class);
        System.out.println(admin.getAdminLevel());
        assertNotNull(admin);
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","admin").exchange(baseURL + "/getAll/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.toString());
    }

    @Test
    public void e_delete() {
        int id = 2;
        Admin admin = restTemplate.getForObject(baseURL + "/admins/" + id, Admin.class);
        assertNotNull(admin);
        restTemplate.delete(baseURL + "/admins/" + id);
        try {
            admin = restTemplate.getForObject(baseURL + "/admins/" + id, Admin.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}