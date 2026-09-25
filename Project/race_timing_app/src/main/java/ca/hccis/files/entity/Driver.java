package ca.hccis.files.entity;

import ca.hccis.files.util.CisUtility;

import java.util.Scanner;

public class Driver {

    private int id;
    private int carNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double raceTimeSeconds;

    public Driver() {
    }

    public Driver(int id, int carNumber, String firstName, String lastName, String dateOfBirth, double raceTimeSeconds) {
        this.id = id;
        this.carNumber = carNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.raceTimeSeconds = raceTimeSeconds;
    }

    public void getInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Car Number: ");
        carNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("First Name: ");
        firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        lastName = scanner.nextLine();
        System.out.print("Date of Birth: ");
        dateOfBirth = scanner.nextLine();
        System.out.print("Race Time: ");
        raceTimeSeconds = scanner.nextDouble();
        scanner.nextLine();
    }

    public void edit(){
        String fName = CisUtility.getInputString("First Name: ");
        String lName = CisUtility.getInputString("Last Name: ");
        String dob = CisUtility.getInputString("DOB: ");
        double raceTime = CisUtility.getInputDouble("Race Time: ");

        setFirstName(fName);
        setLastName(lName);
        setDateOfBirth(dob);
        setRaceTimeSeconds(raceTime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getRaceTimeSeconds() {
        return raceTimeSeconds;
    }

    public void setRaceTimeSeconds(double raceTimeSeconds) {
        this.raceTimeSeconds = raceTimeSeconds;
    }

    @Override
    public String toString() {
        return String.format(
                "Driver: carNumber=%d, firstName='%s', lastName='%s', dateOfBirth='%s', raceTime='%d'",
                carNumber, firstName, lastName, dateOfBirth, raceTimeSeconds
        );
    }

}
