// ScholarAPIController.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ScholarAPIController {
    private final ScholarAPIModel model;
    private final ScholarAPIView view;

    public ScholarAPIController(ScholarAPIModel model, ScholarAPIView view) {
        this.model = model;
        this.view = view;
    }

    public void searchAuthorsByInstitution(String institution) {
        try {
            List<Autor> autores = model.searchAuthorsByInstitution(institution);
            view.displayAuthors(autores);
            saveAuthorsToSQLFile(autores);
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    private void saveAuthorsToSQLFile(List<Autor> autores) {
        try (FileWriter writer = new FileWriter("autores.sql")) {
            for (Autor autor : autores) {
                writer.write("INSERT INTO autores (id, nombre) VALUES ('" + autor.getId() + "', '" + autor.getNombre() + "');\n");
            }
            System.out.println("Los datos se han guardado correctamente en el archivo autores.sql.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo SQL: " + e.getMessage());
        }
    }
}












