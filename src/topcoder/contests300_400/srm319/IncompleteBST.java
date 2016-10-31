package topcoder.contests300_400.srm319;

public class IncompleteBST {

	private class Node {
		char value;
		Node(char value) {
			this.value = value;
		}
	}

	private Node[] tree = new Node[600000];

	public String missingValues(String[] input) {
		int missingIndex = -1;
		for (String s : input) {
			String[] split = s.split("\\s+");
			int index = Integer.parseInt(split[1]);
			String value = split[0];
			if ("?".equals(value)) {
				missingIndex = index;	
			}
			tree[index] = new Node(value.charAt(0));
		}
		
		String result = "";
		for (char c = 'A'; c <= 'Z'; c++) {
			tree[missingIndex].value = c;
			if (valid(1, (char) ('A' - 1), 'Z')) {
				result += c;
			}
		}
		return result;
	}
	
	private boolean valid(int i, char min, char max) {
		Node node = tree[i];
		return node == null || node.value > min && node.value <= max && valid(i << 1, min, node.value) && valid(i << 1 | 1, node.value, max);
	}

}
