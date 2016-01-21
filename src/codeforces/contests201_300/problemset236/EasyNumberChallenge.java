package codeforces.contests201_300.problemset236;

import java.io.*;

public class EasyNumberChallenge implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public void solve() throws IOException {
        String[] line = in.readLine().split("\\s+");
        int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]), c = Integer.parseInt(line[2]);
        int[] data = new int[a * b * c + 1];
        long result = 0L;
        final long MOD = 1073741824;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    int next = i * j * k;
                    if (data[next] == 0) {
                        data[next] = d(i * j * k);
                    }
                    result += (data[next] % MOD);
                }
            }
        }
        System.out.println(result);
    }

    int d(int x) {
        int limit = x;
        int numberOfDivisors = 0;

        if (x == 1) return 1;

        for (int i = 1; i < limit; ++i) {
            if (x % i == 0) {
                limit = x / i;
                if (limit != i) {
                    numberOfDivisors++;
                }
                numberOfDivisors++;
            }
        }

        return numberOfDivisors;
    }

    public static void main(String[] args) throws IOException {
        new EasyNumberChallenge().solve();
    }

}
