import java.util.*;

public class Permutation {

	private static Map<Character, List<Character>> charMap = new HashMap<>();

	static {
		charMap.put('2', Arrays.asList('A', 'B', 'C'));
		charMap.put('3', Arrays.asList('D', 'E', 'F'));
		charMap.put('4', Arrays.asList('G', 'H', 'I'));
		charMap.put('5', Arrays.asList('J', 'K', 'L'));
		charMap.put('6', Arrays.asList('M', 'N', 'O'));
		charMap.put('7', Arrays.asList('P', 'Q', 'R', 'S'));
		charMap.put('8', Arrays.asList('T', 'U', 'V'));
		charMap.put('9', Arrays.asList('W', 'X', 'Y', 'Z'));
	}

	public static void main(String[] args) {
		//System.out.println(permutationRecursion("2"));
		
		System.out.println(permutationUsingForloop("2345"));

	}
	
	private static List<List<Character>> permutationUsingForloop(String number) {

		List<List<Character>> charListOfList = new ArrayList<>();
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			charListOfList.add(charMap.get(c));
		}

		return permutationUsingForloop(charListOfList);

	}

	private static List<String> permutationRecursion(String number) {

		List<List<Character>> charListOfList = new ArrayList<>();
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			charListOfList.add(charMap.get(c));
		}

		List<String> output = new ArrayList<>();
		permutationRecursion(charListOfList, "", charListOfList.size(), output);


		return output;

	}
	
	private static List<List<Character>> permutationUsingForloop(List<List<Character>> charListOfList) {
		
		List<List<Character>> subList = new ArrayList<>();
		for(Character c: charListOfList.get(0)) {
			subList.add(Arrays.asList(c));
		}
		
		for(int i= 1; i < charListOfList.size() -1; i++ ) {
			List<Character> charList = charListOfList.get(i);
			List<List<Character>> result = new ArrayList<>(subList.size() * charList.size()); 
			for(Character outerChar: charList) {
				for(List<Character> innerList: subList) {
					List<Character> newCharList = new ArrayList<Character>();
					newCharList.add(outerChar);
					newCharList.addAll(innerList);
					result.add(newCharList);
				}
			}
			subList = result;
		}
		
		return subList;
	}

	private static void permutationRecursion(List<List<Character>> charListOfList,
			String prefix, int num, List<String> output) {

		if (num == 0) {
			output.add(prefix);
		} else {
			List<Character> listChar = charListOfList.get(charListOfList.size()
					- num);

			for (int i = 0; i < listChar.size(); i++) { 
				permutationRecursion(charListOfList, prefix + listChar.get(i), num - 1, output);
			}
		}
	}
}
