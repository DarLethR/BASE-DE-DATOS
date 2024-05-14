// ScholarAPIView.java
import java.util.List;
import java.util.Scanner;

public class ScholarAPIView {
    private ScholarAPIController controller;

    public ScholarAPIView() {
    }

    public void setController(ScholarAPIController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la institución:");
        String institution = scanner.nextLine();
        controller.searchAuthorsByInstitution(institution);
    }

    public void displayAuthors(List<Autor> autores) {
        if (!autores.isEmpty()) {
            System.out.println("Los IDs y nombres de los autores son:");
            for (Autor autor : autores) {
                System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre());
            }
        } else {
            System.out.println("si ");
        }
    }
}
