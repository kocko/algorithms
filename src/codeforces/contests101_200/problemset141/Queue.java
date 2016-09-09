package codeforces.contests101_200.problemset141;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Queue implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Person {
        String name;
        int taller;
        int height;

        Person(String name, int taller) {
            this.name = name;
            this.taller = taller;
        }


        public String toString() {
            return name + " " + (height + 1);
        }
    }

    public void solve() {
        int n = in.ni();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(in.next(), in.ni()));
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.taller, b.taller));
        Person[] result = new Person[n];
        for (int i = 0; i < n; i++) {
            Person p = list.get(i);
            if (p.taller > i) {
                out.println(-1);
                return;
            }
            int x = i - p.taller;
            for (int j = 0; j < i; j++) {
                if (result[j].height >= x) {
                    result[j].height++;
                }
            }
            p.height = x;
            result[i] = p;
        }

        list.forEach(out::println);
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
        try (Queue instance = new Queue()) {
            instance.solve();
        }
    }
}
