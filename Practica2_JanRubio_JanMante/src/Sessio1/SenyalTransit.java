package Sessio1;

public class SenyalTransit {
    private Codi identificador;
    private Ubicacio localitzacio;
    private int anyInstalacio;

    public SenyalTransit(Codi identificador, Ubicacio localitzacio, int anyColocacio) {
        this.identificador = identificador;
        if (localitzacio.afegirSenyal(this, (int) (Math.random() * 100))) {
            this.localitzacio = localitzacio;
            this.anyInstalacio = anyColocacio;
        } else {
            this.localitzacio = null;
            this.anyInstalacio = 0;
        }
    }

    public String donaTipusSenyal() {
        if (identificador.getTipus() == Codi.ADVERTENCIA) return "Advertència";
        if (identificador.getTipus() == Codi.REGLAMENTACIO) return "Reglamentació";
        return "Indicació";
    }

    public boolean retirarViaPublica() {
        if (localitzacio == null) return false;
        if (localitzacio.treureSenyal(this)) {
            localitzacio = null;
            anyInstalacio = 0;
            return true;
        }
        return false;
    }

    public String getUbicacio() {
        if (localitzacio == null) {
            return null;
        }
        return localitzacio.getNomCarrer();
    }

    public boolean canviarUbicacio(Ubicacio novaLocalitzacio) {
        if (novaLocalitzacio.afegirSenyal(this, (int) (Math.random() * 100))) {
            if (localitzacio != null) localitzacio.treureSenyal(this);
            localitzacio = novaLocalitzacio;
            return true;
        }
        return false;
    }

    public Codi getCodi() {
        return identificador;
    }
}
