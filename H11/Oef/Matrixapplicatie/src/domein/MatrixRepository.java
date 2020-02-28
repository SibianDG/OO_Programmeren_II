package domein;

import persistentie.MatrixMapper;

import java.util.List;

public class MatrixRepository {

    private MatrixMapper matrixMapper;
    private List<Matrix> matrices;

    public MatrixRepository() {
        this.matrixMapper = new MatrixMapper();
        matrices = matrixMapper.geefMatrices();
    }

    public Matrix geefMatrix(int nummer){
        return matrices.get(nummer);
    }


    public void voegMatrixToe(Matrix matrix){
        //De matrix die je als parameter doorkrijgt, voeg je toe aan de lijst matrices. Als je de applicatie zal afsluiten, zul je deze matrices terug kwijt zijn.
        matrices.add(matrix);
    }

    public List<Matrix> getMatrices() {
        return matrices;
    }
}
