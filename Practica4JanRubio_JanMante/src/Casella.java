import javax.swing.*;
import java.awt.*;

public class Casella extends JButton {
    // Enumeración para los estados de la casilla
    private enum Estat {
        SEMBRAT, NASCUDA, FLORIDA
    }

    // Atributos de la clase
    private final ImageIcon FLORIDA;
    private final ImageIcon NASCUDA;
    private final ImageIcon SEMBRAT;
    private Estat estat;
    private static final int IMAGE_WIDTH = 100; // Tamaño uniforme
    private static final int IMAGE_HEIGHT = 100;

    // Constructor
    public Casella() {
        // Cargar las imágenes desde la carpeta src y redimensionarlas
        FLORIDA = resizeImage(new ImageIcon(getClass().getClassLoader().getResource("florida.jpg")));
        NASCUDA = resizeImage(new ImageIcon(getClass().getClassLoader().getResource("nascuda.jpeg")));
        SEMBRAT = resizeImage(new ImageIcon(getClass().getClassLoader().getResource("sembrat.jpg")));

        // Asignar un estado inicial aleatorio
        assignarEstatAleatori();
    }

    // Método para redimensionar imágenes
    private ImageIcon resizeImage(ImageIcon icon) {
        Image img = icon.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    // Método para asignar un estado aleatorio a la casilla
    private void assignarEstatAleatori() {
        estat = Estat.values()[(int) (Math.random() * 3)];
        actualizarIcono();
    }

    // Método para actualizar la imagen de la casilla según su estado
    private void actualizarIcono() {
        switch (estat) {
            case SEMBRAT -> setIcon(SEMBRAT);
            case NASCUDA -> setIcon(NASCUDA);
            case FLORIDA -> setIcon(FLORIDA);
        }
    }

    // Método para avanzar de estado (con rotación)
    public void avanzarEstat() {
        switch (estat) {
            case SEMBRAT -> estat = Estat.NASCUDA;
            case NASCUDA -> estat = Estat.FLORIDA;
            case FLORIDA -> estat = Estat.SEMBRAT;
        }
        actualizarIcono();
    }

    // Método para verificar si la casilla está en estado FLORIDA
    public boolean estaFlorida() {
        return estat == Estat.FLORIDA;
    }

    // Método para reinicializar el estado de la casilla
    public void reinicialitzar() {
        assignarEstatAleatori();
    }
}