public interface Pesable {

    /* DEFINICIÓ DE CONSTANTS ESTÀTIQUES */
    public static final int SISTEMA_METRIC = 10;
    // Sistema mètric: Kg pel pes i metres per l'altura
    public static final int SISTEMA_ANGLOSAXO= 12;
    // Sistema anglosaxó: Lliures pel pes i polzades per l'altura
    public static final double LLIURA = 0.45359237;
    // Kg en una lliura
    /* DEFINICIÓ DE MÈTODES */
    public double getPes (int sistema) throws IllegalArgumentException;
    // proporciona el pes de l'objecte expressat en el sistema indicat
    // si no correspon a cap dels dos llança una excepció


}
