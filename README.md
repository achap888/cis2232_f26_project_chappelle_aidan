# Race Timing App

CIS-2232 Project

## Development Team

Business Client:  Connor Chappelle </br>
Lead Developer:  Aidan Chappelle </br>
Quality Control:  John Raicent Aquino </br>

## Description

This application will allow the user to read and enter timings for motorsport races, including information such as sector times, lap times, driver names, track name and layout, car class, leaderboard positions, track conditions, weather, number of laps, flags thrown, and race duration. Up to 12 drivers can be measured. The application will calculate the delta differences between positions based on their respective times. The user can also look up drivers and see specific details about their performance.

## Color

Main Color:  Brescian Blue

## Required Fields

| Field | Type | Description |
| --- | --- | --- |
| id | int | Unique identifier for database table |
| raceDate | String | Date of race event |
| createdDateTime | String | Date entered in the application |
| driverNames | String | Names of drivers in race |
| weatherConditions | String | Weather conditions of the race day |
| trackName | String | Name of track being raced |
| numberOfLaps | int | How many laps the race will run |
| raceDurationHours | double | How long the race lasted in hours |
| driverTimes | double | List of driver times |
| carClass | String | Class of cars being raced (LMH, GT, F1, etc.) |
| trackLayout | String | Layout of track (indy/GP, counterclockwise, etc.) |
| trackConditions | String | Conditions of track (wet/dry, temperature) |
| sectorTimes | double | Times of drivers per sector on track |
| flagsYellow | int | Quantity of yellow flags (caution on track) |
| flagsRed | int | Quantity of red flags (suspend race) |
| flagsBlack | int | Quantity of black flags (driver to pit lane) |
| flagsBlue | int | Quantity of blue flags (faster car passing) |

## Calculation

The calculation / processing needed when the player enters a new record will be to determine the winner.  The entry will be analyzed to ensure that one of the players has won three games and the winner will be added to the row of the database.

## Report Details

To be determined in future sprint
