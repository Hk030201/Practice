package Practice;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilsTest {

    DateTimeUtils dateTimeUtils = new DateTimeUtils();

    @Test
    void getDueDate() {
        assertEquals("2020-02-16",dateTimeUtils.getDueDate("01/02/2020").toString());
        assertEquals("2020-03-15",dateTimeUtils.getDueDate("29/02/2020").toString());
        assertEquals("2020-03-01",dateTimeUtils.getDueDate("15/02/2020").toString());
    }

    @Test
    void calculateFine() {
        LocalDate date1=dateTimeUtils.getDueDate("01/02/2020");
        LocalDate date2=dateTimeUtils.getDueDate("29/02/2020");
        LocalDate date3=dateTimeUtils.getDueDate("15/02/2020");

        assertEquals(4,dateTimeUtils.calculateFine(date1,"19/02/2020"));
        assertEquals(0,dateTimeUtils.calculateFine(date2,"14/03/2020"));
        assertEquals(-10,dateTimeUtils.calculateFine(date3,"19/02/2020"));
    }

    @Test
    void convertStringToTime() {
        assertEquals("22:00",dateTimeUtils.convertStringToTime("22:00").toString());
        assertEquals("23:00",dateTimeUtils.convertStringToTime("23:00").toString());
        assertEquals("02:00",dateTimeUtils.convertStringToTime("02:00").toString());
        assertEquals("03:00",dateTimeUtils.convertStringToTime("03:00").toString());
    }

    @Test
    void calculateTimeDiff() {
        LocalTime arrivalTime1 = dateTimeUtils.convertStringToTime("22:00");
        LocalTime departureTime1 = dateTimeUtils.convertStringToTime("02:00");
        LocalTime arrivalTime2 = dateTimeUtils.convertStringToTime("13:00");
        LocalTime departureTime2 = dateTimeUtils.convertStringToTime("03:00");

        assertEquals(-20,dateTimeUtils.calculateTimeDiff(arrivalTime1,departureTime1));
        assertEquals(-10,dateTimeUtils.calculateTimeDiff(arrivalTime2,departureTime2));
    }
}