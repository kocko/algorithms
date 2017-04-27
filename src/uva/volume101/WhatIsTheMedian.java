package uva.volume101;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WhatIsTheMedian implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.nextInt());
            Collections.sort(list);
            int size = list.size();
            if (size % 2 == 1) {
                out.println(list.get(size / 2));
            } else {
                int sum = list.get(size / 2) + list.get(size / 2 - 1);
                out.println(sum / 2);
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (WhatIsTheMedian instance = new WhatIsTheMedian()) {
            instance.solve();
        }
    }
}
