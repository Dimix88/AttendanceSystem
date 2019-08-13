package com.dimitri.controller;

import com.dimitri.domain.Room;
import com.dimitri.factory.RoomFactory;
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
public class RoomControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/room";

    @Test
    public void a_create() {
        Room room = RoomFactory.getRoom("big");

        ResponseEntity<Room> postResponse = restTemplate.postForEntity(baseURL + "/create", room, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void b_update() {
        int id = 1;
        Room room = restTemplate.getForObject(baseURL + "/room/" + id, Room.class);

        restTemplate.put(baseURL + "/rooms/" + id, room);
        Room updatedRoom = restTemplate.getForObject(baseURL + "/Room/" + id, Room.class);
        assertNotNull(updatedRoom);
    }

    @Test
    public void c_read() {
        Room room = restTemplate.getForObject(baseURL + "/room/1", Room.class);
        System.out.println(room.getRoomType());
        assertNotNull(room);
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
        Room room = restTemplate.getForObject(baseURL + "/rooms/" + id, Room.class);
        assertNotNull(room);
        restTemplate.delete(baseURL + "/rooms/" + id);
        try {
            room = restTemplate.getForObject(baseURL + "/rooms/" + id, Room.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}