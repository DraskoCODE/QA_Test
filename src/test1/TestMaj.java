package test1;

import com.sun.jdi.ArrayType;

import java.util.ArrayList;
import java.util.List;

public class TestMaj {

    public static void main(String[] args) {
        int minNUmber = 100;
        Test test = new Test();
        System.out.println(test.maxNumber(16, 34));

        test.printMessage("Hello");
        test.printMessage("QA CODE");

        test.printMessage();

        for(int i = 0; i < 10; i++) {
            int y = 5;
        }

        minNUmber = 101;

        Employee employee = new Employee();
        //employee.firstName = "Dragoje";
        employee.setFirstName("Dragoje");
        //employee.lastName = "Janjevic";
        employee.setLastName("Janjevic");
        employee.address = "Nis";
        employee.position = "DEV";
        employee.getFirstName();
        String position = employee.position;
        String address = employee.address;
        System.out.println(employee.calculateSalary());

        Employee employee1 = new Employee("Ksenija", "Vasiljevic", "Beograd", "PM");
        System.out.println(employee1.calculateSalary());

        String[] niz = {"Kuca", "Kosarka", "Rukomet", "Reket", "Fudbal", "Flasica"};
        //objekat klase StringManager
        //default konstuktor
        StringManager stringManager = new StringManager();
        String[] niz1 = new String[10];
        niz1 = stringManager.returnListString(niz, 'K');
        System.out.println("d");

        int[] arrayOfInt = {12, 34, 5, 78, 9, 140, 4, 9, 8};
        int max1 = stringManager.maxNumber(arrayOfInt);

        int[] arrayOfInt1 = {12, 34, 5};
        int max2 = stringManager.maxNumber(arrayOfInt1);

        System.out.println(max1);
        System.out.println(max2);

        stringManager.printMaxNumber(arrayOfInt);

        String[] arrayString = new String[700];
        arrayString[0] = "QA";
        arrayString[1] = "DEV";

        List<String> listString = new ArrayList<>();
        listString.add("QA");
        listString.add("DEV");
        String temp = listString.get(0);
        listString.contains("QA");

        for(int i = 0; i < listString.size(); i++) {
            System.out.println("Element on index : " + i + " is " + listString.get(i));
        }

        List<Employee> employeeList = new ArrayList<>();

        List<String> listOfString = new ArrayList<>();
        listOfString.add("QA");
        listOfString.add("DEV");
        listOfString.add("QA");
        listOfString.add("PM");
        listOfString.add("PO");
        listOfString.add("DEV");
        listOfString.add("DEV");
        listOfString.add("DEV");

        List<String> listBezDuplikata = stringManager.returnListWithoutDuplicate(listOfString);
        System.out.println("test");

        Manager manager = new Manager("MArko", "Dow", "IBM");
        //manager.setFirstName("Marko");
        //manager.setLastName("Dow");
        //.setCompany("IBM");
        manager.printDetails();
        manager.printDetails("Marko", "Dow");
        manager.printCompany();

        Ucenik ucenik = new Ucenik();
        ucenik.setFirstName("Dragoje");
        ucenik.setLastName("Janjevic");
        ucenik.setSkola("Stefan Nemanja");
        ucenik.printDetails();
        ucenik.printSkola();

        ProductOwner productOwner = new ProductOwner();
        productOwner.printDetails();

        People manager1 = new Manager();
        People ucenik1 = new Ucenik();

        Dog dog = new Dog();
        dog.eat();
        dog.animalSound();

        Manager manager10 = new Manager("MArko", "Dow", "IBM");
        Manager manager2 = new Manager("MArko", "Dow", "Ford");
        Manager manager3 = new Manager("MArko", "Dow", "MK Group");

        List<Manager> listManager = new ArrayList<>();
        listManager.add(manager10);
        listManager.add(manager2);
        listManager.add(manager3);

        System.out.println("test");
    }

}
