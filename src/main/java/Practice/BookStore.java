package Practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class BookStore
{
    public static void collectData(String input)
    {
        DateTimeUtils dateTimeUtils =new DateTimeUtils();
        Validate validate= new Validate();

        String data[] = input.split(" ");

        String issuedDate = data[data.length-2];
        data[data.length-2] = "";

        String returnDate = data[data.length-1];
        data[data.length-1] = "";

        String bookName = Arrays.toString(data)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();

        LocalDate dueDate = null;
        int fine = 0,exceptionFlag = 0;

        try {
            validate.bookLength(bookName);
            validate.checkDateFormat(issuedDate);
            validate.checkDateFormat(returnDate);

            dueDate = dateTimeUtils.getDueDate(issuedDate);
            fine = dateTimeUtils.calculateFine(dueDate,returnDate);

        }catch (Exception e) {
            if(e.getMessage()!=null)
            {
                exceptionFlag = 1;
                System.out.println(e.getMessage());
            }
        }
        if(exceptionFlag == 0)
        {
            if(fine>0)
                System.out.println("Book-Name:"+bookName+" Due-Date:"+dueDate+" Fine:$"+fine);
            else
                System.out.println("Book-Name:"+bookName+" Due-Date:"+dueDate+" Fine:$0");
        }
    }

    public static void processInput(String inputs[])
    {
        for(String input:inputs)
            BookStore.collectData(input);
    }

    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter number of books to return:");
        int noOfBooks = ob.nextInt();
        ob.nextLine();
        String inputs[] = new String[noOfBooks];
        System.out.println("Enter in this format: [BookName Issue-Date(dd/mm/yyyy) Return-Date(dd/mm/yyyy)]");
        for(int i=0; i<noOfBooks; i++)
            inputs[i] = ob.nextLine();
        BookStore.processInput(inputs);
    }
}
//Hi this is just a checking for exception of book length greater than thirty 11-02-2020 29-02-2020
//Kill Bill 11-02-2020 29-02-2020

//    Kill Bill 11/02/2020 29/02/2020
//    Kill Bill 11-02-2020 29-02-2020