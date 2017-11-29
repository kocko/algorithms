package topcoder.contests701_800.srm724;

public class GravityPuzzleEasy {

    public String[] solve(String[] board) {
        int n = board.length, m = board[0].length();
        int[] count = new int[board[0].length()];
        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '#') count[i]++;
            }
        }
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = '#';
            }
            int dots = n - count[i];
            for (int j = 0; j < dots; j++) {
                result[j][i] = '.';
            }
        }
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = new String(result[i]);
        }
        return ans;
    }
    
}
