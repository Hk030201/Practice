package Practice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils
{
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public LocalDate getDueDate(String issuedDateInString)
    {
        return LocalDate.parse(issuedDateInString,dateFormatter).plusDays(15);
    }

    public int calculateFine(LocalDate dueDate,String returnDateInString)
    {
        LocalDate returnDate = LocalDate.parse(returnDateInString,dateFormatter);
        return (int)ChronoUnit.DAYS.between(dueDate, returnDate)+1;
    }

    public LocalTime convertStringToTime(String timeInString)
    {
        return LocalTime.parse(timeInString, timeFormatter);
    }

    public int calculateTimeDiff(LocalTime arrivalTime,LocalTime departureTime)
    {
        return (int)arrivalTime.until(departureTime,ChronoUnit.HOURS);
    }
}
