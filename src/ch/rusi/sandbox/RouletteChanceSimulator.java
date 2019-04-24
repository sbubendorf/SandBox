package ch.rusi.sandbox;
import java.util.Random;


public class RouletteChanceSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		int start = 100;
		while(true) {
			int capital = 5000;
			int run = 0;
			int bet = start;
			while(capital < 10000 && capital > 0) {
				run += 1;
				//System.out.print(run + " - " + String.format("%1$5s : ", String.valueOf(bet)));
				capital -= bet;
				int color = rand.nextInt(2);
				//System.out.print(color == 0 ? "loose " : " win  ");
				if (color == 1) {
					capital += bet * 2;
					bet = start;
				} else {
					bet = bet * 2;
				}
				//System.out.println(String.format("%1$10s", capital));
			}
			System.out.println(run + " : " + capital);
		}
	}
}
