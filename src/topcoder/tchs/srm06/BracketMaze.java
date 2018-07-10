package topcoder.tchs.srm06;

public class BracketMaze {

    public int properPaths(String[] maze, int n) {
        this.n = n;
        this.maze = new char[n * n * n + 1];
        int idx = 1;
        for (String s : maze) for (char c : s.toCharArray()) this.maze[idx++] = c;
        dp = new Long[n * n * n + 1][n * n * n];
        delta = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        long ans = recurse(1, 1, 1, offset(this.maze[1]));
        return ans > MAX ? -1 : (int) ans;
    }

    private int n;
    private long MAX = (long) 1e9;
    private int[][] delta;
    private char[] maze;

    private Long[][] dp;

    private Long recurse(int x, int y, int z, int balance) {
        if (balance == -1) return 0L;

        int idx = getIndex(x, y, z);
        if (idx == n * n * n) return (balance == 0) ? 1L : 0L;
        if (idx > n * n * n) return 0L;

        if (dp[idx][balance] != null) return dp[idx][balance];

        long ans = 0;
        int[] steps = new int[]{getIndex(x + 1, y, z), getIndex(x, y + 1, z), getIndex(x, y, z + 1)};
        for (int i = 0; i < 3; i++) {
            if (steps[i] != -1) {
                int offset = offset(maze[steps[i]]);
                if (balance + offset >= 0) {
                    ans += recurse(x + delta[i][0], y + delta[i][1], z + delta[i][2], balance + offset);
                }
            }
        }
        return dp[idx][balance] = ans;
    }

    private int getIndex(int x, int y, int z) {
        if (x < 0 || x > n || y < 0 || y > n || z < 0 || z > n) return -1;
        return n * n * (z - 1) + n * (y - 1) + x;
    }

    private int offset(char c) {
        if (c == '(') return 1;
        if (c == ')') return -1;
        return 0;
    }

}
