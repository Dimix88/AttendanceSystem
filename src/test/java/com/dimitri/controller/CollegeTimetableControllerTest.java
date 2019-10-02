package com.dimitri.controller;

import com.dimitri.domain.CollegeTimetable;
import com.dimitri.factory.TimetableFactory;
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
public class CollegeTimetableControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/timetable";

    @Test
    public void a_create() {
        CollegeTimetable collegeTimetable = TimetableFactory.getTimetable("10.00","Sunday");

        ResponseEntity<CollegeTimetable> postResponse = restTemplate.postForEntity(baseURL + "/create", collegeTimetable, CollegeTimetable.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        CollegeTimetable collegeTimetable = restTemplate.getForObject(baseURL + "/collegeTimetable/" + id, CollegeTimetable.class);

        restTemplate.put(baseURL + "/timtables/" + id, collegeTimetable);
        CollegeTimetable updatedTable = restTemplate.getForObject(baseURL + "/CollegeTimetable/" + id, CollegeTimetable.class);
        assertNotNull(updatedTable);
    }

    @Test
    public void c_read() {
        CollegeTimetable collegeTimetable = restTemplate.getForObject(baseURL + "/collegeTimetable/1", CollegeTimetable.class);
        System.out.println(collegeTimetable.getTtID());
        assertNotNull(collegeTimetable);
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
        CollegeTimetable collegeTimetable = restTemplate.getForObject(baseURL + "/timetables/" + id, CollegeTimetable.class);
        assertNotNull(collegeTimetable);
        restTemplate.delete(baseURL + "/timetables/" + id);
        try {
            collegeTimetable = restTemplate.getForObject(baseURL + "/timetables/" + id, CollegeTimetable.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}