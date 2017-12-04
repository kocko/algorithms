package uva.volume005;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeRingProblem implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int test = 1;
        while (in.hasNextLine()) {
            if (test > 1) out.println();
            n = Integer.parseInt(in.nextLine());
            forward = new ArrayList<>();
            used = new boolean[n + 1];
            temp = new int[n];
            temp[0] = 1;
            recurse(1);
            out.printf("Case %d:\n", test++);
            for (int[] f : forward) {
                for (int i = 0; i < n; i++) {
                    out.print(f[i]);
                    if (i < n - 1) out.print(' ');
                }
                out.println();
            }
        }
    }

    private boolean isPrime(int n) {
        switch (n) {
            case 2: case 3: case 5: case 7: case 11: case 13:
            case 17: case 19: case 23: case 29: case 31: return true;
        }
        return false;
    }
    
    private int n;
    private List<int[]> forward = new ArrayList<>();
    private int[] temp;
    private boolean[] used;
    
    private void recurse(int idx) {
        if (idx == n && isPrime(temp[0] + temp[n - 1])) {
            int[] f = new int[n];
            System.arraycopy(temp, 0, f, 0, n);
            forward.add(f);
        } else {
            for (int i = 2; i <= n; i++) {
                if (!used[i]) {
                    if (isPrime(temp[idx - 1] + i)) {
                        used[i] = true;
                        temp[idx] = i;
                        recurse(idx + 1);
                        temp[idx] = 0;
                        used[i] = false;
                    }
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (PrimeRingProblem instance = new PrimeRingProblem()) {
            instance.solve();
        }
    }
}
