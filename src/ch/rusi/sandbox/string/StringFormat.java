package ch.rusi.sandbox.string;

import java.util.HashMap;
import java.util.Map;

public class StringFormat {

    public static void main(String[] args) {

        Map<String, Double> productPrice = new HashMap<>();
        productPrice.put("Rice"	, 6.9);
        productPrice.put("Flour", 3.9);
        productPrice.put("Sugar", 4.9);
        productPrice.put("Milk"	, 3.9);
        productPrice.put("Egg"	, 1.9);

        for(String key : productPrice.keySet()) {
            System.out.println(String.format("%-30s : %f", key, productPrice.get(key)));
        }

        Map<String, String> address = new HashMap<>();
        address.put("Name", "Bubendorf");
        address.put("First name", "Simon");
        address.put("Street", "Drosselstrasse");
        address.put("Housenumber", "29");
        address.put("ZIP", "4106");
        address.put("City", "Therwil");
        address.put("Country", "Switzerland");

        for(String key : address.keySet()) {
            System.out.println(String.format("%-30s : %s", key, address.get(key)));
        }




    }
}
