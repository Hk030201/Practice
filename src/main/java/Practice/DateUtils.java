package Practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils
{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDate getDueDate(String issuedDateInString)
    {
        return LocalDate.parse(issuedDateInString,formatter).plusDays(15);
    }

    public int calculateFine(LocalDate dueDate,String returnDateInString)
    {
        LocalDate returnDate = LocalDate.parse(returnDateInString,formatter);
        return (int)ChronoUnit.DAYS.between(dueDate, returnDate)+1;
    }
}
