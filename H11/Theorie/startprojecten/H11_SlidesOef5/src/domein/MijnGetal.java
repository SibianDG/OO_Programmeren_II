package domein;

import exceptions.NegativeNumberException;

public class MijnGetal {

    private int getal;

    public MijnGetal(int getal) {
        this.getal = getal;
    }

    public int getGetal() {
        return getal;
    }

    public void setGetal(int getal) throws NegativeNumberException {
        if (getal < 0){
            throw new NegativeNumberException();
        }
        this.getal = getal;
    }

    public int geefVierkantswortel(){
        return (int) Math.sqrt(getal);
    }
}
