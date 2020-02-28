package domein;

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
        String[] strings = new String[matrixRepo.getMatrices().size()];
        int index = 0;
        for (Matrix matrix : matrixRepo.getMatrices()){
            strings[index++] = matrix.geefBeschrijving();
        }
        return strings;
    }

    public void voegNieuweMatrixToe(int[][] getallen){
        matrixRepo.voegMatrixToe(new Matrix(getallen));
    }
}
