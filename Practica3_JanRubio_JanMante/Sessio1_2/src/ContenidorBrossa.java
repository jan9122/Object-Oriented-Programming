import java.util.GregorianCalendar;

public abstract class ContenidorBrossa implements Comparable<ContenidorBrossa> {
	public final static int GROC = 1;
	public final static int MARRO = 2;
	public final static int VERD = 3;
	public final static int GRIS = 4;
	public final static int BLAU = 5;

	private String codi;
	private int color;
	private String ubicacio;
	private int any;
	protected double tara;

	private static final GregorianCalendar avui = new GregorianCalendar();
	private static final int anyActual = avui.get(GregorianCalendar.YEAR);

	public ContenidorBrossa(String codi, int color, String ubicacio, int any, double tara) {
		this.codi = codi;
		this.color = color;
		this.ubicacio = ubicacio;
		this.any = any;
		this.tara = tara;
	}

	public ContenidorBrossa(String codi, int color, double tara) {
		this(codi, color, null, anyActual, tara);
	}

	public String getCodi() {
		return codi;
	}

	public String getTipusBrossa() {
		switch (color) {
			case GROC: return "Envasos";
			case MARRO: return "Orgànic";
			case VERD: return "Vidre";
			case BLAU: return "Paper i cartró";
			case GRIS: return "Resta";
			default: return "ERROR";
		}
	}

	public void retirarViaPublica() {
		if (ubicacio != null) {
			any = 0;
			ubicacio = null;
		}
	}

	public void retirarViaPublica(ContenidorBrossa[] a) {
		for (ContenidorBrossa contenidor : a) {
			contenidor.retirarViaPublica();
		}
	}

	public String getUbicacio() {
		return (ubicacio != null) ? ubicacio : "Magatzem";
	}

	public void setUbicacio(String ubicacio) {
		if (ubicacio != null) {
			this.ubicacio = ubicacio;
		} else {
			retirarViaPublica();
		}
	}

	public String getEstat() {
		if (ubicacio == null) return "Retirat";
		int dif = anyActual - any;
		if (dif > 5) return "Vell";
		if (dif > 3) return "Semi Nou";
		return "Nou";
	}

	public abstract void buidat(float pes);

	@Override
	public int compareTo(ContenidorBrossa o) {
		return this.codi.compareTo(o.codi);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ContenidorBrossa)) return false;
		return this.codi.equals(((ContenidorBrossa) o).codi);
	}

	@Override
	public String toString() {
		return "Codi: " + codi + "\nColor: " + getTipusBrossa() + "\nUbicació: " + getUbicacio() + "\nTara: " + tara;
	}
}