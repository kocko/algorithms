package codeforces.contests901_1000.problemset994;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;

public class KnightsOfAPolygonalTable implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Knight> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Knight(i, in.ni()));
        }
        for (int i = 0; i < n; i++) {
            list.get(i).setMoney(in.nl());
        }
        long[] result = new long[n];
        list.sort(comparingInt(Knight::getPower));
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Knight knight = list.get(i);
            result[knight.idx] = knight.money + sum;
            queue.offer(knight.money);
            sum += knight.money;
            if (queue.size() == k + 1) {
                sum -= queue.poll();
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }
    
    private class Knight {
        private int idx, power;
        private long money;

        private Knight(int idx, int power) {
            this.idx = idx;
            this.power = power;
        }

        private void setMoney(long money) {
            this.money = money;
        }

        public int getPower() {
            return power;
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
        try (KnightsOfAPolygonalTable instance = new KnightsOfAPolygonalTable()) {
            instance.solve();
        }
    }
}
