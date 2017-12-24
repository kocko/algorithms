package codeforces.contests501_600.problemset586;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class AlenasSchedule implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int firstOne = -1, lastOne = -1;
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.ni();
            if (s[i] == 1) {
                if (firstOne == -1) {
                    firstOne = i;
                }
                lastOne = i;
            }
        }
        if (firstOne == -1) {
            out.println(0);
        } else {
            int last = 1, count = 0, university = 1; 
            for (int i = firstOne + 1; i <= lastOne; i++) {
                if (s[i] == last) count++;
                else {
                    if (s[i] == 0) {
                        university += count;
                    } else {
                        if (count < 2) university += count;
                    }
                    count = 1;
                    last = s[i];
                }
            }
            if (last == 1) {
                university += count;
            }
            out.println(university);
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
        try (AlenasSchedule instance = new AlenasSchedule()) {
            instance.solve();
        }
    }
}
