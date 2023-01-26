package model;

public class Employee {
    Long id;
    String name;
    String prenume;
    Long position_id;
    Long salariu;

    public Employee(Long id, String name, String prenume, Long position_id, Long salariu) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.position_id = position_id;
        this.salariu = salariu;
    }

    public Employee() {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.position_id = position_id;
        this.salariu = salariu;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Long getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }

    public Long getSalariu() {
        return salariu;
    }
    public void setSalariu(Long salariu) {
        this.salariu = salariu;
    }
    public String toString(){
        return "Employee: " + this.getId() + " " + this.getName() +
                " " + this.getPrenume() + " " + this.position_id + " " + this.getSalariu();
    }
}
