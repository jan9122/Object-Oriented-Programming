import java.util.GregorianCalendar;

public class Rebuig extends ContenidorBrossa {
    private float reciclat;

    public Rebuig(String codi, String ubicacio, int any, double tara) {
        super(codi, ContenidorBrossa.GRIS, ubicacio, any, tara);
        reciclat = 0;
    }

    public Rebuig(String codi, double tara) {
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
            reciclat += (float) ((dif * 0.75) / 1000);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nReciclat: " + getReciclat();
    }
}