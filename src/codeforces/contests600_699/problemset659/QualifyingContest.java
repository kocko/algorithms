package codeforces.contests600_699.problemset659;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class QualifyingContest implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Person {
        String name;
        int team;
        int score;

        Person(String name, int team, int score) {
            this.name = name;
            this.team = team;
            this.score = score;
        }

        public int getTeam() {
            return team;
        }

        public int getScore() {
            return score;
        }
    }

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(in.next(), in.ni(), in.ni()));
        }
        Comparator<Person> comparator = Comparator.comparing(Person::getTeam).thenComparing(Person::getScore, reverseOrder());
        Map<Integer, List<Person>> map =
                list.stream()
                    .sorted(comparator)
                    .collect(Collectors.groupingBy(Person::getTeam));
        map.entrySet()
            .stream()
            .map(Map.Entry::getValue)
            .map(team -> {
                if (team.size() > 2 && (team.get(1).getScore() == team.get(2).getScore())) return "?";
                else return team.get(0).name + " " + team.get(1).name;
            }).forEach(out::println);
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
        new QualifyingContest().solve();
    }
}
