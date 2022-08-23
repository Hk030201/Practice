package Practice;

import java.time.LocalTime;
import java.util.*;

public class Airport
{
    private static DateTimeUtils dateTimeUtils = new DateTimeUtils();

    public static int calculateNoOfRunways(ArrayList<LocalTime> arrivalTime , ArrayList<LocalTime> departureTime)
    {
        ArrayList<LocalTime> runwaysInUse = new ArrayList<>();
        runwaysInUse.add(departureTime.get(0));
        int returnValue = 0,timeDiff=0;
        for (int i=1;i<arrivalTime.size();i++)
        {
            returnValue = runwaysInUse.get(0).compareTo(arrivalTime.get(i));
            timeDiff = dateTimeUtils.calculateTimeDiff(runwaysInUse.get(0),arrivalTime.get(i));
            if(returnValue==-1 && timeDiff<12)
            {
                runwaysInUse.add(departureTime.get(i));
                runwaysInUse.remove(0);
            }
            if(returnValue==1 || timeDiff>12)
                runwaysInUse.add(departureTime.get(i));
            Collections.sort(runwaysInUse);
        }
        return runwaysInUse.size();
    }

    public static void setPlanesSchedule(int noOfPlanes)
    {
        Scanner ob = new Scanner(System.in);

        LocalTime time=null;
        String timeInString = "";
        LocalTime arrayOfArrivalTime[]= new LocalTime[noOfPlanes];

        TreeMap<LocalTime,LocalTime> timingsOfPlanes= new TreeMap<>();

        for(int i=0 ; i<noOfPlanes ; i++)
        {
            timeInString = ob.next();
            time = dateTimeUtils.convertStringToTime
                    (timeInString.substring(0,2)+":"+timeInString.substring(2,4));
            timingsOfPlanes.put(time,time);
            arrayOfArrivalTime[i]=time;
        }
        for(int i=0 ; i<noOfPlanes ; i++)
        {
            timeInString = ob.next();
            time = dateTimeUtils.convertStringToTime
                    (timeInString.substring(0,2)+":"+timeInString.substring(2,4));
            timingsOfPlanes.put(arrayOfArrivalTime[i],time);
        }
        ArrayList<LocalTime> arrival = new ArrayList<>(timingsOfPlanes.keySet());
        ArrayList<LocalTime> departure = new ArrayList<>(timingsOfPlanes.values());

        System.out.println("Minimum number of runways required: "+Airport.calculateNoOfRunways(arrival,departure));
    }
    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the number of planes:");
        int noOfPlanes = ob.nextInt();
        ob.nextLine();
        Airport.setPlanesSchedule(noOfPlanes);
    }
}

//0900 0940 1000 1130
//0920 1030 1100 1200

//1130 1235 0700 1300
//1230 1330 0730 1330

//0900 0940 0950 1100 1500 1800
//0910 1200 1120 1130 1900 2000

//        int noOfPlatforms = 1;
//        for (int i=1; i<arrivalTime.size() ; i++)
//        {
//            for (int j=i-1; j<departureTime.size(); j++)
//            {
//                int val = arrivalTime.get(i).compareTo(departureTime.get(j));
//                if(val==-1)
//                    noOfPlatforms++;
//            }
//        }
//        return noOfPlatforms;