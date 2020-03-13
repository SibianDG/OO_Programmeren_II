package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Matrix;
import exceptions.DimensieException;
import java.util.Arrays;

public class MatrixTest2 {

    private Matrix m1, m2, m3, m4, m5;

    @BeforeEach
    public void before() {
        m1 = new Matrix();
        m2 = new Matrix(3, 2);
        m3 = new Matrix(new int[][] { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } });
        m4 = new Matrix(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } });
        m5 = new Matrix(new int[][] { { 1, 0 }, { 0, 2 }, { -1, -1 } });
    }

    @Test
    public void maakMatrix_zonderParameters_geeft2x2matrix() {
        Assertions.assertTrue(Arrays.deepEquals(new int[2][2], m1.getGetallen()));
    }

    @Test
    public void maakMatrix_metParameters3en2_geeft3x2matrix() {
        int[] dimensies = m2.geefDimensies();
        Assertions.assertTrue(Arrays.deepEquals(new int[dimensies[0]][dimensies[1]], m2.getGetallen()));
    }

    @Test
    public void maakMatrix_metParameter2dimArray_steltMatrixInMetWaardenUitArray() {
        Assertions
                .assertTrue(Arrays.deepEquals(new int[][] { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } }, m3.getGetallen()));
    }

    @Test
    public void isVierkant_3x3Matrix_geeftTrue() {
        Assertions.assertTrue(m3.isVierkant());
    }

    @Test
    public void isVierkant_3x2Matrix_geeftFalse() {
        Assertions.assertFalse(m2.isVierkant());
    }

    @Test
    public void isEenheidsMatrix_3x3Eenheidsmatrix_geeftTrue() {
        Assertions.assertTrue(m4.isEenheidsMatrix());
    }

    @Test
    public void isEenheidsMatrix_3x2Matrix_geeftFalse() {
        Assertions.assertFalse(m2.isEenheidsMatrix());
    }

    @Test
    public void isEenheidsMatrix_2x2NietEenheidsMatrix_geeftFalse() {
        Assertions.assertFalse(m1.isEenheidsMatrix());
    }

    @Test
    public void telOp_3x3MatrixPlusAndere3x3Matrix_geeft3x3Matrix() {
        Assertions.assertTrue(
                Arrays.deepEquals((new int[][] { { 2, 2, 3 }, { 2, 4, 4 }, { 3, 4, 6 } }), m3.telOp(m4).getGetallen()));
    }


    @Test
    public void telOp_3x2MatrixPlus3x3Matrix_geeftDimensieException() {

        Assertions.assertThrows(DimensieException.class, () -> {
            m2.telOp(m3);
        });

    }

    @Test
    public void vermenigvuldig_3x3MatrixMaal3x2Matrix_geeft3x2Matrix() {
        Assertions.assertTrue(Arrays.deepEquals((new int[][] { { -2, 1 }, { -2, 2 }, { -2, 3 } }),
                m3.vermenigvuldig(m5).getGetallen()));
    }

    @Test
    public void vermenigvuldig_3x2MatrixMaal3x3Matrix_geeftDimensieException() {
        Assertions.assertThrows(DimensieException.class, () -> {
            m5.vermenigvuldig(m3);
        });

    }

    @Test
    public void geefBeschrijving_3x3EenheidsMatrix_geeftBijhorendeTekst() {
        Assertions.assertEquals("Vierkante eenheidsmatrix, dimensie 3 x 3", m4.geefBeschrijving());
    }

    @Test
    public void geefBeschrijving_3x3NietEenheidsMatrix_geeftBijhorendeTekst() {
        Assertions.assertEquals("Vierkante matrix, dimensie 3 x 3", m3.geefBeschrijving());
    }

    @Test
    public void geefBeschrijving_3x2Matrix_geeftBijhorendeTekst() {
        Assertions.assertEquals("matrix, dimensie 3 x 2", m5.geefBeschrijving());
    }

    public void toString_3x2Matrix_geeftTekstueleWeergave() {
        Assertions.assertEquals(String.format("1 0 %n0 2 %n-1 -1%n"), m5.toString());
    }

    public void geefElement_3x3Matrixparameters2En3_geeftElementOpRij2Kolom3() {
        Assertions.assertEquals(4, m3.geefElement(2, 3));
    }
}