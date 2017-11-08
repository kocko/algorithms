package codeforces.contests001_100.problemset075;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FacetookPriorityWall implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String me = in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        Set<String> names = new HashSet<>();
        names.add(me);
        List<Operation> operations = new ArrayList<>();
        while (n-- > 0) {
            Operation op = convert(in.nextLine());
            operations.add(op);
            names.add(op.from);
            names.add(op.to);
        }
        n = names.size();
        int[] scores = new int[n];
        String[] index = new String[n];
        Map<String, Integer> inverted = new HashMap<>();
        int idx = 0;
        for (String name : names) {
            index[idx] = name;
            inverted.put(name, idx);
            idx++;
        }
        for (Operation op : operations) {
            if (me.equals(op.from)) {
                scores[inverted.get(op.to)] += op.score();
            } else if (me.equals(op.to)) {
                scores[inverted.get(op.from)] += op.score();
            }
        }
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != inverted.get(me)) {
                list.add(new Person(index[i], scores[i]));
            }
        }
        list.sort(Comparator.naturalOrder());
        for (Person p : list) {
            out.println(p.name);
        }
    }

    private class Person implements Comparable<Person> {
        private String name;
        private int score;

        private Person(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            int x = -Integer.compare(this.score, o.score);
            return x != 0 ? x : name.compareTo(o.name);
        }
    }

    private class Operation {
        private String from, to, action;

        private Operation(String from, String to, String action) {
            this.from = from;
            this.to = to;
            this.action = action;
        }

        private int score() {
            switch (action) {
                case "posted":
                    return 15;
                case "commented":
                    return 10;
                case "likes":
                    return 5;
            }
            return 0;
        }
    }

    private Operation convert(String line) {
        String from, to;
        String[] split = line.split("\\s+");
        from = split[0];
        if ("likes".equals(split[1])) {
            to = split[2].substring(0, split[2].length() - 2);
        } else {
            to = split[3].substring(0, split[3].length() - 2);
        }
        String operation = split[1];
        return new Operation(from, to, operation);
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (FacetookPriorityWall instance = new FacetookPriorityWall()) {
            instance.solve();
        }
    }
}
