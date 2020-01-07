public class Pattern {
	
	public static void main(String[] args) {
		System.out.println(matches("a", "catcatgocatgo"));
	}
	
	
	private static boolean matches(final String pattern, final String value) {
		for(int mainSize = 0; mainSize < value.length();mainSize++) {
			      String main = value.substring(0, mainSize);
			for(int altStart = mainSize; altStart <= value.length(); altStart++) {
				for(int altEnd = altStart; altEnd <= value.length(); altEnd++) {
					String alt = value.substring(altStart, altEnd);
					String cand = buildFromPattern(pattern, main, alt);
					System.out.println("Main: " + main + ", Alt: " + alt);
					//System.out.println( "Generated pattern: " + cand);
					if(cand.equals(value)) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
	
	private static String buildFromPattern(final String pattern, final String main, final String alt) {

		StringBuilder strBuilder = new StringBuilder();
		char first = pattern.charAt(0);
		
		for(char c: pattern.toCharArray()) {
			if(c == first) {
				strBuilder.append(main);
			}else {
				strBuilder.append(alt);
			}
		}
		return strBuilder.toString();
	}

}
