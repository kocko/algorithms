package codeforces.contests801_900.problemset864;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bus implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), fuel = in.ni(), station = in.ni(), k = in.ni();
        int current = fuel, pos = 0;
        boolean up = true;
        int result = 0, journeys = -1;
        while (true) {
            if (current < 0) {
                out.println(-1);
                return;
            }
            if (pos == 0 || pos == a) journeys++;
            if (journeys == k) break;
            
            if (pos == 0) {
                current -= station;
                up = true;
                pos = station;
            } else if (pos == station) {
                if (up) {
                    if (journeys == k - 1) {
                        if (a - station > current) {
                            result++;
                            current = fuel - a + station;
                        }
                    } else {
                        if (2 * (a - station) > current) {
                            result++;
                            current = fuel - a + station;
                        } else {
                            current -= (a - station);
                        }
                    }
                    pos = a;
                } else {
                    if (journeys == k - 1) {
                        if (station > current) {
                            result++;
                            current = fuel - station;
                        }
                    } else {
                        if (2 * station > current) {
                            result++;
                            current = fuel - station;
                        } else {
                            current -= station;
                        }
                    }
                    pos = 0;
                }
            } else if (pos == a) {
                current -= a - station;
                up = false;
                pos = station;
            }
        }
        out.println(result);
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
        try (Bus instance = new Bus()) {
            instance.solve();
        }
    }
}
