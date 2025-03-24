import java.util.Random;

public class Prova {
    public static void main(String[] args) {
        System.out.println("--- Prova de gestió d'excepcions ---");
        provaExcepcions();

        System.out.println("\n--- Prova de llistats ordenats i generació aleatòria ---");
        provaOrdenacio();
    }

    private static void provaExcepcions() {
        try {
            ContenidorBrossa contenidor = new Plastic("P001", "Carrer Major", 2020, 10.5);
            contenidor.retirarViaPublica();
            contenidor.retirarViaPublica(); // Això ha de generar una excepció
        } catch (ExceptionContenidorBrossa e) {
            System.out.println("Excepció capturada: " + e.getMessage());
        }

        try {
            Poblacio p = new Poblacio("Ciutat", 5, 2);
            System.out.println(p.getPes(99)); // Sistema de mesura invàlid
        } catch (IllegalArgumentException e) {
            System.out.println("Excepció capturada: " + e.getMessage());
        }
    }

    private static void provaOrdenacio() {
        Random random = new Random();
        Poblacio[] poblacions = new Poblacio[5];

        for (int i = 0; i < poblacions.length; i++) {
            poblacions[i] = new Poblacio("Poblacio" + (i + 1), 3, 2);
            int numContenidors = random.nextInt(5) + 1; // Al menos 1 contenedor

            for (int j = 0; j < numContenidors; j++) {
                double tara = random.nextDouble() * 50 + 10; // Tara aleatoria
                ContenidorBrossa contenidor = new Paper("C" + i + j, "Carrer X", 2020, tara);

                float pesVaciado = random.nextFloat() * 100 + 10; // Peso aleatorio para vaciar
                contenidor.buidat(pesVaciado);
                System.out.println("Buidat contenedor " + contenidor.getCodi() + " amb pes: " + pesVaciado); // Debug

                poblacions[i].afegirContenidor(contenidor);
            }
        }

        System.out.println("Llistat ascendent:");
        Poblacio.llistatOrdenatAscendent(poblacions);

        System.out.println("\nLlistat descendent:");
        Poblacio.llistatOrdenatDescendent(poblacions);
    }



}
