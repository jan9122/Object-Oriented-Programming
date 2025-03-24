import java.util.GregorianCalendar;

public class Organic extends ContenidorBrossa {
    private float reciclat;

    public Organic(String codi, String ubicacio, int any, double tara) {
        super(codi, ContenidorBrossa.MARRO, ubicacio, any, tara);
        reciclat = 0;
    }

    public Organic(String codi, double tara) {
        this(codi, null, new GregorianCalendar().get(GregorianCalendar.YEAR), tara);
    }

    public String getReciclat() {
        return reciclat + " tones";
    }

    public float getReciclatEnTones() {
        return reciclat;
    }

    @Override
    public void buidat(float pes) {
        if (pes >= tara) {
            double dif = pes - tara;
            reciclat += (float) ((dif * 0.9) / 1000);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nReciclat: " + getReciclat();
    }
}