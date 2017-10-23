package codeforces.contests101_200.problemset155;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Combination implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Card implements Comparable<Card> {
        private int points, moves;

        private Card(int points, int moves) {
            this.points = points;
            this.moves = moves;
        }

        @Override
        public int compareTo(Card o) {
            int x = Integer.compare(o.moves, this.moves);
            return x == 0 ? Integer.compare(o.points, this.points) : x;
        }
    }

    public void solve() {
        int n = in.ni();
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new Card(in.ni(), in.ni()));
        Collections.sort(list);
        int counter = 1, idx = 0, points = 0;
        while (counter > 0 && idx < n) {
            Card card = list.get(idx++);
            points += card.points;
            counter += card.moves - 1;
        }
        out.println(points);
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
        try (Combination instance = new Combination()) {
            instance.solve();
        }
    }
}
