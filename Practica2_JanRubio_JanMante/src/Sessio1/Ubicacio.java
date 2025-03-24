package Sessio1;

public class Ubicacio {
    private String nomCarrer;
    private SenyalTransit[] senyals;
    private int[] onEstanSenyals;
    private int numSenyals;
    private int MAX_SENYALS;

    // Constructor
    public Ubicacio(int Maxim, String carrer) {
        this.MAX_SENYALS = Maxim;
        this.nomCarrer = carrer;
        this.senyals = new SenyalTransit[MAX_SENYALS];
        this.onEstanSenyals = new int[MAX_SENYALS];
        this.numSenyals = 0;
    }

    // Getters
    public String getNomCarrer() {
        return nomCarrer;
    }

    public int getNumSenyals() {
        return numSenyals;
    }

    // Método para verificar si dos ubicaciones son iguales
    public boolean equals(Ubicacio ubicacio) {
        return this.nomCarrer.equalsIgnoreCase(ubicacio.nomCarrer);
    }

    // Obtener un senyal en una posición específica
    public SenyalTransit getSenyal(int quin) {
        if (quin >= 0 && quin < numSenyals) {
            return senyals[quin];
        }
        return null;
    }

    // Obtener el número de la calle donde está un senyal
    public int getNumero(SenyalTransit c) {
        for (int i = 0; i < numSenyals; i++) {
            if (senyals[i].getCodi().equals(c.getCodi())) {
                return onEstanSenyals[i];
            }
        }
        return -1;
    }

    // Método para agregar un nuevo senyal
    public boolean afegirSenyal(SenyalTransit c, int numero) {
        if (getNumero(c) != -1) return false; // No se admiten repetidos

        senyals[numSenyals] = c;
        onEstanSenyals[numSenyals] = numero;
        numSenyals++;
        return true;
    }

    // Método para eliminar un senyal
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

    // Método para devolver los identificadores de los senyals
    public String getSenyals() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numSenyals; i++) {
            result.append(senyals[i].getCodi().getIdentificador());
            if (i < numSenyals - 1) {
                result.append(" - ");
            }
        }
        return result.toString();
    }
}

