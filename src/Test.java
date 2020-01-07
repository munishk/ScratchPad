import java.text.ParseException;

public class Test {

	public static void main(String[] args) throws ParseException {
		int n = 16;
		int h = (int)Math.ceil(Math.log(n) / Math.log(2));
		int size = (1 << (h + 1)) - 1;
		System.out.println(size +  ":" + h);

	}
}
