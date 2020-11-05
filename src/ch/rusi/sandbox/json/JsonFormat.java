package ch.rusi.sandbox.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;

public class JsonFormat {

    private static final String filePath = "./files/jsonRaw.txt";

    public static void main(String[] args) {

        try {

            // read the json file
            File file = new File(filePath);
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String jsonString = br.readLine();

            // Validation of JSON with org.json.simple for better error messages
            JSONParser parserValidate = new JSONParser();
            JSONObject jsonValidate = (JSONObject) parserValidate.parse(jsonString);

            // Format JSON string with com.google.gson for nice and pretty formatting
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(jsonString).getAsJsonObject();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String prettyJson = gson.toJson(json);

            System.out.println(prettyJson);

        } catch (IOException e) {

            System.out.println("Fehler im File-Zugriff : " + e.toString());

        } catch (ParseException execptionParsing) {

            System.out.println("Fehler im JSON-Format : " + execptionParsing.toString());

        }


    }
}
