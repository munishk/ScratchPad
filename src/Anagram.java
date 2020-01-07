import java.util.ArrayList;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		String input = "catr";
		List<String> result = computeAnagram(input);
		System.out.println(result);


	}

	static List<String> computeAnagram(final String input) {
		List<String> result = new ArrayList<String>();
		compute(input, "", result);
		return result;
	}

	static void compute(String input, String prefix, 
			List<String> result) {
		if (input.length() == 0) {
			result.add(prefix);
		}else {

		for (int i = 0; i < input.length(); i++) {
			
			compute(input.substring(0, i) + input.substring(i+1, input.length()), prefix + input.charAt(i),  result);
		}
		}
	}

}
