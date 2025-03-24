package Sessio2;

public class Advertencia extends SenyalTransit {
    private String significatSenyal;
    private int diametre;
    
    public Advertencia(Codi codi, Ubicacio ubicacio, int any, String significat) {
        super(codi, ubicacio, any);
        this.significatSenyal = significat;
        this.diametre = DIAMETRE_CIRCULAR;
        comptadorAdvertencia++;
    }

    public Advertencia(Codi codi, Ubicacio ubicacio, int any, String significat, int diametre) {
        this(codi, ubicacio, any, significat);
        this.diametre = diametre;
    }
    
    @Override
    public float area() {
        return (float) (Math.PI * Math.pow(diametre / 2.0, 2));
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Significat: " + significatSenyal + ", Àrea: " + area();
    }
}