package codeforces.contests801_900.problemset810;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Long.min;

public class SummerSellOff implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), f = in.ni();
        long result = 0;
        List<Day> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long items = in.nl(), people = in.nl();
            result += min(items, people);
            if (items < people) {
                list.add(new Day(items, people));
            }
        }
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < min(list.size(), f); i++) {
            result += list.get(i).gain();
        }
        out.println(result);
    }
    
    private class Day implements Comparable<Day> {
        private long items, people;

        private Day(long items, long people) {
            this.items = items;
            this.people = people;
        }
        
        private long gain() {
            return min(people - items, items);
        }

        @Override
        public int compareTo(Day o) {
            return Long.compare(o.gain(), this.gain());
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
        try (SummerSellOff instance = new SummerSellOff()) {
            instance.solve();
        }
    }
}
