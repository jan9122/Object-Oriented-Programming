import java.util.GregorianCalendar;

public class Paper extends ContenidorBrossa {
    private float reciclat;

    public Paper(String codi, String ubicacio, int any, double tara) {
        super(codi, ContenidorBrossa.BLAU, ubicacio, any, tara);
        reciclat = 0;
    }

    public Paper(String codi, double tara) {
        this(codi, null, new GregorianCalendar().get(GregorianCalendar.YEAR), tara);
    }

    public String getReciclat() {
        return reciclat + " quilograms";
    }

    public float getReciclatEnQuilograms() {
        return reciclat;
    }

    @Override
    public void buidat(float pes) {
        if (pes >= tara) {
            double dif = pes - tara;
            reciclat += (float) (dif * 0.95);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nReciclat: " + getReciclat();
    }
}