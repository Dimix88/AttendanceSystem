package com.dimitri.controller;

import org.junit.Test;
import com.dimitri.domain.Address;
import com.dimitri.factory.AddressFactory;
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
public class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/address";

    @Test
    public void a_create() {
        Address address = AddressFactory.getAddress("MarksStreet"," PO Box 22","Cape Town","Western Cape");

        ResponseEntity<Address> postResponse = restTemplate.withBasicAuth("admin","admin").postForEntity(baseURL + "/create", address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        String strName= "MarkStreet";
        Address address = restTemplate.getForObject(baseURL + "/address/" + strName, Address.class);

        restTemplate.put(baseURL + "/address/" + strName, address);
        Address updatedAddress = restTemplate.getForObject(baseURL + "/Address/" + strName, Address.class);
        assertNotNull(updatedAddress);
    }

    @Test
    public void c_read() {
        Address address = restTemplate.withBasicAuth("admin","admin").getForObject(baseURL + "/address/", Address.class);
        System.out.println(address.getStreetAddres());
        assertNotNull(address);
    }

    @Test
    public void d_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","admin").exchange(baseURL + "/getAll/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void e_delete() {
        String strName= "MarkStreet";
        Address address = restTemplate.getForObject(baseURL + "/address/" + strName, Address.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/addresses/" + strName);
        try {
            address = restTemplate.getForObject(baseURL + "/addresses/" + strName, Address.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}