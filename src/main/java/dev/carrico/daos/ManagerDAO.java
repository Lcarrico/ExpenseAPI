package dev.carrico.daos;

import dev.carrico.entities.Manager;

import java.util.Set;

public interface ManagerDAO {

    public Manager getManagerById(int managerId);
    public Set<Manager> getAllManagers();
}
