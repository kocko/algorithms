package codeforces.contests601_700.problemset611;

import java.util.Scanner;

public class NewYearAndDays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int day = Integer.parseInt(input[0]);
        int result = -1;
        switch(input[2]) {
            case "month": {
                result = calculateForMonth(day);
                break;
            }
            case "week": {
                result = calculateForWeek(day);
                break;
            }
        }
        System.out.println(result);
        sc.close();
    }

    static int calculateForMonth(int day) {
        if (day == 31) return 7;
        else if (day == 30) return 11;
        else return 12;
    }

    static int calculateForWeek(int day) {
        return (day == 5 || day == 6) ? 53 : 52;
    }
}
