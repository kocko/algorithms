package topcoder.contests300_400.srm308;

import java.util.Arrays;

public class MedianOfNumbers {
	
	public int findMedian(int[] numbers) {
        int n = numbers.length;
		if (n % 2 == 0) {
            return -1;
        } else {
            Arrays.sort(numbers);
            return numbers[n / 2];
        }
	}
    
}
