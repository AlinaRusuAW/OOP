package model;

import java.util.List;

public class Manager extends Employee{
    List<Employee> members;

    public Manager(Long id, String name, String prenume, Long salariu, Long position_id, List<Employee> members) {
        super(id, name, prenume, salariu, position_id);
        this.members = members;
    }

    public Manager(List<Employee> members) {
        this.members= members;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void setMembers(List<Employee> members) {
        this.members = members;
    }
}
