package ch.rusi.sandbox.generictypes;

public class GenericPairsTest {

	public static void main(String[] args) {
		
		IPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
		System.out.println("Pair 1 : " + p1.getKey() + " -> " + p1.getValue());

		IPair<String, String> p2 = new OrderedPair<>("Hello", "World");
		System.out.println("Pair 2 : " + p2.getKey() + " -> " + p2.getValue());

		IPair<String, Box<Integer>> p3 = new OrderedPair<>("primes", new Box<>(1));
		System.out.println("Pair 3 : " + p3.getKey() + " -> " + p3.getValue().getBoxContent());

	}

}
