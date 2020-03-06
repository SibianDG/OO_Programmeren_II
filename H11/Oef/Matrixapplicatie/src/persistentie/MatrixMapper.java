package persistentie;

import domein.*;
import java.util.ArrayList;
import java.util.List;

public class MatrixMapper {

    public List geefMatrices() {

        List matrices = new ArrayList<>();

        int[][] getallen = {{1, 2, 3}, {4, 5, 6}, {1, 2, 3}};
        Matrix m = new Matrix(getallen);
        matrices.add(m);

        m = new Matrix(2, 3);
        matrices.add(m);

        int[][] getallen2 = {{1, 2}, {4, 5}, {6, 3}};
        m = new Matrix(getallen2);
        matrices.add(m);

        int[][] getallen3 = {{1, 2, 3}, {3, 4, 5}};
        m = new Matrix(getallen3);
        matrices.add(m);

        int[][] getallen4 = {{2, 1, 5}, {3, 4, 1}, {1, 5, 2}};
        m = new Matrix(getallen4);
        matrices.add(m);

        int[][] getallen5 = {{1,0,0}, {0,1,0}, {0,0,1}};
        m = new Matrix(getallen5);
        matrices.add(m);
        return matrices;

    }

}
