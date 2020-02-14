package domein;

public class SpaarRekening extends Rekening {
	
	private static double aangroeiIntrest;


	
	public SpaarRekening(long rekekeningNr, String houder) {
		super(rekekeningNr, houder);
	}



	public static double getAangroeiIntrest() {
		return aangroeiIntrest;
	}



	public static void setAangroeiIntrest(double aangroeiIntrest) {
		if (aangroeiIntrest < 0) {
			throw new IllegalArgumentException("Aangroei interest moet >= 0 zijn!");
		}
		SpaarRekening.aangroeiIntrest = aangroeiIntrest;
	}
	
	@Override
	public boolean haalAf(double bedrag) {
		if (super.getSaldo() >= bedrag) {
			return super.haalAf(bedrag);
		}
		return false;
	}
	
	@Override
	public String toString(){
		return String.format("%s. Aangroeiinterest = %.2f %%.", super.toString(), aangroeiIntrest);
	}

	
}
