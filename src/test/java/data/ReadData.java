package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public String firstName, lastName, email, telephone, password;
    public String emailLogin, passwordLogin;

    public void testData() throws IOException, ParseException {

        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/testData.json";
        File file = new File(srcFile);

        JSONParser jsonParser = new JSONParser();
        JSONObject rootObject = (JSONObject) jsonParser.parse(new FileReader(file));

        // Extract registerData
        JSONObject registerData = (JSONObject) rootObject.get("registerData");
        firstName = (String) registerData.get("firstName");
        lastName = (String) registerData.get("lastName");
        email = (String) registerData.get("email");
        telephone = (String) registerData.get("telephone");
        password = (String) registerData.get("password");

//         Extract login data
        JSONObject loginData = (JSONObject) rootObject.get("loginData");
        emailLogin= (String) loginData.get("email");
        passwordLogin = (String) loginData.get("password");
    }

}
