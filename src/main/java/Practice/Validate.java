package Practice;

public class Validate
{
    public void bookLength(String bookName) throws Exception
    {
        if(bookName.length()>30)
            throw new Exception("Book Name has maximum of 30 characters");
    }

    public void checkDateFormat(String date) throws Exception
    {
        if(!date.matches("\\d{2}/\\d{2}/\\d{4}"))
            throw new Exception("Date format not matching");
    }

    public void timeInHrsAndMin(String time) throws Exception
    {
        if(!time.matches("\\d{2}:\\d{2}"))
            throw new Exception("Time format not matching");
    }

}
