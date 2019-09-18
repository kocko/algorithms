package acm.regionals.year2010.europe.southeast;

import java.io.IOException;
import java.util.Scanner;

public class Shares {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split("\\s+");
            int n = Integer.parseInt(split[0]), s = Integer.parseInt(split[1]);
            System.out.println(s / (n + 1));
        }
        sc.close();
    }
    
}
