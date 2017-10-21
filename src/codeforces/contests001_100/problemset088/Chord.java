package codeforces.contests001_100.problemset088;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chord implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] tones = new String[] {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H",
                                       "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
        int[] x = new int[6];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            String next = in.next();
            for (int j = 0; j < tones.length; j++) {
                if (tones[j].equals(next)) {
                    x[idx++] = j;
                }
            }
        }
        Arrays.sort(x);
        for (int i = 0; i < 4; i++) {
            int first = x[i], second = x[i + 1], third = x[i + 2];
            if (second - first == 4 && third - second == 3) {
                out.println("major");
                return;
            } else if (second - first == 3 && third - second == 4) {
                out.println("minor");
                return;
            }
        }
        out.println("strange");
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
        try (Chord instance = new Chord()) {
            instance.solve();
        }
    }
}
