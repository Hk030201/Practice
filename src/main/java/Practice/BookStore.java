package Practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class BookStore
{
    public static void collectData(String input)
    {
        DateUtils dateUtils=new DateUtils();
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

        try{
            validate.checkDateFormat(issuedDate);
            validate.checkDateFormat(returnDate);
            validate.bookLength(bookName);
        }catch (Exception e) {
            e.printStackTrace();
        }

        LocalDate dueDate = dateUtils.getDueDate(issuedDate);

        int fine = dateUtils.calculateFine(dueDate,returnDate);

        if(fine>0)
            System.out.println("Book-Name:"+bookName+" Due-Date:"+dueDate+" Fine:$"+fine);
        else
            System.out.println("Book-Name:"+bookName+" Due-Date:"+dueDate+" Fine:$0");
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
