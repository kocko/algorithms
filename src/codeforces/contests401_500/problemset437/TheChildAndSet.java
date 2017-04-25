package codeforces.contests401_500.problemset437;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheChildAndSet implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class LowestBit implements Comparable<LowestBit> {
        private int value;
        
        private LowestBit(int value) {
            this.value = value;
        }
        
        private int getLowestBit() {
            return value & -value;
        }

        @Override
        public int compareTo(LowestBit o) {
            return o.getLowestBit() - this.getLowestBit();
        }
    }

    public void solve() {
        int sum = in.ni(), limit = in.ni();
        List<Integer> result = new ArrayList<>();
        List<LowestBit> list = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            list.add(new LowestBit(i));
        }
        Collections.sort(list);
        for (LowestBit number : list) {
            if (number.getLowestBit() <= sum) {
                sum -= number.getLowestBit();
                result.add(number.value);
            }
        }
        if (sum != 0) {
            out.println(-1);
        } else {
            out.println(result.size());
            for (int value : result) {
                out.print(value);
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
        try (TheChildAndSet instance = new TheChildAndSet()) {
            instance.solve();
        }
    }
}
