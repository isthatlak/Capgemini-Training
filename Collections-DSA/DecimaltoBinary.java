public class DecimaltoBinary {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java DecimaltoBinary <integer>");
			return;
		}
		int n = Integer.parseInt(args[0]);
		if (n == 0) {
			System.out.println("0");
			return;
		}
		boolean negative = n < 0;
		long val = n;
		if (negative) val = -val;
		int[] stack = new int[64];
		int sp = 0;
		while (val > 0) {
			stack[sp++] = (int)(val % 2);
			val /= 2;
		}
		if (negative) System.out.print("-");
		for (int i = sp - 1; i >= 0; i--) System.out.print(stack[i]);
		System.out.println();
	}
}
