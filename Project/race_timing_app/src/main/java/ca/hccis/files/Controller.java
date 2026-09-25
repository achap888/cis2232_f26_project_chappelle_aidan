package ca.hccis.files;

import ca.hccis.files.entity.Driver;
import ca.hccis.files.util.CisUtility;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;

/**
 * Controls the overall flow of the program.
 *
 * @author cis2232
 * @since 20260917
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = "1) Add" + System.lineSeparator()
            + "2) Edit" + System.lineSeparator()
            + "3) View" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    private static HashMap<Integer, Driver> driverMap = new HashMap();
    private static Gson gson = new Gson();

    //TODO DONE if the cis2232 folder does not exist, then have your program create it.
    //TODO DONE filename to be changed from campers based on assignment requirements.
    public static final String PATH_NAME = "c:\\cis2232\\data_chappelle_aidan.json";

    public static void main(String[] args) {

        if(Files.exists(Paths.get(PATH_NAME)) == false) {
            try {
                Path path = Paths.get(PATH_NAME).getParent();
                IO.println(path);
                Files.createDirectories(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        initialize();

        //Gson
//        Camper test = camperMap.get(22334);
//        String camperJson = gson.toJson(test);
//        IO.println(camperJson);
//
//        Camper camperFromJson = gson.fromJson(camperJson, Camper.class);
//        System.out.println(camperFromJson.toString());


        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    add();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    viewAll();
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * Processing for menu option 1
     *
     * @author
     * @since
     */
    public static void add() {
        Driver newDriver = new Driver();
        IO.println("--Add Driver--");
        newDriver.getInformation();

        //TODO DONE what if the registration id already exists.  Give the user a warning and ask if they want to overwrite
        //the row.
        //read file nad see if the new camper is already there, and if so check with user to see if should overwrite
        int exists;
        Driver driver;
        try {
            FileReader reader = new FileReader(PATH_NAME);
            List<String> lines = reader.readAllLines();
            for(int i = 0; i < lines.size(); i++) {
                Driver driverFromJson = gson.fromJson(lines.get(i), Driver.class);
                if (driverFromJson.getCarNumber() ==  newDriver.getCarNumber()) {
                    i = lines.size();
                    IO.println("Car number already exists. Overwrite? (Y/N)");
                    String option = IO.readln();
                    if (option.equalsIgnoreCase("Y")) {
                        driverMap.put(driverFromJson.getCarNumber(), newDriver);
                        writeAll();
                    }
                } else {
                    driverMap.put(driverFromJson.getCarNumber(), newDriver);
                    writeAll();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processing for menu option 2.
     *
     * @author
     * @since
     */
    public static void edit() {
        System.out.println("Processing option 2");
        int carNum = CisUtility.getInputInt("Car Number: ");
        Driver editingDriver = driverMap.get(carNum);
        //TODO DONE What if the carNum not found?
        //Handle this situation.
        if (editingDriver == null) {
            IO.println("Car number not found!");
        } else {
            editingDriver.edit();
        }
        writeAll(); //save to file
    }

    /**
     * Processing for menu option 3.
     *
     * @author
     * @since
     */
    public static void viewAll() {
        readAll();
        //TODO Need to show all the campers.  Note want to show the latest from the file, not just
        //what is currently in the map.
    }


    public static void writeAll() {
        try {
            FileWriter writer = new FileWriter(PATH_NAME, false);
            for (Driver current : driverMap.values()) {
                writer.append(gson.toJson(current));
                writer.append(System.lineSeparator());
                System.out.println("Successfully written JSON string to file.");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAll() {
        try {
            FileReader reader = new FileReader(PATH_NAME);
            List<String> lines = reader.readAllLines();
            for(int i = 0; i < lines.size(); i++) {
                Driver driverFromJson = gson.fromJson(lines.get(i), Driver.class);
                driverMap.put(driverFromJson.getCarNumber(), driverFromJson);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialize() {

        Path path = Paths.get(PATH_NAME);

        // Check if the file exists
        if (Files.exists(path)) {
            System.out.println("Drivers exist.");
            readAll();
        } else {


            Driver driver = new Driver(1, 22334, "Bob", "Stephens", "2020-01-05", 120.7);
            Driver driver2 = new Driver(2, 22335, "Alice", "Johnson", "2019-07-14", 217.5);
            Driver driver3 = new Driver(3, 22336, "Charlie", "Williams", "2021-03-22", 125.3);
            Driver driver4 = new Driver(4, 22337, "Diana", "Brown", "2020-11-09", 110.6);
            Driver driver5 = new Driver(5, 22338, "Ethan", "Miller", "2018-05-17", 60.4);
            driverMap.put(driver.getCarNumber(), driver);
            driverMap.put(driver2.getCarNumber(), driver2);
            driverMap.put(driver3.getCarNumber(), driver3);
            driverMap.put(driver4.getCarNumber(), driver4);
            driverMap.put(driver5.getCarNumber(), driver5);

            writeAll();
        }

    }
}
