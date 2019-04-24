package ch.rusi.sandbox.hashmap;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class HashMapFibonacci {
    
    private Map<Integer, BigInteger> memorizeHashMap = new HashMap<>();
    {
        memorizeHashMap.put(0, BigInteger.ZERO);
        memorizeHashMap.put(1, BigInteger.ONE);
        memorizeHashMap.put(2, BigInteger.ONE);
    }

    public static void main(String[] args) {
        HashMapFibonacci fibonacci = new HashMapFibonacci();
        for (int i = 0; i < 200; i++) {
            System.out.printf("%3d : %50d%n", i, fibonacci.calculate(i));
        }
    }

    private BigInteger calculate(int n) {
    	return memorizeHashMap.computeIfAbsent(n, (key) -> calculate(n - 1).add(calculate(n - 2)));
    	/*
        if (memorizeHashMap.containsKey(n)) {
            return memorizeHashMap.get(n);
        } else {
            BigInteger result = calculate(n - 1).add(calculate(n - 2));
            memorizeHashMap.put(n, result);
            return result;
        }
        */
    }
}