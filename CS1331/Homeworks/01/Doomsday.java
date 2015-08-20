import java.util.Scanner;

public class Doomsday {

    public static void main(String[] args) {
        int month, day, year, finalAns, sum;
        int twoDigits, step1, step2, step3;
        int doomsMonthDay,  dayOfWeek, num;
        int doomsDay, doomie;
        String theDay;
        System.out.println("Welcome to your Doomsday Calculator!! ^_^");
        Scanner userInput = new Scanner(System.in);
        System.out.println("What year are you looking for (i.e. 1914)?");
        year = userInput.nextInt();
        int leapYear = 1;
        if (year % 100 == 0 & year % 400 == 0) {
            leapYear = 0;
        } else if (year % 4 == 0) {
            leapYear = 0;
        } else {
            leapYear = 1;
        }
        twoDigits = year % 100;
        step1 = twoDigits / 12;
        step2 = twoDigits % 12;
        step3 = step2 / 4;
        sum = step1 + step2 + step3 + 3;
        doomsDay = sum % 7;
        System.out.println("What month (1-12)?");
        month = userInput.nextInt();
        System.out.println("What about the day (i.e. 23)?");
        day = userInput.nextInt();
        int[] doomsMonthlp = {4, 29, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
        int[] doomsMonth = {3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
        if (leapYear == 0) {
            doomsMonthDay = doomsMonthlp[month - 1];
        } else {
            doomsMonthDay = doomsMonth[month - 1];
        }

        finalAns = day - doomsMonthDay + doomsDay;
        doomie = finalAns % 7;
        if (doomie < 0) {
            doomie = doomie + 7;
        }
        if (doomie >= 7) {
            doomie = doomie - 7;
        }

        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday" , "Wednesday",
            "Thursday", "Friday", "Saturday"};
        theDay = daysOfWeek[doomie];
        System.out.println("The day (" + month + "/" + day + "/" + year
            + ") is .... " + theDay);

    }

}
