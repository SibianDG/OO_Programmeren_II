package domein;

import exceptions.DimensieException;

public class Matrix {

    private int[][] getallen;

    public Matrix() {
        this(2, 2);
    }

    public Matrix(int aantalRijen, int aantalKolommen){
        getallen = new int[aantalRijen][aantalKolommen];
    }

    public Matrix(int[][] getallen) {
        int aantalKol = -1;
        for (int[] rij: getallen) {
            if (aantalKol == -1){
                aantalKol = rij.length;
            } else if (aantalKol != rij.length){
                throw new DimensieException("lke rij van de matrix moet evenveel kolommen hebben.");
            }
            this.getallen = getallen;
        }
    }

    public boolean isVierkant(){
        return getallen.length == getallen[0].length;
    }

    public boolean isEenheidsMatrix(){
        int spilIndex = 0;
        for (int[] rij: getallen){
            if (rij[spilIndex] != 1){
                return false;
            }
            int indexCol = 0;
            for (int kolom : rij){
                if (kolom != 0 && indexCol != spilIndex){
                    return false;
                }
                indexCol++;
            }
            spilIndex++;
        }
        return true;
    }

    public Matrix telOp(Matrix matrix){
        if (getallen.length == matrix.getGetallen().length && getallen[0].length == matrix.getGetallen()[0].length){
            for (int i = 0; i < getallen.length; i++) {
                for (int j = 0; j < getallen[0].length; j++) {
                    getallen[i][j] += matrix.getGetallen()[i][j];
                }
            }
        } else {
            throw new DimensieException("De dimensies van deze twee matrices zijn niet gelijk.");
        }
        return new Matrix(getallen);
    }

    public Matrix vermenigvuldig(Matrix matrix){
        if (getallen[0].length == matrix.getGetallen().length){
            int rijenA = getallen.length;
            int kolsInA = getallen[0].length;
            int kolsInB = matrix.getGetallen()[0].length;
            int[][] nieuweMatrix = new int[rijenA][kolsInB];
            for (int i = 0; i < rijenA; i++) {
                for (int j = 0; j < kolsInB; j++) {
                    for (int k = 0; k < kolsInA; k++) {
                        nieuweMatrix[i][j] = nieuweMatrix[i][j] + getallen[i][k] * matrix.getGetallen()[k][j];
                    }
                }
            }
            return new Matrix(nieuweMatrix);
        } else {
            throw new DimensieException("Het aantal kolommen van de matrix komt niet overeen met het aantal rijen van de tweede matrix. Deze matrices kunnen niet vermenigvuldigd worden.");
        }
    }

    public String geefBeschrijving(){
        return String.format("%s%s, dimensie %d x %d", isVierkant() ? "Vierkante " : "", isEenheidsMatrix() ? "eenheidsmatrix" : "matrix", getallen.length, getallen[0].length);
    }

    public int[] geefDimensies() {
        int[] dimensies = new int[2];
        dimensies[0] = getallen.length;
        dimensies[1] = getallen[0].length;
        return dimensies;
    }

    @Override
    public String toString(){
        String result = "";
        for (int[] rij : getallen){
            for (int kolom : rij){
                result += String.format("%5d", kolom);
            }
            result += String.format("%n");
        }
        return result;
    }

    public int geefElement(int rij, int kolom){
        return getallen[rij][kolom];
    }

    public int[][] getGetallen() {
        return getallen;
    }
}
