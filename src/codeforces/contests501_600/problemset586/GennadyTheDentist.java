package codeforces.contests501_600.problemset586;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class GennadyTheDentist implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        long[] doctor = new long[n], hall = new long[n], confidence = new long[n];
        boolean[] here = new boolean[n];
        for (int i = 0; i < n; i++) {
            doctor[i] = in.nl();
            hall[i] = in.nl();
            confidence[i] = in.nl();
            here[i] = true;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (here[i]) {
                long volume = doctor[i];
                result++;
                for (int j = i + 1; j < n; j++) {
                    if (here[j]) {
                        confidence[j] -= volume;
                        volume = (volume - 1 > 0) ? volume - 1 : 0;
                    }
                }
            }
            for (int j = 1; j < n; j++) {
                if (here[j] && confidence[j] < 0) {
                    here[j] = false;
                    for (int k = j + 1; k < n; k++) {
                        confidence[k] -= hall[j];
                    }
                }
            }
        }
        out.println(result);
        for (int i = 0; i < n; i++) {
            if (confidence[i] >= 0) {
                out.print(i + 1);
                out.print(' ');
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
        try (GennadyTheDentist instance = new GennadyTheDentist()) {
            instance.solve();
        }
    }
}
