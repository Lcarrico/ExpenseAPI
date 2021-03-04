package carrico.dev.services;

import carrico.dev.entities.Manager;

import java.util.Set;

public interface ManagerService {

    public Set<Manager> getAllManagers();

    public Manager getManagerById(int managerId);
}
