package Practice;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    DateTimeUtils dateTimeUtils = new DateTimeUtils();

    @Test
    void calculateNoOfRunways() {
        ArrayList<LocalTime> test1ArrivalTime = new ArrayList<>();
        test1ArrivalTime.add(dateTimeUtils.convertStringToTime("22:00"));
        test1ArrivalTime.add(dateTimeUtils.convertStringToTime("23:00"));

        ArrayList<LocalTime> test1DepTime = new ArrayList<>();
        test1DepTime.add(dateTimeUtils.convertStringToTime("02:00"));
        test1DepTime.add(dateTimeUtils.convertStringToTime("03:00"));

        ArrayList<LocalTime> test2ArrivalTime = new ArrayList<>();
        test2ArrivalTime.add(dateTimeUtils.convertStringToTime("09:00"));
        test2ArrivalTime.add(dateTimeUtils.convertStringToTime("09:40"));
        test2ArrivalTime.add(dateTimeUtils.convertStringToTime("09:50"));
        test2ArrivalTime.add(dateTimeUtils.convertStringToTime("11:00"));
        test2ArrivalTime.add(dateTimeUtils.convertStringToTime("15:00"));
        test2ArrivalTime.add(dateTimeUtils.convertStringToTime("18:00"));

        ArrayList<LocalTime> test2DepTime = new ArrayList<>();
        test2DepTime.add(dateTimeUtils.convertStringToTime("09:10"));
        test2DepTime.add(dateTimeUtils.convertStringToTime("12:00"));
        test2DepTime.add(dateTimeUtils.convertStringToTime("11:20"));
        test2DepTime.add(dateTimeUtils.convertStringToTime("11:30"));
        test2DepTime.add(dateTimeUtils.convertStringToTime("19:00"));
        test2DepTime.add(dateTimeUtils.convertStringToTime("20:00"));

        assertEquals(2,Airport.calculateNoOfRunways(test1ArrivalTime,test1DepTime));
        assertEquals(3,Airport.calculateNoOfRunways(test2ArrivalTime,test2DepTime));
    }
}