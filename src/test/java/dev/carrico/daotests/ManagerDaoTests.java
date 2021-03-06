package dev.carrico.daotests;

import dev.carrico.daos.ManagerDAO;
import dev.carrico.daos.ManagerDaoPostgres;
import dev.carrico.entities.Manager;
import org.junit.jupiter.api.*;

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
