import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class chineseSpacer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = scan();
		String modified = null;
		for (int i = 0; i < input.length(); i++) {
			String placeHolder = input.substring(i, i + 1);
			String alphus;
			try {
				alphus = new String(placeHolder.getBytes("utf-8"));
				modified = modified + alphus + " ";

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(modified);
	}

	public static String scan() {
		Scanner sc = new Scanner(System.in, "utf-8");
		String input = sc.next();

		sc.close();
		return input;
	}

}
