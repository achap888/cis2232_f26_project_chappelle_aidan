# Race Timing App

CIS-2232 Project

## Development Team

Business Client:  Connor Chappelle </br>
Lead Developer:  Aidan Chappelle </br>
Quality Control:  John Raicent Aquino </br>

## Description

This application will allow the user to read and enter timings for motorsport races, including information such as driver lap times, driver names, track name and layout, car class, track conditions, weather, number of laps, flags thrown, and race duration. The application will calculate the delta differences between positions based on their respective times.

## Color

Main Color:  Brescian Blue

## Required Fields

| Field | Type | Description |
| --- | --- | --- |
| id | int | Unique identifier for database table |
| raceDate | String | Date of race event |
| createdDateTime | String | Date entered in the application |
| driverNamesTimes | HashMap<String, ArrayList<String>> | HashMap of names of drivers in race, as keys paired to their times stored in driverLapTimes |
| weatherConditions | String | Weather conditions of the race day |
| trackName | String | Name of track being raced |
| numberOfLaps | int | How many laps the race will run |
| raceDurationHours | double | How long the race lasted in hours |
| driverLapTimes | ArrayList<String>(numberOfLaps) | ArrayList of lap times per driver, for at least the number of laps in the race |
| carClass | String | Class of cars being raced (LMH, GT, F1, etc.) |
| trackLayout | String | Layout of track (indy/GP, etc.) |
| trackConditions | String | Conditions of track (wet/dry, temperature) |
| sectorTimes | double | Times of drivers per sector on track |
| flagsYellow | int | Quantity of yellow flags (caution on track) |
| flagsRed | int | Quantity of red flags (suspend race) |
| flagsBlack | int | Quantity of black flags (driver to pit lane) |
| flagsBlue | int | Quantity of blue flags (faster car passing) |

## Calculation

The app will calculate the “delta”, or difference, between drivers’ accumulated lap times over each lap of the race. The sums of each driver’s lap times will be used to determine their final position on the leaderboard and then display the winners of the race.

## Report Details

To be determined in future sprint
