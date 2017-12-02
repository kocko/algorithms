package topcoder.tchs.srm03;

public class BestSeller {

    public String findBestSeller(String[] items) {
        String result = null;
        int n = items.length, max = 0;
        for (String x : items) {
            int count = 0;
            for (String y : items) {
                if (y.equals(x)) count++;
            }
            if (count > max) {
                max = count;
                result = x;
            } else if (count == max) {
                if (result != null && x.compareTo(result) < 0) {
                    result = x;
                }
            }
        }
        return result;
    }
    
}
