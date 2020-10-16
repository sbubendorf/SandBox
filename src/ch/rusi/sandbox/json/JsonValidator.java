package ch.rusi.sandbox.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonValidator {

    private static final String filePath = "./files/jsonTestFile.json";

    public static void main(String[] args) {

        try {

            // read the json file
            File file = new File(filePath);
            FileReader reader = new FileReader(file);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // get a String from the JSON object
            String firstName = (String) jsonObject.get("firstname");
            System.out.println("The first name is: " + firstName);

            // get a number from the JSON object
            long id = (long) jsonObject.get("id");
            System.out.println("The id is: " + id);

            // get an array from the JSON object
            JSONArray lang = (JSONArray) jsonObject.get("languages");

            // take the elements of the json array
            for (int i = 0; i < lang.size(); i++) {
                System.out.println("The " + i + " element of the array: " + lang.get(i));
            }

            // take each value from the json array separately
            for (Object o : lang) {
                JSONObject innerObj = (JSONObject) o;
                System.out.println("language " + innerObj.get("lang") +
                        " with level " + innerObj.get("knowledge"));
            }
            // handle a structure into the json object
            JSONObject structure = (JSONObject) jsonObject.get("job");
            System.out.println("Into job structure, name: " + structure.get("name"));

        } catch (IOException fileException) {
            System.out.println("Error while accessing JSON file: " + fileException.getMessage());
        } catch (ParseException parseException) {
            System.out.println("Error while parsing JSON file: " + parseException.toString());
        }
    }
}
