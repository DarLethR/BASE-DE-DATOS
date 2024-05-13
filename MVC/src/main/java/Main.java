
public class Main {
    public static void main(String[] args) {
        // Crear instancias del modelo, vista y controlador
        ScholarAPIModel model = new ScholarAPIModel();
        ScholarAPIView view = new ScholarAPIView();
        ScholarAPIController controller = new ScholarAPIController(model, view);

        // Asignar la vista al controlador después de su inicialización
        view.setController(controller);

        // Mostrar el menú
        view.showMenu();
    }
}

