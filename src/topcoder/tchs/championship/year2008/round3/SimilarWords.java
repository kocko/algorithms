package topcoder.tchs.championship.year2008.round3;

public class SimilarWords {

    public int mostSimilarPair(String[] words) {
        int max = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int similarity = calculate(words[i].toLowerCase(), words[j].toLowerCase());
                if (similarity > max) max = similarity;
            }
        }
        return max;
    }
    
    private int calculate(String a, String b) {
        int[] x = new int[26], y = new int[26];
        for (char c : a.toCharArray()) {
            x[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            y[c - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.min(x[i], y[i]);
        }
        return result;
    }
    
}
