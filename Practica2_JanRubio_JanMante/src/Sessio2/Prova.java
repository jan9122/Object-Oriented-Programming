package Sessio2;

import java.util.Random;

public class Prova {
    public static void main(String[] args) {
        Random rand = new Random();

        // Crear Ubicacions
        Ubicacio u1 = new Ubicacio(5, "Carrer Major");
        Ubicacio u2 = new Ubicacio(5, "Avinguda Catalunya");

        // Crear Codis
        Codi c1 = new Codi(1001, Codi.ADVERTENCIA);
        Codi c2 = new Codi(1002, Codi.REGLAMENTACIO);
        Codi c3 = new Codi(1003, Codi.INDICACIO);

        // Crear Senyals
        Advertencia senyal1 = new Advertencia(c1, u1, 2024, "Stop");
        Reglamentacio senyal2 = new Reglamentacio(c2, u1, 2023, "Prohibit girar");
        Indicacio senyal3 = new Indicacio(c3, u2, 2022, "Zona peatonal");

        // Afegir senyals a les ubicacions
        u1.afegirSenyal(senyal1, 10);
        u1.afegirSenyal(senyal2, 20);
        u2.afegirSenyal(senyal3, 5);

        // Provar toString()
        System.out.println("Ubicacio 1: " + u1.getSenyals());
        System.out.println("Ubicacio 2: " + u2.getSenyals());

        // Provar canviarUbicacio
        System.out.println("Canviant senyal 1 a una nova ubicació...");
        senyal1.canviarUbicacio(u2);
        System.out.println("Ubicacio 1: " + u1.getSenyals());
        System.out.println("Ubicacio 2: " + u2.getSenyals());

        // Provar retirarViaPublica
        System.out.println("Retirant senyal 2 de la via pública...");
        senyal2.retirarViaPublica();
        System.out.println("Ubicacio 1: " + u1.getSenyals());

        // Crear una població
        Poblacio ciutat = new Poblacio(5, "Barcelona");
        ciutat.afegirUbicacio(u1);
        ciutat.afegirUbicacio(u2);

        // Mostrar les ubicacions de la població
        System.out.println("Població:");
        System.out.println(ciutat);

        // Provar eliminarUbicacio sense senyals
        System.out.println("Eliminant ubicacions sense senyals...");
        ciutat.eliminarUbicacio();
        System.out.println(ciutat);
    }
}