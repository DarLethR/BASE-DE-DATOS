// ScholarAPIModel.java
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScholarAPIModel {

    private static final String API_KEY = "b2c23759ba0f1cca86c6f38b558802507c43c17a20157fdc05bc6a5582338780";
    private static final String ENGINE = "google_scholar_profiles";
    private static final String API_URL = "https://serpapi.com/search";

    public List<Autor> searchAuthorsByInstitution(String institution) throws Exception {
        List<Autor> autores = new ArrayList<>();
        String url = API_URL + "?engine=" + ENGINE + "&mauthors=" + institution + "&api_key=" + API_KEY;

        JSONObject jsonResponse = fetchProfiles(url);
        System.out.println(jsonResponse.toString(4)); // Imprime el JSON con formato para facilitar la lectura

        JSONArray profiles = jsonResponse.getJSONArray("profiles");
        for (int i = 0; i < profiles.length(); i++) {
            JSONObject profile = profiles.getJSONObject(i);
            if (profile.has("author_id") && profile.has("author_name")) {
                String authorId = profile.getString("author_id");
                String authorName = profile.getString("author_name");
                autores.add(new Autor(authorId, authorName));
            }
        }

        return autores;
    }

    private JSONObject fetchProfiles(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return new JSONObject(response.toString());
    }
}




