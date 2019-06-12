package com.dimitri.controller;

import com.dimitri.domain.GradeReport;
import com.dimitri.factory.GradeReportFactory;
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
public class GradeReportControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/gradereport";

    @Test
    public void a_create() {
        GradeReport gradeReport = GradeReportFactory.getGradeReport("A"," 95");

        ResponseEntity<GradeReport> postResponse = restTemplate.postForEntity(baseURL + "/create", gradeReport, GradeReport.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        GradeReport gradeReport = restTemplate.getForObject(baseURL + "/gradeReport/" + id, GradeReport.class);

        restTemplate.put(baseURL + "/gradeReport/" + id, gradeReport);
        GradeReport updatedGradereport = restTemplate.getForObject(baseURL + "/GradeReport/" + id, GradeReport.class);
        assertNotNull(updatedGradereport);
    }

    @Test
    public void c_read() {
        GradeReport gradeReport = restTemplate.getForObject(baseURL + "/gradeReport/1", GradeReport.class);
        System.out.println(gradeReport.getGradeLetter());
        assertNotNull(gradeReport);
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
        GradeReport gradeReport = restTemplate.getForObject(baseURL + "/gradeReports/" + id, GradeReport.class);
        assertNotNull(gradeReport);
        restTemplate.delete(baseURL + "/gradeReports/" + id);
        try {
            gradeReport = restTemplate.getForObject(baseURL + "/gradeReports/" + id, GradeReport.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}