package dev.carrico.services;

import dev.carrico.entities.Manager;

import java.util.Set;

public interface ManagerService {

    public Set<Manager> getAllManagers();

    public Manager getManagerById(int managerId);

    public Manager getManagerByUsernameAndPswrd(String username, String pswrd);
}
