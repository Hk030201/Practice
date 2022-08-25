package Practice;

import java.util.Scanner;

public class JarExchange
{
    public static int findMinimumNoOfSteps(int firstJar,int secondJar,int targetCapacity)
    {
        Utils utils = new Utils();

        if(secondJar > firstJar)
        {
            int temp = firstJar;
            firstJar = secondJar;
            secondJar = temp;
        }

        if(targetCapacity % utils.findGCD(firstJar,secondJar) !=0)
            return -1;

        int noOfSteps = 0,fillWater = 0;

        fillWater = firstJar;
        if(fillWater > targetCapacity || utils.findGCD(firstJar,secondJar) !=1)
        {
            while(fillWater - secondJar <= targetCapacity)
            {
                fillWater -= secondJar;
                targetCapacity -= fillWater;
                noOfSteps+=2;
                if(targetCapacity == 0)
                    break;
                fillWater =firstJar;
                noOfSteps+=2;
            }
        }
        return noOfSteps;
    }

    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the capacity of first jar:");
        int firstJar = ob.nextInt();
        System.out.println("Enter the capacity of second jar:");
        int secondJar = ob.nextInt();
        System.out.println("Enter the target capacity:");
        int targetCapacity = ob.nextInt();
        int noOfSteps = JarExchange.findMinimumNoOfSteps(firstJar,secondJar,targetCapacity);
        if(noOfSteps != -1)
            System.out.println("Minimum number of steps = "+noOfSteps);
        else
            System.out.println("It is impossible");
    }
}
