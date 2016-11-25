package codeforces.contests401_500.problemset493;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class VasyaAndFootball implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Player {
        String team;
        int number;
        int minuteSuspended;
        
        private Player(String team, int number) {
            this.team = team;
            this.number = number;
        }

        @Override
        public boolean equals(Object obj) {
            Player p = (Player) obj;
            return this.number == p.number && this.team.equals(p.team);
        }

        @Override
        public String toString() {
            return team + " " + number + " " + minuteSuspended;
        }
    }
    
    public void solve() {
        String h = in.next(), a = in.next();
        int n = in.ni();
        List<Player> players = new ArrayList<>();
        List<Player> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = in.ni();
            String team = "h".equals(in.next()) ? h : a;
            int number = in.ni();
            String type = in.next();
            Player p = new Player(team, number);
            if (type.equals("y")) {
                boolean suspended = false;
                for (Player x : result) {
                    if (x.equals(p)) {
                        suspended = true;
                        break;
                    }
                }
                if (suspended) continue;
                boolean found = false;
                for (Player x : players) {
                    if (x.equals(p)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    p.minuteSuspended = t;
                    result.add(p);
                } else {
                    players.add(p);
                }
            } else {
                boolean found = false;
                for (Player x : result) {
                    if (x.equals(p)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    p.minuteSuspended = t;
                    result.add(p);
                }
            }
        }
        Collections.sort(result, (o1, o2) -> Integer.compare(o1.minuteSuspended, o2.minuteSuspended));
        result.forEach(out::println);
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
        try (VasyaAndFootball instance = new VasyaAndFootball()) {
            instance.solve();
        }
    }
}
