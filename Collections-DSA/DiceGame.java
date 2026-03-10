import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Three-Face Collectors!");
		System.out.print("How many players? ");
		int n;
		try {
			n = sc.nextInt();
			sc.nextLine();
		} catch (Exception e) {
			System.out.println("Invalid number, using 2 players.");
			n = 2;
			sc.nextLine();
		}

		ArrayList<String> players = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter name for player " + i + ": ");
			String name = sc.nextLine().trim();
			if (name.isEmpty()) name = "Player" + i;
			players.add(name);
		}

		ArrayList<ArrayList<Integer>> collected = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) collected.add(new ArrayList<Integer>());

		Random rnd = new Random();
		int[] rollsCount = new int[n];
		boolean gameOver = false;

		while (!gameOver) {
			for (int i = 0; i < n; i++) {
				String p = players.get(i);
				System.out.println();
				System.out.println(p + "'s turn. Press Enter to roll the die...");
				sc.nextLine();
				int roll = rnd.nextInt(6) + 1;
				System.out.println(p + " rolled: " + roll);

				rollsCount[i]++;
				ArrayList<Integer> list = collected.get(i);
				boolean wasNew = true;
				for (int v : list) {
					if (v == roll) { wasNew = false; break; }
				}
				if (wasNew) {
					list.add(roll);
					System.out.println("Nice! You added a new face: " + roll);
				} else {
					System.out.println("You already had " + roll + " — no new face this turn.");
				}

				System.out.println("Collected faces: " + list);
			}

			ArrayList<Integer> winners = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				if (collected.get(i).size() >= 3) winners.add(i);
			}

			if (!winners.isEmpty()) {
				if (winners.size() == 1) {
					int idx = winners.get(0);
					System.out.println();
					System.out.println("*** " + players.get(idx) + " wins! They collected 3 different faces. ***");
				} else {
					int minRolls = Integer.MAX_VALUE;
					for (int idx : winners) if (rollsCount[idx] < minRolls) minRolls = rollsCount[idx];
					ArrayList<Integer> fastest = new ArrayList<Integer>();
					for (int idx : winners) if (rollsCount[idx] == minRolls) fastest.add(idx);
					if (fastest.size() == 1) {
						int idx = fastest.get(0);
						System.out.println();
						System.out.println("*** " + players.get(idx) + " wins by reaching 3 faces in fewer rolls! ***");
					} else {
						System.out.println();
						System.out.print("It's a tie between: ");
						for (int k = 0; k < fastest.size(); k++) {
							if (k > 0) System.out.print(", ");
							System.out.print(players.get(fastest.get(k)));
						}
						System.out.println(". They reached 3 faces in the same number of rolls.");
					}
				}
				gameOver = true;
			}
		}

		System.out.println();
		System.out.println("Final collections:");
		for (int i = 0; i < n; i++) {
			System.out.println(players.get(i) + " -> " + collected.get(i));
		}

		sc.close();
	}

}
