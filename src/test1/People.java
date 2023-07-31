package test1;

public class People {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void printDetails() {
        System.out.println(firstName + " " + lastName);
    }

    public void printDetails(String ime, String prezime) {
        System.out.println(ime + " " + prezime);
    }
}
