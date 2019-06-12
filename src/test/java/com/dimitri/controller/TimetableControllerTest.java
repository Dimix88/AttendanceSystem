package com.dimitri.controller;

import com.dimitri.domain.Timetable;
import com.dimitri.factory.TimetableFactory;
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
public class TimetableControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/timetable";

    @Test
    public void a_create() {
        Timetable timetable = TimetableFactory.getTimetable("10.00","Sunday");

        ResponseEntity<Timetable> postResponse = restTemplate.postForEntity(baseURL + "/create", timetable, Timetable.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Timetable timetable = restTemplate.getForObject(baseURL + "/timetable/" + id, Timetable.class);

        restTemplate.put(baseURL + "/timtables/" + id, timetable);
        Timetable updatedTable = restTemplate.getForObject(baseURL + "/Timetable/" + id, Timetable.class);
        assertNotNull(updatedTable);
    }

    @Test
    public void c_read() {
        Timetable timetable = restTemplate.getForObject(baseURL + "/timetable/1", Timetable.class);
        System.out.println(timetable.getTtID());
        assertNotNull(timetable);
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
        Timetable timetable = restTemplate.getForObject(baseURL + "/timetables/" + id, Timetable.class);
        assertNotNull(timetable);
        restTemplate.delete(baseURL + "/timetables/" + id);
        try {
            timetable = restTemplate.getForObject(baseURL + "/timetables/" + id, Timetable.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}