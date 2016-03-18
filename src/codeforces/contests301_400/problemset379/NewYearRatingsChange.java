package codeforces.contests301_400.problemset379;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class NewYearRatingsChange implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Rating {
        int index;
        long value;

        Rating(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }

    public void solve() {
        int n = in.ni();
        List<Rating> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Rating(i, in.nl()));
        }
        Collections.sort(list, new Comparator<Rating>() {
            @Override
            public int compare(Rating o1, Rating o2) {
                return Long.compare(o1.value, o2.value);
            }
        });
        for (int i = 1; i < n; i++) {
            if (list.get(i).value <= list.get(i - 1).value) {
                list.get(i).value = list.get(i - 1).value + 1;
            }
        }
        Collections.sort(list, new Comparator<Rating>() {
            @Override
            public int compare(Rating o1, Rating o2) {
                return Integer.compare(o1.index, o2.index);
            }
        });
        for (Rating r : list) {
            out.print(r.value + " ");
        }
        out.println();
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

    public static void main(String[] args) {
        new NewYearRatingsChange().solve();
    }
}
