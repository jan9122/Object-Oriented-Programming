public class Prova {
    public static void main(String[] args) {
        // Crear una població amb capacitat inicial de 5 contenidors i increment de 2
        Poblacio poblacio = new Poblacio("Barcelona", 5, 2);

        // Crear contenidors de prova amb diferents subclasses
        ContenidorBrossa c1 = new Plastic("AA-1001", "Carrer Major", 2022, 50.0f);
        ContenidorBrossa c2 = new Paper("BB-1002", "Avinguda Catalunya", 2021, 45.5f);
        ContenidorBrossa c3 = new Vidre("CC-1003", null, 0, 55.0f);
        ContenidorBrossa c4 = new Organic("DD-1004", "Carrer Nou", 2020, 60.0f);
        ContenidorBrossa c5 = new Rebuig("EE-1005", "Passeig de Gracia", 2019, 48.0f);

        // Afegir contenidors a la població
        poblacio.afegirContenidor(c1);
        poblacio.afegirContenidor(c2);
        poblacio.afegirContenidor(c3);
        poblacio.afegirContenidor(c4);
        poblacio.afegirContenidor(c5);

        // Imprimir l'estat inicial de la població
        System.out.println("Estat inicial de la població:");
        System.out.println(poblacio);

        // Comprovar si un contenidor hi és
        System.out.println("Contenidor BB-1002 hi és? " + poblacio.hiEs("BB-1002"));
        System.out.println("Contenidor ZZ-9999 hi és? " + poblacio.hiEs("ZZ-9999"));

        // Eliminar un contenidor
        poblacio.eliminarContenidor(c2);

        // Imprimir l'estat després de l'eliminació
        System.out.println("Estat després d'eliminar BB-1002:");
        System.out.println(poblacio);

        // Provar el buidatge de contenidors
        c1.buidat(80.0f);
        c2.buidat(60.0f);
        c3.buidat(90.0f);
        c4.buidat(70.0f);
        c5.buidat(50.0f);

        // Imprimir l'estat dels contenidors després del buidatge
        System.out.println("Estat dels contenidors després del buidatge:");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
    }
}