package carrico.dev.daos;

import carrico.dev.entities.Manager;

import java.util.Set;

public interface ManagerDAO {

    public Manager getManagerById(int managerId);
    public Set<Manager> getAllManagers();
}
