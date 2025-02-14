package com.assessment.bistro.repository;

import com.assessment.bistro.model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class ServerRepositoryTest {
    Server expectedServer;

    @Autowired
    private ServerRepository repo;


    @BeforeEach
    void setUp() {
        expectedServer = new Server();
        expectedServer.setServerId(19);
        expectedServer.setFirstName("Julina");
        expectedServer.setLastName("O'Luby");
        expectedServer.setHireDate(LocalDate.of(2020,1,1));
        expectedServer.setTermDate(LocalDate.of(2020,7,29));
    }

    @Test
    void testGetServerById() {
        //act
        Optional<Server> foundServer = repo.findById(expectedServer.getServerId());
        //assert
        assertTrue(foundServer.isPresent());
    }
    @Test
    void testGetAllAvailableServers() {
        //act
        List<Server> servers = repo.findAll();
        //assert
        assertFalse(servers.isEmpty());
        assertTrue(servers.contains(expectedServer));
    }

    @Test
    void testUpdateServer() {
        // arrange
        expectedServer.setFirstName("Alice");
        repo.save(expectedServer);

        //act
        Optional<Server> updatedServer = repo.findById(expectedServer.getServerId());

        //assert
        assertTrue(updatedServer.isPresent());
        assertEquals("Alice",updatedServer.get().getFirstName());
    }

    @Test
    void testAddServer() {
        //arrange
        Server newServer = new Server();
        newServer.setFirstName("Steve");
        newServer.setLastName("Austin");
        newServer.setHireDate(LocalDate.of(2025,2,5));
        newServer.setTermDate(null);

        //act
        repo.save(newServer);
        Optional<Server> foundServer = repo.findById(newServer.getServerId());

        //assert
        assertTrue(foundServer.isPresent());
        assertEquals(newServer.getHireDate(),foundServer.get().getHireDate());
    }
}