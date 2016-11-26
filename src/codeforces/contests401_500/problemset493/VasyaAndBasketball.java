package codeforces.contests401_500.problemset493;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class VasyaAndBasketball implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Set<Integer> dist = new TreeSet<>();
        List<Integer> a = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            a.add(next); dist.add(next);
            min = Math.min(min, next);
            max = Math.max(max, next);
        }
        Collections.sort(a);
        int m = in.ni();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int next = in.ni();
            b.add(next); dist.add(next);
            min = Math.min(min, next);
            max = Math.max(max, next);
        }
        Collections.sort(b);
        dist.add(min - 1); dist.add(max + 1);
        long first = 0, second = 0;
        long diff = Long.MIN_VALUE;
        for (int d : dist) {
            long teamA, teamB;
            int index = binarySearch(a, d);
            if (index >= 0 && index < n) {
                teamA = 3 * (n - index - 1) + 2 * (index + 1);
            } else {
                teamA = 3 * n;
            }
            
            index = binarySearch(b, d);
            if (index >= 0 && index < m) {
                teamB = 3 * (m - index - 1) + 2 * (index + 1);
            } else {
                teamB = 3 * m;
            }
            
            long df = teamA - teamB;
            if (df == diff) {
                if (teamA > first) {
                    first = teamA;
                    second = teamB;
                }
            } else if (df > diff) {
                first = teamA;
                second = teamB;
                diff = df;
            }
        }
        out.println(first + ":" + second);
    }
    
    private int binarySearch(List<? extends Integer> list, int d) {
        int left = 0, right = list.size() - 1;
        if (list.get(0) > d) return -1;
        if (list.get(list.size() - 1) < d) return list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = list.get(mid);
            if (value <= d) {
                left = mid + 1;
            } else {
                right = mid - 1;    
            }
        }
        return left - 1;
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
        try (VasyaAndBasketball instance = new VasyaAndBasketball()) {
            instance.solve();
        }
    }
}
