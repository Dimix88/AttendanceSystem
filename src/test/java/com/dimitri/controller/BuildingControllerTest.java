package com.dimitri.controller;

import org.junit.Test;
import com.dimitri.domain.Building;
import com.dimitri.factory.BuildingFactory;
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
public class BuildingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/building";

    @Test
    public void a_create() {
        Building building = BuildingFactory.getBuilding("B2","Cput");

        ResponseEntity<Building> postResponse = restTemplate.postForEntity(baseURL + "/create", building, Building.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Building building = restTemplate.getForObject(baseURL + "/building/" + id, Building.class);

        restTemplate.put(baseURL + "/buildings/" + id, building);
        Building updatedBuilding = restTemplate.getForObject(baseURL + "/Building/" + id, Building.class);
        assertNotNull(updatedBuilding);
    }

    @Test
    public void c_read() {
        Building building = restTemplate.getForObject(baseURL + "/building/1", Building.class);
        System.out.println(building.getBldgName());
        assertNotNull(building);
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
        Building building = restTemplate.getForObject(baseURL + "/buildings/" + id, Building.class);
        assertNotNull(building);
        restTemplate.delete(baseURL + "/buildings/" + id);
        try {
            building = restTemplate.getForObject(baseURL + "/buildings/" + id, Building.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}