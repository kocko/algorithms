package uva.volume101;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class IsBiggerSmarter implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        List<Elephant> list = new ArrayList<>();
        int idx = 1;
        while (in.hasNextInt()) {
            list.add(new Elephant(idx++, in.nextInt(), in.nextInt()));
        }
        sort(list);
        int n = list.size();
        int[] next = new int[n], size = new int[n];
        int maxGlobal = 0, index = -1;
        for (int i = n - 1; i >= 0; i--) {
            int nxt = -1, max = 0, iq = list.get(i).iq;
            for (int j = i + 1; j < n; j++) {
                if (list.get(i).weight < list.get(j).weight && list.get(j).iq < iq && size[j] > max) {
                    max = size[j];
                    nxt = j;
                }
            }
            next[i] = nxt;
            size[i] = max + 1;
            if (size[i] > maxGlobal) {
                maxGlobal = size[i];
                index = i;
            }
        }
        out.println(maxGlobal);
        while (index != -1) {
            out.println(list.get(index).idx);
            index = next[index];
        }
    }

    private class Elephant implements Comparable<Elephant> {
        private int idx, weight, iq;

        private Elephant(int idx, int weight, int iq) {
            this.idx = idx;
            this.weight = weight;
            this.iq = iq;
        }

        @Override
        public String toString() {
            return weight + " " + iq;
        }

        @Override
        public int compareTo(Elephant o) {
            int x = Integer.compare(this.weight, o.weight);
            return x != 0 ? x : Integer.compare(o.iq, this.iq);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (IsBiggerSmarter instance = new IsBiggerSmarter()) {
            instance.solve();
        }
    }
}
