import java.io.BufferedReader;//lee los datos de un recurso web
import java.io.InputStreamReader;//abre y maneja conexiones ,
import java.net.HttpURLConnection;// abre conexiones http y envia dolicitudes en java
import java.net.URL;//construye y representa direcciones web
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ScholarAPIModel {

    public List<String> searchAuthorsByInstitution(String institution) throws Exception {
        List<String> authorIds = new ArrayList<>();//aqui se declaran las variables, que se usaran en la concatenación de más adelante

        // Construir la URL de la API de SERPAPI para buscar perfiles de autores en Google Scholar Profiles, se elijio esta opción porque busvca mas especificamente
        String apiKey = "a9a945ad10658007397c46b8e7f9142301b9574e26aecaadf433f0f2b95cb3ac";//Aqui se agrega la API key personal que tenemos en el Serp API que es lo que hace que se conecte al SERPAPI
        String url = "https://serpapi.com/search?engine=google_scholar_profiles&mauthors=" + institution + "&api_key=" + apiKey;//Se eligio mauthor en lugar del de autores normal, porque se detecto que este, da mejores resultados he incluso soporta mas cantidad de autores, aunque en esta ocasión solo se piden los primeros 10


        // Realizar la petición GET y procesar la respuesta , se uso el metodo fetch , se procesa la respuesta que se extrae de JSONS, recibe la información
        JSONArray profiles = fetchProfiles(url);
        for (int i = 0; i < profiles.length(); i++) {
            JSONObject profile = profiles.getJSONObject(i);
            // Extraer el identificador del autor si este existe
            if (profile.has("author_id")) {
                authorIds.add(profile.getString("author_id"));
            }
        }

        return authorIds;
    }

    private JSONArray fetchProfiles(String url) throws Exception {
        // Realizar la petición GET
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");//permite que se haga mas rápido el procesamiento usar un get

        // Leer la respuesta
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Integrar la respuesta a un JSON y devolver los perfiles
        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse.getJSONArray("profiles");
    }
}
