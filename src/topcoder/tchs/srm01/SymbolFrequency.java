package topcoder.tchs.srm01;

public class SymbolFrequency {

    public double language(String[] frequencies, String[] text) {
        double result = Double.MAX_VALUE;
        for (String frequency : frequencies) {
            int[] map = parse(frequency);
            int[] count = new int[26];
            int total = 0;
            for (String x : text) {
                for (char c : x.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        count[c - 'a']++;
                        total++;
                    }
                }
            }
            double deviation = 0;
            for (int i = 0; i < 26; i++) {
                deviation += (100. * count[i] - map[i] * total) * (100. * count[i] - map[i] * total) / total * total;
            }
            if (deviation < result) result = deviation;
        }
        return result / 10000.;
    }
    
    private int[] parse(String x) {
        int[] result = new int[26];
        for (int i = 0; i < x.length(); i += 3) {
            char c = x.charAt(i);
            int percentage = 10 * (x.charAt(i + 1) - '0') + (x.charAt(i + 2) - '0');
            result[c - 'a'] = percentage;
        }
        return result;
    }
    
}
