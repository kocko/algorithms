package codeforces.contests501_599.problemset582;

import java.util.Scanner;

public class KolyaAndTanya {

    static int MODULO = 1000000007;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        calculateSatisfactoryVariants(n);
        sc.close();
    }
    
    static void calculateSatisfactoryVariants(int n) {
        long a = 1;
        for (int i = 0; i < n; i++) {
            a *= 27;
            long rem = a % MODULO;
            if (a > MODULO) a = rem;
        }
        
        long b = 1;
        for (int i = 0; i < n; i++) {
            b *= 7;
            if (b >= MODULO) { 
                b %= MODULO;
            }
        }
    
        System.out.println((a - b + MODULO) % MODULO);
    }
    
}
