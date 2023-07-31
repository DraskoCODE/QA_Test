package test1;

public class Employee {

    private String firstName;



    private String lastName;
    public String address;
    public String position;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String ime) {
        this.firstName = ime;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String prezime) {
        this.lastName = lastName;
    }

    public Employee() {

    }

    public Employee(String name, String lastName, String address, String position) {
        this.firstName = name;
        this.lastName = lastName;
        this.address = address;
        this.position = position;

    }

    public double calculateSalary() {
        if(position.equals("DEV")) {
            return 1500;
        }
        else if (position.equals("QA")) {
            return 1100;
        }
        else if (position.equals("PM")) {
            return 2500;
        }
        else {
            return 0;
        }
    }

}
