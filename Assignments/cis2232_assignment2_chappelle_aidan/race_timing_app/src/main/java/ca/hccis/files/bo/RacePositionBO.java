package ca.hccis.files.bo;
import ca.hccis.files.entity.Driver;

public class RacePositionBO {

    public RacePositionBO() {
    }

    // Calculate how long a race would be, given a specific lap time and a number of laps
    public double calculate(Driver driver) {
        return (double) driver.getLapTimeSeconds() * driver.getNumberOfLaps() ;
    }

}