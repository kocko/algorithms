package codeforces.contests101_200.problemset149;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DivisionIntoTeams implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Player implements Comparable<Player> {
        int index;
        int skill;
        
        private Player(int index, int skill) {
            this.index = index;
            this.skill = skill;
        }

        @Override
        public int compareTo(Player o) {
            int a = Integer.compare(this.skill, o.skill);
            return a != 0 ? -a : -Integer.compare(this.index, o.index);
        }
    }
    
    public void solve() {
        int n = in.ni();
        List<Player> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Player(i, in.ni()));
        }
        Collections.sort(list);
        List<Player> a = new ArrayList<>();
        List<Player> b = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            a.add(list.get(i));
            if (i + 1 < n) {
                b.add(list.get(i + 1));
            }
        }
        print(a);
        print(b);
    }
    
    private void print(List<? extends Player> list) {
        out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i).index + " ");
        }
        out.println();
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
        try (DivisionIntoTeams instance = new DivisionIntoTeams()) {
            instance.solve();
        }
    }
}
