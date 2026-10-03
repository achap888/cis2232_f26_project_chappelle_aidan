package ca.hccis.files.bo;

import ca.hccis.files.entity.Driver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RacePositionBOTest {

    // Test if total race time is actually 603 seconds
    @Test
    public void testCalculateTotalRaceTime()
    {
        Driver driver = new Driver();
        driver.setLapTimeSeconds(120.6);
        driver.setNumberOfLaps(5);

        RacePositionBO racePositionBO = new RacePositionBO();
        double totalRaceTime = racePositionBO.calculate(driver);
        assertEquals(totalRaceTime == 603, true);
    }

    // Test if lap is faster than given record time
    // Grand Prix Circuit (2003–present): 3.916 km (2.433 mi)
    // A1GP 1:12.276, Adam Carroll, A1GP Powered by Ferrari car, 2009 Brands Hatch A1GP round
    // From "Brands Hatch" on Wikipedia (https://en.wikipedia.org/wiki/Brands_Hatch#Records)
    // Given record here is 72.276 seconds, x5 laps would be 361.38 seconds
    @Test
    public void testCalculateRecordLapTimeDifference()
    {
        Driver driver = new Driver();
        driver.setLapTimeSeconds(60.2);
        driver.setNumberOfLaps(5);

        RacePositionBO racePositionBO = new RacePositionBO();
        double actualLapTime = racePositionBO.calculate(driver);
        assertTrue(361.38 > actualLapTime);
    }

    // Test if lap time was actually given
    @Test
    public void testCalculateCompletedLap()
    {
        Driver driver = new Driver();
        driver.setLapTimeSeconds(89.4);
        driver.setNumberOfLaps(5);

        RacePositionBO racePositionBO = new RacePositionBO();
        double actualLapTime = racePositionBO.calculate(driver);
        assertTrue(actualLapTime > 0);
    }


}
