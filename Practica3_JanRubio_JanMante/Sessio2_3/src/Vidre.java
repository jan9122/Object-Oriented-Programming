import java.util.GregorianCalendar;

public class Vidre extends ContenidorBrossa {
    private long reciclat;

    public Vidre(String codi, String ubicacio, int any, double tara) {
        super(codi, ContenidorBrossa.VERD, ubicacio, any, tara);
        reciclat = 0;
    }

    public Vidre(String codi, double tara) {
        this(codi, null, new GregorianCalendar().get(GregorianCalendar.YEAR), tara);
    }

    public String getReciclat() {
        return reciclat + " envasos equivalents";
    }

    public long getReciclatEnEnvasos() {
        return reciclat;
    }

    @Override
    public void buidat(float pes) {
        if (pes >= tara) {
            long dif = (long) (pes - tara);
            reciclat += dif * 3;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nReciclat: " + getReciclat();
    }
}