package dev.carrico.daotests;

import carrico.dev.daos.ManagerDAO;
import carrico.dev.daos.ManagerDaoPostgres;
import carrico.dev.entities.Manager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManagerDaoTests {

    private final ManagerDAO managerDAO = new ManagerDaoPostgres();



    @Order(2)
    @Test
    void pull_a_karen_by_id(){ //get_manager_by_id
        Manager e = this.managerDAO.getManagerById(2);

        Assertions.assertNotNull(e);
        Assertions.assertEquals(2, e.getManagerId());
    }

    @Order(3)
    @Test
    void karen_goes_super_saiyan(){ //get_all_managers
        Set<Manager> managers = this.managerDAO.getAllManagers();

        System.out.println(managers);
        Assertions.assertNotNull(managers);
        Assertions.assertTrue(managers.size() >= 1);
    }


}
