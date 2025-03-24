package Sessio2;

public class Ubicacio {
    private String nomCarrer;
    private SenyalTransit[] senyals;
    private int[] onEstanSenyals;
    private int numSenyals;
    private int MAX_SENYALS;

    // Constructor
    public Ubicacio(int Maxim, String carrer) {
        this.nomCarrer = carrer;
        this.MAX_SENYALS = Maxim;
        this.senyals = new SenyalTransit[MAX_SENYALS];
        this.onEstanSenyals = new int[MAX_SENYALS];
        this.numSenyals = 0;
    }

    public String getNomCarrer() {
        return nomCarrer;
    }

    public int getNumSenyals() {
        return numSenyals;
    }

    public boolean equals(Ubicacio ubicacio) {
        return this.nomCarrer.equalsIgnoreCase(ubicacio.nomCarrer);
    }

    public SenyalTransit getSenyal(int quin) {
        if (quin < 0 || quin >= numSenyals) return null;
        return senyals[quin];
    }

    public int getNumero(SenyalTransit c) {
        for (int i = 0; i < numSenyals; i++) {
            if (senyals[i].getCodi().equals(c.getCodi())) {
                return onEstanSenyals[i];
            }
        }
        return -1;
    }

    public boolean afegirSenyal(SenyalTransit c, int numero) {
        for (int i = 0; i < numSenyals; i++) {
            if (senyals[i].getCodi().equals(c.getCodi())) return false;
        }
        if (numSenyals == MAX_SENYALS) {
            MAX_SENYALS += 10;
            SenyalTransit[] newSenyals = new SenyalTransit[MAX_SENYALS];
            int[] newOnEstanSenyals = new int[MAX_SENYALS];
            for (int i = 0; i < numSenyals; i++) {
                newSenyals[i] = senyals[i];
                newOnEstanSenyals[i] = onEstanSenyals[i];
            }
            senyals = newSenyals;
            onEstanSenyals = newOnEstanSenyals;
        }
        senyals[numSenyals] = c;
        onEstanSenyals[numSenyals] = numero;
        numSenyals++;
        return true;
    }

    public boolean treureSenyal(SenyalTransit c) {
        for (int i = 0; i < numSenyals; i++) {
            if (senyals[i].getCodi().equals(c.getCodi())) {
                senyals[i] = senyals[numSenyals - 1];
                onEstanSenyals[i] = onEstanSenyals[numSenyals - 1];
                numSenyals--;
                return true;
            }
        }
        return false;
    }

    public String getSenyals() {
        String result = "";
        for (int i = 0; i < numSenyals; i++) {
            if (i > 0) result += " - ";
            result += senyals[i].getCodi().getIdentificador();
        }
        return result;
    }
}
