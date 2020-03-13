package domein;

import java.util.List;

public class DomeinController {

    private Matrix gekozenMatrix;
    private MatrixRepository matrixRepo;

    public DomeinController() {
        matrixRepo = new MatrixRepository();
    }

    public String geefMatrix(int nummer){
        return matrixRepo.geefMatrix(nummer).toString();
    }

    public void selecteerMatrix(int nummer){
        gekozenMatrix = matrixRepo.geefMatrix(nummer);
    }

    public String geefSom(int nummer){
        return gekozenMatrix.telOp(matrixRepo.geefMatrix(nummer)).toString();
    }

    public String geefProduct(int nummer){
        return gekozenMatrix.vermenigvuldig(matrixRepo.geefMatrix(nummer)).toString();
    }

    public String[] geefBeschrijvingMatrix(){
        List<Matrix> matrixList = matrixRepo.getMatrices();
    	//OK - gebruik een extra variabele matrices zodat matrixRepo.getMatrices() maar één keer moet worden aangeroepen in deze methode
        String[] strings = new String[matrixList.size()];
        int index = 0;
        //OK - de nummering kan toegevoegd worden in de applicatie => hier enkel strings opvullen met matrix.geefBeschrijving()
        for (Matrix matrix : matrixList){
            strings[index++] = matrix.geefBeschrijving();
        }
        return strings;
    }

    public void voegNieuweMatrixToe(int[][] getallen){
        matrixRepo.voegMatrixToe(new Matrix(getallen));
    }

    // OK - zou ik wegdoen of private zetten => eigengemaakt domeinobject mag niet door DC worden doorgegeven naar applicatie
    public boolean isErGekozenMatrix() {
        return gekozenMatrix != null;
    }

}
