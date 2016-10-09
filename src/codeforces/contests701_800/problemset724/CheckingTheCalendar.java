package codeforces.contests701_800.problemset724;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CheckingTheCalendar implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int a = get(in.next()), b = get(in.next());
        for (int i = 1; i <= 7; i++) {
            int[] start = new int[12];
            start[0] = i;
            for (int j = 1; j < 12; j++) {
                start[j] = (start[j - 1] + days[j - 1]) % 7;
                if (start[j] == 0) {
                    start[j] = 7;
                }
            }
            for (int j = 0; j < 11; j++) {
                if (start[j] == a && start[j + 1] == b) {
                    out.println("YES");
                    return;
                }
            }
        }
        out.println("NO");
    }
    
    private int get(String day) {
        switch (day) {
            case "monday" : return 1;
            case "tuesday" : return 2;
            case "wednesday" : return 3;
            case "thursday" : return 4;
            case "friday" : return 5;
            case "saturday" : return 6;
            case "sunday" : return 7;
        }
        return -1;
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
        try (CheckingTheCalendar instance = new CheckingTheCalendar()) {
            instance.solve();
        }
    }
}
