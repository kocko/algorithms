package codeforces.contests501_600.problemset507;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class AmrAndMusic implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Instrument implements Comparable<Instrument> {
        int idx;
        int days;
        
        private Instrument(int idx, int days) {
            this.idx = idx;
            this.days = days;
        }

        @Override
        public int compareTo(Instrument o) {
            return Integer.compare(this.days, o.days);
        }
    }

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Instrument> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Instrument(i, in.ni()));
        }
        Collections.sort(list);
        int total = 0;
        List<Instrument> learn = new ArrayList<>();
        for (Instrument next : list) {
            if (total + next.days > k) break;
            learn.add(next);
            total += next.days;
        }
        out.println(learn.size());
        for (Instrument instrument : learn) {
            out.print(instrument.idx + " ");
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
        try (AmrAndMusic instance = new AmrAndMusic()) {
            instance.solve();
        }
    }
}
