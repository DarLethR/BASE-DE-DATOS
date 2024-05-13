import java.util.List;

public class ScholarAPIController {
    private final ScholarAPIModel model;
    private final ScholarAPIView view;//se uso una clase privada final para que la clase sea especifica y no se extienda a las otras, se envapsula y solo las clases que la llamen pueden acceder a esta clase, mas rendimiento

    public ScholarAPIController(ScholarAPIModel model, ScholarAPIView view) {//el controlador como lo dice es un controlador de las otras clases y aqui se mandan llamar la clase de modelo y la de vista
        this.model = model;
        this.view = view;
    }

    public void searchAuthorsByInstitution(String institution) {
        try {
            List<String> authorIds = model.searchAuthorsByInstitution(institution);
            view.displayAuthors(authorIds);
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}

