import domein.DomeinController;
import domein.Matrix;
import ui.MatrixApplicatie;

public class StartUp {
    public static void main(String[] args) {

        MatrixApplicatie matrixApplicatie = new MatrixApplicatie(new DomeinController());
        matrixApplicatie.startApplicatie();

    }
}
