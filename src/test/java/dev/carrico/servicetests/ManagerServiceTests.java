package dev.carrico.servicetests;

import carrico.dev.daos.ManagerDAO;
import carrico.dev.entities.Manager;
import carrico.dev.services.ManagerService;
import carrico.dev.services.ManagerServiceImpl;
import carrico.dev.services.ManagerService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
import java.util.Set;

@MockitoSettings(strictness = Strictness.LENIENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ManagerServiceTests {

    private ManagerService managerService;

    @Mock
    private ManagerDAO managerDao = null;

    @BeforeEach
    void setup(){

        Manager manager = new Manager();
        Mockito.when(this.managerDao.getManagerById(1)).thenReturn(
                new Manager(1, "giovannirocks", "ashismyson")
        );

        Set<Manager> managers = new HashSet<>();
        managers.add(
                new Manager(1, "giovannirocks", "ashismyson")
        );
        managers.add(
                new Manager(2, "ltsurge", "ligthningiscool")
        );

        Mockito.when(this.managerDao.getAllManagers()).thenReturn(managers);

        managerService = new ManagerServiceImpl(managerDao);
    }

    @Order(1)
    @Test
    void get_manager_by_id(){
        Manager testManager = this.managerService.getManagerById(1);

        Assertions.assertNotNull(testManager);
        Assertions.assertEquals(1, testManager.getManagerId());
        System.out.println(testManager);
    }

    @Order(2)
    @Test
    void get_all_managers(){
        Set<Manager> managers = this.managerService.getAllManagers();

        Assertions.assertNotNull(managers);
        Assertions.assertTrue(managers.size() > 0);
        System.out.println(managers);
    }
}
