package topcoder.contests300_400.srm308;

public class HuffmanDecoding {
	
	public String decode(String archive, String[] dictionary) {
		String current = "";
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < archive.length(); i++) {
            current += archive.charAt(i);
            for (int j = 0; j < dictionary.length; j++) {
                if (dictionary[j].equals(current)) {
                    sb.append((char) ('A' + j));
                    current = "";
                    break;
                }
            }
        }
        return sb.toString();
	}
    
}
