package uri.volume010;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class BanknotesAndCoins implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] input = in.next().split("[.]");
        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};
        int[] coins = {50, 25, 10, 5, 1};
        int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
        int[] banknotesCounts = new int[banknotes.length];
        split(banknotes, x, banknotesCounts);
        int[] coinsCounts = new int[coins.length];
        split(coins, y, coinsCounts);
        DecimalFormat format = new DecimalFormat("#.00");
        out.println("NOTAS:");
        for (int i = 0; i < banknotesCounts.length - 1; i++) {
            String s = format.format(banknotes[i]);
            out.printf("%d nota(s) de R$ %s\n", banknotesCounts[i], s);
        }
        out.println("MOEDAS:");
        out.printf("%d moeda(s) de R$ %s\n", banknotesCounts[banknotesCounts.length - 1], format.format(1));
        for (int i = 0; i < coinsCounts.length; i++) {
            out.printf("%d moeda(s) de R$ %.2f\n", coinsCounts[i], coins[i] / 100d);
        }
    }

    private void split(int[] types, int values, int[] counts) {
        while (values > 0) {
            for (int i = 0; i < types.length; i++) {
                if (types[i] <= values) {
                    counts[i] = values / types[i];
                    values %= types[i];
                    break;
                }
            }
        }
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
        try (BanknotesAndCoins instance = new BanknotesAndCoins()) {
            instance.solve();
        }
    }
}
