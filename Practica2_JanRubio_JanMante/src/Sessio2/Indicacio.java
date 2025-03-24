package Sessio2;

public class Indicacio extends SenyalTransit {
    private String significatSenyal;
    private int amplada, alcada;
    
    public Indicacio(Codi codi, Ubicacio ubicacio, int any, String significat) {
        super(codi, ubicacio, any);
        this.significatSenyal = significat;
        this.amplada = AMPLADA_RECTANGULAR;
        this.alcada = ALCADA_RECTANGULAR;
        comptadorIndicacio++;
    }
    
    public Indicacio(Codi codi, Ubicacio ubicacio, int any, String significat, int amplada, int alcada) {
        this(codi, ubicacio, any, significat);
        this.alcada = alcada;
        this.amplada = amplada;
    }
    
    @Override
    public float area() {
        return amplada * alcada;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Significat: " + significatSenyal + ", Àrea: " + area();
    }
}
