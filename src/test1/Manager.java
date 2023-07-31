package test1;

public class Manager extends People{

    private String company;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void printCompany() {
        System.out.println(company);
    }

    public Manager() {

    }

    public Manager(String ime, String prezime, String kompanija) {
        super.setFirstName(ime);
        super.setLastName(prezime);
        this.company = kompanija;
    }

    public void printDetails() {
        System.out.println("Manager " + super.getFirstName() + " " + super.getLastName());
    }
}
