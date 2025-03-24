package Sessio2;

public class Poblacio {
    private String nom;
    private Ubicacio[][] magatzem;
    private int[] comptadors;

    // Constructor
    public Poblacio(int Maxim, String nomPoblacio) {
        this.nom = nomPoblacio;
        this.magatzem = new Ubicacio[26][Maxim];
        this.comptadors = new int[26];
    }

    public String getNom() {
        return nom;
    }

    public int getQuants(char inici) {
        int index = Character.toLowerCase(inici) - 'a';
        return (index >= 0 && index < 26) ? comptadors[index] : 0;
    }

    public int getQuants() {
        int total = 0;
        for (int i = 0; i < 26; i++) {
            total += comptadors[i];
        }
        return total;
    }

    public boolean afegirUbicacio(Ubicacio c) {
        int index = Character.toLowerCase(c.getNomCarrer().charAt(0)) - 'a';
        if (index < 0 || index >= 26 || comptadors[index] >= magatzem[index].length) {
            return false;
        }
        for (int i = 0; i < comptadors[index]; i++) {
            if (magatzem[index][i].equals(c)) {
                return false; // Ubicació ja existeix
            }
        }
        magatzem[index][comptadors[index]++] = c;
        return true;
    }

    public boolean eliminarUbicacio(Ubicacio c) {
        int index = Character.toLowerCase(c.getNomCarrer().charAt(0)) - 'a';
        for (int i = 0; i < comptadors[index]; i++) {
            if (magatzem[index][i].equals(c)) {
                magatzem[index][i] = magatzem[index][comptadors[index] - 1];
                comptadors[index]--;
                return true;
            }
        }
        return false;
    }

    public int eliminarUbicacio() {
        int eliminats = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < comptadors[i]; j++) {
                if (magatzem[i][j].getNumSenyals() == 0) {
                    eliminarUbicacio(magatzem[i][j]);
                    eliminats++;
                }
            }
        }
        return eliminats;
    }

    @Override
    public String toString() {
        String resultat = "";
        for (int i = 0; i < 26; i++) {
            if (comptadors[i] > 0) {
                for (int j = 0; j < comptadors[i]; j++) {
                    resultat += magatzem[i][j].getNomCarrer() + "\n";
                }
            }
        }
        return resultat;
    }
}
