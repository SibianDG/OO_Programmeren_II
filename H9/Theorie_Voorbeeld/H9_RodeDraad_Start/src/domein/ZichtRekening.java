package domein;

public class ZichtRekening extends Rekening {
	
	private double maxKredietOnderNul;

	public ZichtRekening(long rekeningNr, String houder, double maxKredietOnderNul) {
		super(rekeningNr, houder);
		setMaxKredietOnderNul(maxKredietOnderNul);
	}

	public double getMaxKredietOnderNul() {
		return maxKredietOnderNul;
	}

	public void setMaxKredietOnderNul(double maxKredietOnderNul) {
		if (maxKredietOnderNul > 0) {
			throw new IllegalArgumentException("aa");
		}
		if (maxKredietOnderNul > getSaldo()) {
			throw new IllegalArgumentException("saldo");
		}
		this.maxKredietOnderNul = maxKredietOnderNul;
	}
	
	@Override
	public String toString() {
		return String.format("%s. Maxkrediet is %.2f %%.", super.toString(), maxKredietOnderNul);
	}
	
	@Override
	public boolean haalAf(double bedrag) {
		if (getSaldo() - bedrag >= maxKredietOnderNul) {
			return super.haalAf(bedrag);
		}
		return false;
	}

}
