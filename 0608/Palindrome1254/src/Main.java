import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int ans=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		ans = getResult(s);
		System.out.println(ans);
		
	}

	static boolean isPalindrome(String subStr) {
		int len = subStr.length();
		for (int i = 0; i < len; i++) {
			if (subStr.charAt(i) != subStr.charAt(len - i - 1))
				return false;
		}
		return true;
	}
	
	private static int getResult(String input) {

		int len = input.length();
		for (int i = 0; i < len; i++) {
			if (isPalindrome(input.substring(i))) {
				return i + len;
			}
		}
		
		return -1;
	}



}
