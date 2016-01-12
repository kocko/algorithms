package codeforces.contests600_699.problemset616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComparingTwoLongIntegers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] a = reader.readLine().toCharArray();
        int n = a.length;
        char[] b = reader.readLine().toCharArray();
        int m = b.length;
        int i, j;
        for (i = 0; i < n; i++) {
            if (a[i] != '0') {
                break;
            }
        }
        for (j = 0; j < m; j++) {
            if (b[j] != '0') {
                break;
            }
        }
        int sizeA = (n - i);
        int sizeB = (m - j);
        if (sizeA == sizeB) {
            for (int x = 0; x < sizeA; x++) {
                if (a[x + i] > b[x + j]) {
                    System.out.println(">");
                    return;
                } else if (a[x + i] < b[x + j]) {
                    System.out.println("<");
                    return;
                }
            }
            System.out.println("=");
        } else {
            System.out.println(sizeA > sizeB ? ">" : "<");
        }
    }

}
