package codeforces.contests001_100.problemset004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watermelon {

    private static String process(String kilos) {
        if ("2".equals(kilos)) {
            return "NO";
        } else {
            Integer parse = Integer.parseInt(kilos);
            return parse % 2 == 0 ? "YES" : "NO";
        }
    }

    public static void main(String[] agrs) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            System.out.println(process(input));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}