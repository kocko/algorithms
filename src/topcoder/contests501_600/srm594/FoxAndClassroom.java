package topcoder.contests501_600.srm594;

public class FoxAndClassroom {

    public String ableTo(int n, int m) {
        for (int i = 2; i <= 10; i++) {
            if (n % i == 0 && m % i == 0) {
                return "Impossible";
            }
        }
        return "Possible";
    }
    
}
