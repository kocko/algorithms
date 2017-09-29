package codeforces.contests101_200.problemset151;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class PhoneNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String[] names = new String[n];
        int[] taxi = new int[n], pizza = new int[n], girls = new int[n];
        int maxTaxi = 0, maxPizza = 0, maxGirls = 0;
        for (int i = 0; i < n; i++) {
            int count = in.ni();
            names[i] = in.next();
            while(count-- > 0) {
                String number = in.next();
                if (isTaxi(number)) {
                    taxi[i]++;
                    maxTaxi = Math.max(maxTaxi, taxi[i]);
                } else if (isPizza(number)) {
                    pizza[i]++;
                    maxPizza = Math.max(maxPizza, pizza[i]);
                } else {
                    girls[i]++;
                    maxGirls = Math.max(maxGirls, girls[i]);
                }
            }
        }
        StringJoiner taxis = new StringJoiner(", "), pizzas = new StringJoiner(", "), chicks = new StringJoiner(", ");
        for (int i = 0; i < n; i++) {
            if (taxi[i] == maxTaxi) taxis.add(names[i]);
            if (pizza[i] == maxPizza) pizzas.add(names[i]);
            if (girls[i] == maxGirls) chicks.add(names[i]);
        }
        out.printf("If you want to call a taxi, you should call: %s.\n", taxis.toString());
        out.printf("If you want to order a pizza, you should call: %s.\n", pizzas.toString());
        out.printf("If you want to go to a cafe with a wonderful girl, you should call: %s.\n", chicks.toString());
    }
    
    private boolean isTaxi(String number) {
        boolean[] seen = new boolean[10];
        for (char c : number.toCharArray()) {
            if (c == '-') continue;
            seen[c - '0'] = true;
        }
        int count = 0;
        for (boolean b : seen) if (b) count++;
        return count == 1;
    }
    
    private boolean isPizza(String number) {
        number = number.replaceAll("[-]", "");
        for (int i = 1; i < 6; i++) {
            if (number.charAt(i) >= number.charAt(i - 1)) return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (PhoneNumbers instance = new PhoneNumbers()) {
            instance.solve();
        }
    }
}
