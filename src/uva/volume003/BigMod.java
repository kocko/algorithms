package uva.volume003;

import java.io.IOException;
import java.util.Scanner;

public class BigMod {

    int mod(int a, int b, int c) {
        if (b == 0) return 1;
        else if (b % 2 == 0) {
            int x = mod (a, b / 2, c);
            return (x * x) % c;
        } else {
            return (a % c * mod (a, b - 1, c)) % c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int b = sc.nextInt(), p = sc.nextInt(), m = sc.nextInt();
            System.out.println(new BigMod().mod(b, p, m));
        }
    }
    
}
