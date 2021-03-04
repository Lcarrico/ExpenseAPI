package carrico.dev.services;

import carrico.dev.daos.ManagerDAO;
import carrico.dev.entities.Manager;

import java.util.Set;

public class ManagerServiceImpl implements ManagerService{

    private ManagerDAO mdao;

    public ManagerServiceImpl(ManagerDAO mdao){
        this.mdao = mdao;
    }


    @Override
    public Set<Manager> getAllManagers() {
        return mdao.getAllManagers();
    }

    @Override
    public Manager getManagerById(int managerId) {
        return mdao.getManagerById(managerId);
    }
}
