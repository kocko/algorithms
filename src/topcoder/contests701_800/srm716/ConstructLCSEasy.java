package topcoder.contests701_800.srm716;

public class ConstructLCSEasy {

    public String construct(int ab, int bc, int ca) {
		StringBuilder[] result = new StringBuilder[3];
		for (int i = 0; i < 3; i++) result[i] = new StringBuilder();
		for (int i = 0; i < ca; i++) {
			result[0].append('1');
			result[2].append('1');
		}
		for (int i = 0; i < 50; i++) {
			result[1].append('0');
		}
		for (int i = 0; i < ab; i++) {
			result[0].append('0');
		}
		for (int i = 0; i < bc; i++) {
			result[2] = new StringBuilder().append('0').append(result[2]);
		}
		return result[0] + " " + result[1] + " " + result[2];
	}
}
