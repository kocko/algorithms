package acm.regionals.year2010.europe.southeast;

import java.math.BigInteger;
import java.util.Scanner;

public class TheTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] dimensions = line.split("\\s+");
            int m = Integer.parseInt(dimensions[0]), n = Integer.parseInt(dimensions[1]);
            BigInteger[] table = new BigInteger[m];
            for (int i = 0; i < n; i++) {
                String next = sc.nextLine();
                String[] x = next.split("\\s+");
                for (int j = 0; j < m; j++) {
                    if (table[j] == null) {
                        table[j] = new BigInteger(x[j]);
                    } else {
                        table[j] = table[j].multiply(new BigInteger(x[j]));
                    }
                }
            }

            BigInteger max = table[0];
            int index = 0;
            for (int i = 1; i < m; i++) {
                if (table[i].compareTo(max) >= 0) {
                    max = table[i];
                    index = i;
                }
            }
            System.out.println(index + 1);
        }
        sc.close();
    }
}
