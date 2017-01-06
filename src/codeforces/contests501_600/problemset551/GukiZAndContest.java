package codeforces.contests501_600.problemset551;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class GukiZAndContest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Student implements Comparable<Student> {
        private int index;
        private int rating;
        private int place;
        
        private Student(int index, int rating) {
            this.index = index;
            this.rating = rating;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.rating, o.rating);
        }
    }

    public void solve() {
        int n = in.ni();
        List<Student> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(new Student(i, in.ni()));
        }
        x.sort(Comparator.reverseOrder());
        x.get(0).place = 1;
        for (int i = 1; i < n; i++) {
            if (x.get(i).rating == x.get(i - 1).rating) {
                x.get(i).place = x.get(i - 1).place;
            } else {
                x.get(i).place = i + 1;
            }
        }
        x.sort(Comparator.comparingInt(a -> a.index));
        for (Student s : x) {
            out.print(s.place + " ");
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
        try (GukiZAndContest instance = new GukiZAndContest()) {
            instance.solve();
        }
    }
}
