package com.dimitri.controller;

import com.dimitri.domain.Notices;
import com.dimitri.factory.NoticesFactory;
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
public class NoticesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/notices";

    @Test
    public void a_create() {
        Notices notices = NoticesFactory.getNotices("Sleep");

        ResponseEntity<Notices> postResponse = restTemplate.postForEntity(baseURL + "/create", notices, Notices.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Notices notices = restTemplate.getForObject(baseURL + "/notices/" + id, Notices.class);

        restTemplate.put(baseURL + "/notices/" + id, notices);
        Notices updatedNotice = restTemplate.getForObject(baseURL + "/Notices/" + id, Notices.class);
        assertNotNull(updatedNotice);
    }

    @Test
    public void c_read() {
        Notices notices = restTemplate.getForObject(baseURL + "/notices/1", Notices.class);
        System.out.println(notices.getNotice());
        assertNotNull(notices);
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
        Notices notices = restTemplate.getForObject(baseURL + "/notices1/" + id, Notices.class);
        assertNotNull(notices);
        restTemplate.delete(baseURL + "/notices1/" + id);
        try {
            notices = restTemplate.getForObject(baseURL + "/notices1/" + id, Notices.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}