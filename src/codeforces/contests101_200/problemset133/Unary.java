package codeforces.contests101_200.problemset133;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Unary {

    static Map<Character, String> map = new HashMap<Character, String>() {{
        put('>', "1000");
        put('<', "1001");
        put('+', "1010");
        put('-', "1011");
        put('.', "1100");
        put(',', "1101");
        put('[', "1110");
        put(']', "1111");
    }};

    final static BigInteger MOD = new BigInteger("1000003");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(map.get(c));
        }
        String r = sb.reverse().toString();
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '1') {
                result = result.add(BigInteger.ONE.shiftLeft(i)).mod(MOD);
            }
        }
        System.out.println(result);
    }

}
