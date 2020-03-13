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
        int kolommen = getallen[0].length;
        for (int[] rij:getallen)
            if (rij.length != kolommen)
                throw new DimensieException("Elke rij van de matrix moet evenveel kolommen hebben.");
        this.getallen = getallen;
    }


    public boolean isVierkant(){
        return getallen.length == getallen[0].length;
    }

    public boolean isEenheidsMatrix(){
        //OK-controleer eerst of de matrix een vierkantsmatrix is, via isVierKant()
        if (isVierkant()){
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
        } else {
            return false;
        }
    }

    public Matrix telOp(Matrix matrix){
        int[] dimensies = geefDimensies();
    	//OK-Via geefDimensies() kan je de dimensies van beide matrices opvragen
        if (dimensies[0] == matrix.getGetallen().length && dimensies[1] == matrix.getGetallen()[0].length){
            for (int i = 0; i < getallen.length; i++) {
                for (int j = 0; j < getallen[0].length; j++) {
                	//Gebruik matrix.geefElement(i,j)
                    getallen[i][j] += geefElement(i, j);
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
        //OK - ook geefDimensies
        int[] dimensies = geefDimensies();
        return String.format("%s%s, dimensie %d x %d", 
        		isVierkant() ? "Vierkante " : "", 
        				isEenheidsMatrix() ? "eenheidsmatrix" : "matrix", dimensies[0], dimensies[1]);
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
