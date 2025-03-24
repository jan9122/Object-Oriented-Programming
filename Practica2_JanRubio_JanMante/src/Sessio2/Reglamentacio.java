package Sessio2;

public class Reglamentacio extends SenyalTransit {
    private String significatSenyal;
    private int costat;
    
    public Reglamentacio(Codi codi, Ubicacio ubicacio, int any, String significat) {
        super(codi, ubicacio, any);
        this.significatSenyal = significat;
        this.costat = COSTAT_TRIANGULAR;
        comptadorReglamentacio++;
    }
    
    public Reglamentacio(Codi codi, Ubicacio ubicacio, int any, String significat, int costat) {
    	this(codi, ubicacio, any, significat);
    	this.costat = costat;
    }
    
    @Override
    public float area() {
        return (float) (Math.sqrt(3) / 4 * Math.pow(costat, 2));
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Significat: " + significatSenyal + ", Àrea: " + area();
    }
}
