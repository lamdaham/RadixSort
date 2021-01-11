public class Radix {

	public static int nth(int n, int col) {
		return (n%(10**(col+1)))/(10**col);
	}

	public static int length(int n) {
		return (""+n).length();
	}

	

}