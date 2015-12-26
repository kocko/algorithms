package codeforces.contests101_200.problemset137;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class History {

    static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Event> set = new TreeSet<Event>(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        for (int i = 0; i < n; i++) {
            set.add(new Event(sc.nextInt(), sc.nextInt()));
        }

        Iterator<Event> iterator = set.iterator();
        int maxEnd = iterator.next().end;
        int result = 0;
        while (iterator.hasNext()) {
            Event next = iterator.next();
            if (next.end > maxEnd) {
               maxEnd = next.end;
            } else {
                result++;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
