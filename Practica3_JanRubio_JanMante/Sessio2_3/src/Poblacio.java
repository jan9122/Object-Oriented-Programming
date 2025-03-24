import java.util.Arrays;
import java.util.Comparator;

public class Poblacio implements Comparable<Poblacio>, Pesable {
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

    @Override
    public double getPes(int sistema) {
        if (sistema != Pesable.SISTEMA_METRIC && sistema != Pesable.SISTEMA_ANGLOSAXO) {
            throw new IllegalArgumentException("Sistema de mesura no vàlid");
        }
        double pesTotal = 0;
        for (int i = 0; i < numContenidors; i++) {
            ContenidorBrossa contenidor = contenidors[i];
            if (contenidor instanceof Organic) {
                pesTotal += ((Organic) contenidor).getReciclatEnTones() * 1000; // Convertir a kg
            } else if (contenidor instanceof Rebuig) {
                pesTotal += ((Rebuig) contenidor).getReciclatEnTones() * 1000; // Convertir a kg
            } else if (contenidor instanceof Paper) {
                pesTotal += ((Paper) contenidor).getReciclatEnQuilograms();
            } else if (contenidor instanceof Plastic) {
                pesTotal += ((Plastic) contenidor).getReciclatEnQuilograms();
            } else if (contenidor instanceof Vidre) {
                pesTotal += ((Vidre) contenidor).getReciclatEnEnvasos() * 0.2; // 200g per ampolla
            }
        }

        // Conversió a lliures si cal
        if (sistema == Pesable.SISTEMA_ANGLOSAXO) {
            return pesTotal / Pesable.LLIURA;
        } else {
            return pesTotal;
        }
    }


    @Override
    public int compareTo(Poblacio o) {
        double pesA = this.getPes(Pesable.SISTEMA_METRIC);
        double pesB = o.getPes(Pesable.SISTEMA_METRIC);

        return Double.compare(pesA, pesB);
    }


    public static void llistatOrdenatAscendent(Poblacio[] poblacions) {
        Bombolla(poblacions);
        for (int i = 0; i < poblacions.length; i++) {
            System.out.println("Nom: " + poblacions[i].getNom() + ", Contenidors al carrer: " + poblacions[i].getNumContenidorsCarrer());
        }
    }

    public static void llistatOrdenatDescendent(Poblacio[] poblacions) {
        Arrays.sort(poblacions, Comparator.reverseOrder());
        for (int i = 0; i < poblacions.length; i++) {
            System.out.println("Nom: " + poblacions[i].getNom() + ", Contenidors al carrer: " + poblacions[i].getNumContenidorsCarrer());
        }
    }

    private static void Bombolla(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Comparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
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

    public String hiEs(String codi) {
        int index = cercaContenidor(codi);
        if (index >= 0) {
            return contenidors[index].getTipusBrossa();
        } else {
            return "No hi és";
        }
    }

    public void eliminarContenidor(ContenidorBrossa c) {
        int index = cercaContenidor(c.getCodi());
        if (index >= 0) {
            for (int i = index; i < numContenidors - 1; i++) {
                contenidors[i] = contenidors[i + 1];
            }
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
}
