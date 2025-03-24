package Sessio2;

import java.util.GregorianCalendar;

public abstract class SenyalTransit {
    public static final int DIAMETRE_CIRCULAR = 50;
    public static final int COSTAT_TRIANGULAR = 70;
    public static final int AMPLADA_RECTANGULAR = 132;
    public static final int ALCADA_RECTANGULAR = 93;
    
    protected static int comptadorAdvertencia = 0;
    protected static int comptadorReglamentacio = 0;
    protected static int comptadorIndicacio = 0;
    
    private Codi identificador;
    private Ubicacio localitzacio;
    private int anyInstalacio;
    
    public SenyalTransit(Codi codi, Ubicacio ubicacio, int anyColocacio) {
        this.identificador = codi;
        this.localitzacio = ubicacio;
        this.anyInstalacio = anyColocacio;
    }
    
    public SenyalTransit(Codi codi, Ubicacio ubicacio) {
        this(codi, ubicacio, new GregorianCalendar().get(GregorianCalendar.YEAR));
    }

    public SenyalTransit(Codi codi) {
        this(codi, null, 0);
    }
    
    public abstract float area();
    
    public static int getComptadorAdvertencia() { return comptadorAdvertencia; }
    public static int getComptadorReglamentacio() { return comptadorReglamentacio; }
    public static int getComptadorIndicacio() { return comptadorIndicacio; }

    public boolean retirarViaPublica() {
        if (localitzacio == null) return false; // Ja està al magatzem
        if (!localitzacio.treureSenyal(this)) return false;
        localitzacio = null;
        anyInstalacio = 0;
        return true;
    }

    public int retirarViaPublica(SenyalTransit[] senyals) {
        int retirats = 0;
        for (SenyalTransit s : senyals) {
            if (s.retirarViaPublica()) retirats++;
        }
        return retirats;
    }

    public String getUbicacio() {
        return (localitzacio != null) ? localitzacio.getNomCarrer() : null;
    }

    public boolean canviarUbicacio(Ubicacio novaUbicacio) {
        if (novaUbicacio == null || localitzacio == null) return false;
        if (!novaUbicacio.afegirSenyal(this, 1)) return false; // Número ficticio
        localitzacio.treureSenyal(this);
        localitzacio = novaUbicacio;
        return true;
    }

    public Codi getCodi() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Codi: " + identificador.getIdentificador() + ", Any: " + anyInstalacio + 
               ", Ubicació: " + (localitzacio != null ? localitzacio.getNomCarrer() : "Magatzem");
    }
}
