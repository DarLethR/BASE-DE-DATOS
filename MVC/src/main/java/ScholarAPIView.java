import java.util.Scanner;
import java.util.List;

public class ScholarAPIView {
    private ScholarAPIController controller;

    public ScholarAPIView() {
    }//se declara la clase

    public void setController(ScholarAPIController controller) {
        this.controller = controller;   //se manda llamar la clase api controler
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la institución:");//aqui se manda llamar la institución para poder buscar el autor
        String institution = scanner.nextLine();
        controller.searchAuthorsByInstitution(institution);
    }

    public void displayAuthors(List<String> authorIds) {
        if (!authorIds.isEmpty()) {//aqui se checan si existen los autores o no
            System.out.println("Los IDs de los autores son:");
            for (String authorId : authorIds) {
                System.out.println(authorId);
            }
        } else {
            System.out.println("No se encontraron autores asociados a la institución especificada.");
        }
    }
}


