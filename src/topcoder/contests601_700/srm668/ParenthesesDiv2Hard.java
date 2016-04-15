package topcoder.contests601_700.srm668;

public class ParenthesesDiv2Hard {

    int open, close;
    boolean[] used;
    String s;

    public int minSwaps(String s, int[] l, int[] r) {
        this.s = s;
        init(s); used = new boolean[s.length()];
        int n = l.length, result = 0;
        int open = this.open, close = this.close;
        for (int i = 0; i < n; i++) {
            boolean ok = isValid(l[i], r[i]);
            if (!ok) {
                int score = score(l[i], r[i]);
                if (score == 0) {
                    result += findMin(l[i], r[i]);
                } else {
                    if (score % 2 == 0) {
                        int need = (score / 2);
                        result += need;
                        if (score > 0) {
                            close -= need;
                            open += need;
                        } else {
                            open -= need;
                            close += need;
                        }
                    } else {
                        return -1;
                    }
                }
            }
        }
        if (open != this.open || close != this.close) return -1;
        return result;
    }

    private boolean isValid(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += (s.charAt(i) == '(' ? 1 : -1);
            if (count < 0) return false;
        }
        return count == 0;
    }

    private int score(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += (s.charAt(i) == '(' ? 1 : -1);
        }
        return result;
    }

    private void init(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') open++;
            else close++;
        }
    }

    private int findMin(int left, int right) {
        int result = 0;
        int current = 0;
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            current += (c == '(' ? 1 : -1);
            if (Math.abs(current) > result) {
                result = Math.abs(current);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ParenthesesDiv2Hard().minSwaps(")()(((())(", new int[]{0,4}, new int[]{3,7}));
    }
}
