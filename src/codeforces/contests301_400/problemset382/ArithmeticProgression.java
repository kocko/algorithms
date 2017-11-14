package codeforces.contests301_400.problemset382;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ArithmeticProgression implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 1) {
            out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.ni());
        }
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int diff = list.get(i) - list.get(i - 1);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        if (map.size() == 1) {
            int diff = map.entrySet().iterator().next().getKey();
            if (diff != 0 && diff % 2 == 0 && n == 2) {
                out.println(3);
                out.print(list.get(0) - diff);
                out.print(' ');
                out.print((list.get(1) + list.get(0)) / 2);
                out.print(' ');
                out.print(list.get(n - 1) + diff);
                return;
            }
            if (diff == 0) {
                out.println(1);
                out.println(list.get(0));
            } else {
                out.println(2);
                out.print(list.get(0) - diff);
                out.print(' ');
                out.print(list.get(n - 1) + diff);
            }
        } else if (map.size() == 2) {
            int[] diff = new int[2];
            int[] cnt = new int[2];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                diff[idx] = entry.getKey();
                cnt[idx] = entry.getValue();
                idx++;
            }
            if (cnt[0] == 1 && cnt[1] == 1) {
                int max = Math.max(diff[0], diff[1]), min = Math.min(diff[0], diff[1]);
                if (max % 2 == 0 && max / 2 == min) {
                    out.println(1);
                    for (int i = 1; i < n; i++) {
                        if (list.get(i) - list.get(i - 1) == max) {
                            out.println((list.get(i) + list.get(i - 1)) / 2);
                            break;
                        }
                    }
                } else {
                    out.println(0);
                }
            } else if (cnt[0] >= 2 && cnt[1] >= 2) {
                out.println(0);
            } else {
                int d = cnt[0] != 1 ? diff[0] : diff[1], other = cnt[0] != 1 ? diff[1] : diff[0];
                if (other == 0 || other % 2 == 1 || other / 2 != d) {
                    out.println(0);
                } else {
                    out.println(1);
                    for (int i = 1; i < n; i++) {
                        if (list.get(i) - list.get(i - 1) == other) {
                            out.println((list.get(i) + list.get(i - 1)) / 2);
                            break;
                        }
                    }
                }
            }
        } else {
            out.println(0);
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
        try (ArithmeticProgression instance = new ArithmeticProgression()) {
            instance.solve();
        }
    }
}
