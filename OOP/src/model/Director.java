package model;

public class Director extends Employee{
    String name_company;

    public Director(Long id, String name, String prenume, Long salariu, Long position_id, String name_company){
        super(id, name, prenume, salariu, position_id);
        this.name_company = name_company;
    }

    public Director(String name_company) {
        this.name_company = name_company;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }
}
