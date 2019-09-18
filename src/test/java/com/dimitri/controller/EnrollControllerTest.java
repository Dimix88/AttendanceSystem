package com.dimitri.controller;

import com.dimitri.domain.Enroll;
import com.dimitri.factory.EnrollFactory;
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
public class EnrollControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/enroll";

    @Test
    public void a_create() {
        Enroll enroll = EnrollFactory.getEnroll("2222"," 1111","11/09/19","90");

        ResponseEntity<Enroll> postResponse = restTemplate.withBasicAuth("admin","admin").postForEntity(baseURL + "/create", enroll, Enroll.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.toString());
    }

    @Test
    public void b_update() {
        int id = 1;
        Enroll enroll = restTemplate.getForObject(baseURL + "/enroll/" + id, Enroll.class);

        restTemplate.put(baseURL + "/enrolls/" + id, enroll);
        Enroll updatedEnroll = restTemplate.getForObject(baseURL + "/Enroll/" + id, Enroll.class);
        assertNotNull(updatedEnroll);
    }

    @Test
    public void c_read() {
        Enroll enroll = restTemplate.withBasicAuth("admin","admin").getForObject(baseURL + "/enroll/1", Enroll.class);
        System.out.println(enroll.getCourseCode());
        assertNotNull(enroll);
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
        Enroll enroll = restTemplate.getForObject(baseURL + "/enrolls/" + id, Enroll.class);
        assertNotNull(enroll);
        restTemplate.delete(baseURL + "/enrolls/" + id);
        try {
            enroll = restTemplate.getForObject(baseURL + "/enrolls/" + id, Enroll.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}