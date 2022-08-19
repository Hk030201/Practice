package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class BookRental
{
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int testCase = ob.nextInt();
        ob.nextLine();
        for(int i=0;i<testCase;i++) {
            String value = ob.nextLine();
            String container[] = value.split(" ");

            String issueDate = container[container.length - 2];
            String returnDate = container[container.length - 1];
            container[container.length - 1] = "";
            container[container.length - 2] = "";

            String name = Arrays.toString(container)
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .trim();

            int iDate = Integer.parseInt(issueDate.split("/")[0]);
            int rDate = Integer.parseInt(returnDate.split("/")[0]);
            int dueDate = (iDate + 15);

            int iMonth = Integer.parseInt(issueDate.split("/")[1]);
            int rMonth = Integer.parseInt(returnDate.split("/")[1]);

            int iYear = Integer.parseInt(issueDate.split("/")[2]);
            int rYear = Integer.parseInt(returnDate.split("/")[2]);

            System.out.println(iDate + ":" + iMonth + ":" + iYear + " " + rDate + ":" + rMonth + ":" + rYear);

            if (rDate <= dueDate && iMonth == rMonth)
                System.out.println("Name:" + name + " DueDate:" +(dueDate<=29 ? dueDate : dueDate%29)+ " Fine:$0\n");
            else
                System.out.println("Name:" + name + " DueDate:" +(dueDate<=29 ? dueDate : dueDate%29)+ " Fine:$" + (rDate - dueDate+1)+"\n");
        }
    }
}
