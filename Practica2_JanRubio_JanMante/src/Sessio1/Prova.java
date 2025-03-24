package Sessio1;

public class Prova {
    public static void main(String[] args) {
        // Crear códigos de señales
        Codi codi1 = new Codi(1234, Codi.ADVERTENCIA);
        Codi codi2 = new Codi(5678, Codi.REGLAMENTACIO);
        Codi codi3 = new Codi(9101, Codi.INDICACIO);

        // Crear ubicaciones
        Ubicacio ubicacio1 = new Ubicacio(5, "Carrer Major");
        Ubicacio ubicacio2 = new Ubicacio(3, "Avinguda Catalunya");

        // Crear señales de tráfico
        SenyalTransit senyal1 = new SenyalTransit(codi1, ubicacio1, 2022);
        SenyalTransit senyal2 = new SenyalTransit(codi2, ubicacio1, 2023);
        SenyalTransit senyal3 = new SenyalTransit(codi3, ubicacio2, 2021);

        // Mostrar información de las señales
        System.out.println("Informació de les senyals:");
        System.out.println("Senyal 1: " + senyal1.donaTipusSenyal() + ", Ubicació: " + senyal1.getUbicacio());
        System.out.println("Senyal 2: " + senyal2.donaTipusSenyal() + ", Ubicació: " + senyal2.getUbicacio());
        System.out.println("Senyal 3: " + senyal3.donaTipusSenyal() + ", Ubicació: " + senyal3.getUbicacio());

        // Probar cambio de ubicación
        System.out.println("Canviant ubicació de Senyal 1 a Avinguda Catalunya...");
        if (senyal1.canviarUbicacio(ubicacio2)) {
            System.out.println("Ubicació canviada correctament.");
        } else {
            System.out.println("No s'ha pogut canviar la ubicació.");
        }
        System.out.println("Nova ubicació de Senyal 1: " + senyal1.getUbicacio());

        // Probar eliminación de una señal
        System.out.println("Retirant la Senyal 2 de la via pública...");
        if (senyal2.retirarViaPublica()) {
            System.out.println("Senyal retirada correctament.");
        } else {
            System.out.println("No s'ha pogut retirar la senyal.");
        }
        System.out.println("Ubicació de Senyal 2 després de retirar: " + senyal2.getUbicacio());
    }
}

