import java.util.Arrays;

public class Poblacio {
    private String nom;
    private ContenidorBrossa[] contenidors;
    private int numContenidors;
    private int numContenidorsCarrer;
    private final int increment;

    public Poblacio(String nom, int capacitatInicial, int increment) {
        this.nom = nom;
        this.contenidors = new ContenidorBrossa[capacitatInicial];
        this.numContenidors = 0;
        this.numContenidorsCarrer = 0;
        this.increment = increment;
    }

    public String getNom() {
        return nom;
    }

    public int getNumContenidors() {
        return numContenidors;
    }

    public int getNumContenidorsCarrer() {
        return numContenidorsCarrer;
    }

    public ContenidorBrossa getContenidor(int index) {
        if (index >= 0 && index < numContenidors) {
            return contenidors[index];
        }
        return null;
    }

    public void afegirContenidor(ContenidorBrossa p) {
        if (cercaContenidor(p.getCodi()) >= 0) {
            return;
        }
        if (numContenidors == contenidors.length) {
            contenidors = Arrays.copyOf(contenidors, contenidors.length + increment);
        }
        int i = numContenidors - 1;
        while (i >= 0 && contenidors[i].compareTo(p) > 0) {
            contenidors[i + 1] = contenidors[i];
            i--;
        }
        contenidors[i + 1] = p;
        numContenidors++;
        if (p.getUbicacio() != null) {
            numContenidorsCarrer++;
        }
    }

    public void afegirContenidor(ContenidorBrossa[] p) {
        for (ContenidorBrossa contenidor : p) {
            afegirContenidor(contenidor);
        }
    }

    public String hiEs(String codi) {
        int index = cercaContenidor(codi);
        return index >= 0 ? contenidors[index].getTipusBrossa() : "No hi és";
    }

    public void eliminarContenidor(ContenidorBrossa c) {
        int index = cercaContenidor(c.getCodi());
        if (index >= 0) {
            System.arraycopy(contenidors, index + 1, contenidors, index, numContenidors - index - 1);
            contenidors[--numContenidors] = null;
            if (c.getUbicacio() != null) {
                numContenidorsCarrer--;
            }
        }
    }

    private int cercaContenidor(String codi) {
        int esquerra = 0, dreta = numContenidors - 1;
        while (esquerra <= dreta) {
            int mig = (esquerra + dreta) / 2;
            int comparacio = contenidors[mig].getCodi().compareTo(codi);
            if (comparacio == 0) {
                return mig;
            } else if (comparacio < 0) {
                esquerra = mig + 1;
            } else {
                dreta = mig - 1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Poblacio: " + nom + "\n");
        for (int i = numContenidors - 1; i >= 0; i--) {
            sb.append(contenidors[i].toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Poblacio)) return false;
        Poblacio other = (Poblacio) obj;
        return this.numContenidors == other.numContenidors &&
                this.numContenidorsCarrer == other.numContenidorsCarrer;
    }
}