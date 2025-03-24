import java.util.GregorianCalendar;

public class Plastic extends ContenidorBrossa {
	private float reciclat;

	public Plastic(String codi, String ubicacio, int any, double tara) {
		super(codi, ContenidorBrossa.GROC, ubicacio, any, tara);
		reciclat = 0;
	}

	public Plastic(String codi, double tara) {
		this(codi, null, new GregorianCalendar().get(GregorianCalendar.YEAR), tara);
	}

	public String getReciclat() {
		return reciclat + " quilograms";
	}

	@Override
	public void buidat(float pes) {
		if (pes >= tara) {
			double dif = pes - tara;
			reciclat += (float) (dif * 0.8);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nReciclat: " + getReciclat();
	}
}