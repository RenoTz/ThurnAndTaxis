package services.parser;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ParserJSON {
    
    private static final int PRETTY_PRINT_INDENT_FACTOR = 4;
    
    public JSONObject recupererGameElementsEnJSON(final String nomFichier) throws IOException {
        
        final String pathFileParams = this.getClass().getClassLoader().getResource(nomFichier).getPath();
        final String xml = FileUtils.readFileToString(new File(pathFileParams), StandardCharsets.UTF_8);
        final JSONObject xmlToJSON = XML.toJSONObject(xml);
        
        return xmlToJSON.getJSONObject("game_elements");
    }

    public void xmlToJson(final JSONObject xmlJSONObj) throws JSONException, IOException {

        final String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        System.out.println(jsonPrettyPrintString);
    }

}
