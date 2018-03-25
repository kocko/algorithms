package codeforces.contests901_1000.problemset955;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NotSimplyBeautifulStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int[] count = new int[26];
        int total = 0;
        for (char c : x) {
            count[c - 'a']++;
            if (count[c - 'a'] == 1) total++;
        }
        boolean ok = true;
        if (total == 4) {
            ok = true;
        } else if (total == 3 || total == 2) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    list.add(count[i]);
                }
            }
            boolean allAreOnes = true, atLeastOne = false;
            for (int i : list) {
                allAreOnes &= i == 1;
                atLeastOne |= i == 1;
            }
            if (total == 3 && allAreOnes) ok = false;
            else if (total == 2 && atLeastOne) ok = false; 
        } else {
            ok = false;
        }
        out.println(ok ? "Yes" : "No");
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
        try (NotSimplyBeautifulStrings instance = new NotSimplyBeautifulStrings()) {
            instance.solve();
        }
    }
}
