package ca.hccis.files.entity;

import ca.hccis.files.util.CisUtility;

import java.util.Scanner;

public class Driver {

    private int id;
    private int carNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double lapTimeSeconds;
    private int numberOfLaps; // Had to add additional variable to allow for testing

    public Driver() {
    }

    public Driver(int id, int carNumber, String firstName, String lastName, String dateOfBirth, double lapTimeSeconds, int numberOfLaps) {
        this.id = id;
        this.carNumber = carNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.lapTimeSeconds = lapTimeSeconds;
        this.numberOfLaps = numberOfLaps;
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
        lapTimeSeconds = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Number of Laps: ");
        numberOfLaps = scanner.nextInt();
        scanner.nextLine();
    }

    public void edit(){
        String fName = CisUtility.getInputString("First Name: ");
        String lName = CisUtility.getInputString("Last Name: ");
        String dob = CisUtility.getInputString("DOB: ");
        double raceTime = CisUtility.getInputDouble("Race Time: ");
        int numberOfLaps = CisUtility.getInputInt("Number of Laps: ");

        setFirstName(fName);
        setLastName(lName);
        setDateOfBirth(dob);
        setLapTimeSeconds(raceTime);
        setNumberOfLaps(numberOfLaps);
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

    public double getLapTimeSeconds() {
        return lapTimeSeconds;
    }

    public void setLapTimeSeconds(double lapTimeSeconds) {
        this.lapTimeSeconds = lapTimeSeconds;
    }

    public int getNumberOfLaps() { return numberOfLaps; }

    public void setNumberOfLaps(int numberOfLaps) { this.numberOfLaps = numberOfLaps; }

    @Override
    public String toString() {
        return String.format(
                "Driver: carNumber=%d, firstName='%s', lastName='%s', dateOfBirth='%s', raceTime='%d'",
                carNumber, firstName, lastName, dateOfBirth, lapTimeSeconds
        );
    }

}
