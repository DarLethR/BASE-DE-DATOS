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
            saveAuthorsToDatabase(autores);
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    private void saveAuthorsToDatabase(List<Autor> autores) {
        // Aquí se implementaría la lógica para guardar los autores en una base de datos MySQL
        // Utiliza la clase java.sql para conectarte a la base de datos y realizar la inserción
        // Puedes consultar la documentación de java.sql para obtener más información sobre cómo realizar operaciones de base de datos
    }
}










