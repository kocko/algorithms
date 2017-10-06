package codeforces.contests101_200.problemset200;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FootballChampionship implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Team implements Comparable<Team> {
        private String name;
        
        private int scored;
        private int conceded;
        private int points;
        
        private int games;
        
        private Team(String name) {
            this.name = name;
        }
        
        private Team(String name, int scored, int conceded, int points, int games) {
            this.name = name;
            this.points = points;
            this.scored = scored;
            this.conceded = conceded;
        }

        @Override
        public int compareTo(Team o) {
            int points = -Integer.compare(this.points, o.points);
            if (points != 0) return points;
            
            int diff = -Integer.compare(getDiff(), o.getDiff());
            if (diff != 0) return diff; 
            
            int scored = -Integer.compare(this.scored, o.scored);
            if (scored != 0) return scored;
            
            return this.name.compareTo(o.name);
        }
        
        private int getDiff() {
            return this.scored - this.conceded;
        }
        
        private Team copy() {
            return new Team(name, scored, conceded, points, games);
        }
    }
    
    private List<Team> table = new ArrayList<>();
    
    public void solve() {
        for (int i = 0; i < 5; i++) {
            String a = in.next(), b = in.next(), score = in.next();
            String[] split = score.split(":");
            Team x = findOrCreate(a);
            x.games++;
            x.scored += Integer.parseInt(split[0]);
            x.conceded += Integer.parseInt(split[1]);
            
            Team y = findOrCreate(b); 
            y.games++;
            y.scored += Integer.parseInt(split[1]);
            y.conceded += Integer.parseInt(split[0]);
            if (split[0].equals(split[1])) {
                x.points++;
                y.points++;
            } else if (Integer.parseInt(split[0]) < Integer.parseInt(split[1])) {
                y.points += 3;
            } else {
                x.points += 3;
            }
        }
        Collections.sort(table);
        if (isFirstOrSecond(table)) {
            out.println("1:0");
        } else {
            Team second = table.get(1);
            int berlandIdx = -1, otherIdx = -1;
            for (int i = 0; i < 4; i++) {
                Team team = table.get(i);
                if ("BERLAND".equals(team.name)) {
                    berlandIdx = i;
                } else if (team.games == 2) {
                    otherIdx = i;     
                }
            }
            int diff = second.points - table.get(berlandIdx).points; 
            if (diff < 3) {
                out.println("1:0");
            } else if (diff == 3) {
                int a = 60, b = -1;
                for (int score = 1; score <= 50; score++) {
                    for (int concede = 0; concede <= score - 1; concede++) {
                        List<Team> temp = new ArrayList<>();
                        for (int t = 0; t < 4; t++) {
                            temp.add(table.get(t).copy());
                        }
                        temp.get(berlandIdx).points += 3;
                        temp.get(berlandIdx).scored += score;
                        temp.get(berlandIdx).conceded += concede;
                        temp.get(otherIdx).scored += concede;
                        temp.get(otherIdx).conceded += score;
                        Collections.sort(temp);
                        if (isFirstOrSecond(temp)) {
                            if (a - b == score - concede) {
                                if (concede < b) {
                                    a = score;
                                    b = concede;
                                }
                            } else if (a - b > score - concede) {
                                a = score;
                                b = concede;
                            }
                        }
                    }
                }
                out.printf("%d:%d\n", a, b);
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }
    
    private Team findOrCreate(String name) {
        for (Team next : table) {
            if (next.name.equals(name)) return next;
        }
        Team result = new Team(name);
        table.add(result);
        return result;
    }
    
    private boolean isFirstOrSecond(List<Team> table) {
        return "BERLAND".equals(table.get(0).name) || "BERLAND".equals(table.get(1).name);
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
        try (FootballChampionship instance = new FootballChampionship()) {
            instance.solve();
        }
    }
}
