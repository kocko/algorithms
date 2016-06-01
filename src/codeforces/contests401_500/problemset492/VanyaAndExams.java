package codeforces.contests401_500.problemset492;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class VanyaAndExams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Exam implements Comparable<Exam> {
        long mark;
        long essays;
        
        public Exam(long mark, long essays) {
            this.mark = mark;
            this.essays = essays;
        }
        
        @Override
        public int compareTo(Exam o) {
            int x = Long.compare(this.essays, o.essays);
            return x == 0 ? Long.compare(this.mark, o.mark) : x;
        }
        
    }
    
    public void solve() {
        long n = in.nl(), r = in.nl(), a = in.nl();
        a *= n;
        List<Exam> list = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < n; i++) {
            long mark = in.nl(), essays = in.nl();
            total += mark;
            list.add(new Exam(mark, essays));
        }
        double temp = (double) total / n;
        if (temp >= a) {
            out.println(0);
            return;
        }
        Collections.sort(list);
        long result = 0;
        int i = 0;
        while (total < a) {
            Exam next = list.get(i);
            if ((r - next.mark) <= a - total) {
                total += (r - next.mark);
                result += next.essays * (r - next.mark);
            } else {
                result += (a - total) * next.essays;
                total = a;
            }
            i++;
        }
        out.println(result);
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
        new VanyaAndExams().solve();
    }
}
