package codeforces.contests101_200.problemset144;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Meeting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Radiator {
        private int x, y, range;

        private Radiator(int x, int y, int range) {
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }

    private class General {
        private int x, y;

        private General(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve() {
        int xa = in.ni(), ya = in.ni(), xb = in.ni(), yb = in.ni();
        int n = in.ni();
        List<Radiator> radiators = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            radiators.add(new Radiator(in.ni(), in.ni(), in.ni()));
        }
        int from_x = Math.min(xa, xb), to_x = Math.max(xa, xb);
        int from_y = Math.min(ya, yb), to_y = Math.max(ya, yb);
        List<General> generals = findGenerals(from_x, to_x, from_y, to_y);
        int result = 0;
        for (General general : generals) {
            boolean warm = false;
            for (Radiator radiator : radiators) {
                if (within(general, radiator)) {
                    warm = true;
                    break;
                }
            }
            if (!warm) result++;
        }
        out.println(result);
    }

    private List<General> findGenerals(int from_x, int to_x, int from_y, int to_y) {
        List<General> result = new ArrayList<>();
        result.add(new General(from_x, from_y));
        result.add(new General(from_x, to_y));
        result.add(new General(to_x, from_y));
        result.add(new General(to_x, to_y));
        for (int x = from_x + 1; x < to_x; x++) {
            result.add(new General(x, from_y));
        }
        for (int x = from_x + 1; x < to_x; x++) {
            result.add(new General(x, to_y));
        }
        for (int y = from_y + 1; y < to_y; y++) {
            result.add(new General(from_x, y));
        }
        for (int y = from_y + 1; y < to_y; y++) {
            result.add(new General(to_x, y));
        }
        return result;
    }

    private boolean within(General general, Radiator radiator) {
        double dist = Math.sqrt((general.x - radiator.x) * (general.x - radiator.x) + (general.y - radiator.y) * (general.y - radiator.y));
        return dist <= radiator.range;
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
        try (Meeting instance = new Meeting()) {
            instance.solve();
        }
    }
}
