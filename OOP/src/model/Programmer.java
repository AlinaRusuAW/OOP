package model;

public class Programmer extends Employee {
    String programming_language;

    public Programmer(Long id, String name, String prenume, Long salariu, Long position_id, String programming_language) {
        super(id, name, prenume, salariu, position_id);
        this.programming_language = programming_language;
    }

    public Programmer(String programming_language) {
        this.programming_language = programming_language;
    }

    public String getProgramming_language() {
        return programming_language;
    }

    public void setProgramming_language(String programming_language) {
        this.programming_language = programming_language;
    }
}
