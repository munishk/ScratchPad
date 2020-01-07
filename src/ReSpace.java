import java.util.HashSet;
import java.util.Set;

public class ReSpace {

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("hello");
		dictionary.add("brother");
		dictionary.add("her");
		//ParsingResult result = respace(dictionary, "brother", 0, new HashMap<String, ReSpace.ParsingResult>());
		ParsingResult result = respaceUsingForloop(dictionary, "hellobrother");
        System.out.println(result);
	}
	
	private static ParsingResult respaceUsingForloop(Set<String> dictionary,
			final String sentence){
		ParsingResult result = new ParsingResult(Integer.MAX_VALUE, "", "");

		for(int n=sentence.length() -1; n >=0; n--) {
			String partial = sentence.charAt(n) + result.suffix;
			int invalid = dictionary.contains(partial) ? 0 : partial.length();
			if(invalid == 0) {
				result = new ParsingResult(0, partial, partial);
			}else {
				result = new ParsingResult(result.invalid + 1, sentence.charAt(n) + " " + result.parsed,partial );
			}
		}
		return result;
	}

	private static ParsingResult respace(Set<String> dictionary,
			final String sentence, int start, java.util.Map<String, ParsingResult> cache) {
		if (start >= sentence.length()) {
			return new ParsingResult(0, "");
		}

		int bestInvalid = Integer.MAX_VALUE;
		String bestParsing = "";
		String partial = "";
		int index = start;
		while (index < sentence.length()) {
			char c = sentence.charAt(index);
			partial = partial + c;
			int invalid = dictionary.contains(partial) ? 0 : partial.length();
			if (invalid < bestInvalid) {
				 String suffix = sentence.substring(index, sentence.length());
				 ParsingResult result;
				if(cache.containsKey(suffix)) {
					result = cache.get(suffix);
				}else {
				 result = respace(dictionary, sentence, index + 1, cache);
				 cache.put(result.parsed.trim(), result);
				}
				if (invalid + result.invalid < bestInvalid) {
					bestInvalid = invalid + result.invalid;
					bestParsing = partial + " " + result.parsed;
					if (bestInvalid == 0)
						break;
				}
			}
			index++;
		}
		return new ParsingResult(bestInvalid, bestParsing);
	}

	private static class ParsingResult {
		int invalid = Integer.MAX_VALUE;
		String parsed = " ";
		String suffix = "";

		public ParsingResult(int invalid, String parsed) {
			this.invalid = invalid;
			this.parsed = parsed;
		}
		
		public ParsingResult(int invalid, String parsed, String suffix) {
			this.invalid = invalid;
			this.parsed = parsed;
			this.suffix = suffix;
		}

		@Override
		public String toString() {
			return "Parsed: " + parsed + "\n" + "Invalid: " + invalid;
		}
	}

}
