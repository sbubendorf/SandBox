package ch.rusi.sandbox.generictypes;

public class GenericPairsTest {

	public static void main(String[] args) {
		
		IPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
		IPair<String, String> p2 = new OrderedPair<>("Hello", "World");
		IPair<String, Box<Integer>> p3 = new OrderedPair<>("primes", new Box<Integer>(1));

	}

}
