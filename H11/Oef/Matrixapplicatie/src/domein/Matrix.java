package domein;

public class Matrix {

    private int[][] getallen;

    public Matrix() {
        this(2, 2);
    }

    public Matrix(int aantalRijen, int aantalKolommen){
        getallen = new int[aantalRijen][aantalKolommen];
    }

    public Matrix(int[][] getallen) {
        for (int[] rij: getallen) {
            for (int kolom : rij){
                if ( /* kolom == null || */ kolom < 0){
                    //todo DimensieException
                    throw new IllegalArgumentException("Elke rij van de matrix moet evenveel kolommen hebben.");
                }
            }
        }
    }

    public boolean isVierkant(){
        return getallen.length == getallen[0].length;
    }

    public boolean isEenheidsMatrix(){
        int spilIndex = 0;
        for (int[] rij: getallen){
            if (rij[spilIndex++] != 1){
                return false;
            }
            for (int kolom : rij){
                if (kolom != 0 ){
                    return false;
                }
            }
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
            throw new IllegalArgumentException("De dimensies van deze twee matrices zijn niet gelijk.");
        }
        return new Matrix(getallen);
    }

    public Matrix vermenigvuldig(Matrix matrix){
        int[][] nieuweMatrix = new int[getallen.length][matrix.getGetallen()[0].length];
        int rij = 0, kol = 0;
        if (getallen[0].length == matrix.getGetallen().length){
            for (int i = 0; i < getallen.length; i++) {
                int som = 0;
                for (int j = 0; j < getallen[0].length; j++) {
                    som += getallen[i][j]*matrix.getGetallen()[j][i];
                }
                nieuweMatrix[rij][kol] = som;
                if (rij+1 == nieuweMatrix.length){
                    rij = 0;
                    kol++;
                }
            }
            return new Matrix(nieuweMatrix);
        } else {
            throw new IllegalArgumentException("Het aantal kolommen van de matrix komt niet overeen met het aantal rijen van de tweede matrix. Deze matrices kunnen niet vermenigvuldigd worden.");
        }
    }

    public String geefBeschrijving(){
        return String.format("%s %s, dimensie %d x %d%n", isVierkant() ? "Vierkante" : "", isEenheidsMatrix() ? "eenheidsmatrix" : "matrix", getallen.length, getallen[0].length);
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
