package topcoder.contests401_500.srm483;

public class MovieSeating {

    public long getSeatings(int numFriends, String[] hall) {
        int n = hall.length, m = hall[0].length();
        char[][] x = new char[n][m], y = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = hall[i].charAt(j);
                y[j][i] = hall[i].charAt(j);
            }
        }
        long result = count(numFriends, x);
        if (numFriends > 1) {
            result += count(numFriends, y);
        }
        return result;
    }

    private long count(int f, char[][] grid) {
        int n = grid.length, m = grid[0].length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            long current = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    current++;
                }
            }
            if (current >= f) {
                result += comb(current, f) * fact(f);
            }
        }
        return result;
    }
    
    private long fact(long n) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private long comb(long n, long k) {
        if (k == 0) return 1L;
        return (n * comb(n - 1, k - 1)) / k;
    }
}
