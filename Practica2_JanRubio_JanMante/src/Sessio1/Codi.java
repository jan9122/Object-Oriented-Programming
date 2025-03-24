package Sessio1;

public class Codi {
    public static final int ADVERTENCIA = 1;
    public static final int REGLAMENTACIO = 2;
    public static final int INDICACIO = 3;

    private int identificador;
    private int tipus;

    // Constructor
    public Codi(int identificador, int tipus) {
        this.identificador = identificador;
        if (tipus == ADVERTENCIA || tipus == REGLAMENTACIO || tipus == INDICACIO) {
            this.tipus = tipus;
        } else {
            this.tipus = INDICACIO; // Valor por defecto
        }
    }

    // Getters
    public int getIdentificador() {
        return identificador;
    }

    public int getTipus() {
        return tipus;
    }

    // Setters
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setTipus(int tipus) {
        if (tipus == ADVERTENCIA || tipus == REGLAMENTACIO || tipus == INDICACIO) {
            this.tipus = tipus;
        }
    }

    // Método para obtener el tipo de senyal en formato String
    public String getTipusString() {
        switch (tipus) {
            case ADVERTENCIA:
                return "Advertència";
            case REGLAMENTACIO:
                return "Reglamentació";
            default:
                return "Indicació";
        }
    }

    // Método para comparar dos objetos Codi
    public boolean equals(Codi c) {
        return this.identificador == c.identificador && this.tipus == c.tipus;
    }
}

