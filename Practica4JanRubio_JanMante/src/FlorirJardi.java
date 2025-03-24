import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlorirJardi extends JFrame implements ActionListener {
    private Casella[][] terreny;
    private final int files = 3;
    private final int columnes = 3;
    private JButton btnReiniciar, btnSortir;

    public FlorirJardi() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Tulipes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600); // Ajustar tamaño estándar
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());

        JPanel panelJoc = new JPanel(new GridLayout(files, columnes, 10, 10)); // Espaciado uniforme
        panelJoc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes
        terreny = new Casella[files][columnes];

        // Inicializar casillas
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                terreny[i][j] = new Casella();
                terreny[i][j].addActionListener(this);
                panelJoc.add(terreny[i][j]);
            }
        }

        add(panelJoc, BorderLayout.CENTER);

        // Panel de botones inferior con diseño alineado
        JPanel panelBotons = new JPanel(new GridLayout(1, 2, 10, 5));
        panelBotons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener(e -> reiniciarJoc());
        panelBotons.add(btnReiniciar);

        btnSortir = new JButton("Finalitzar");
        btnSortir.addActionListener(e -> System.exit(0));
        panelBotons.add(btnSortir);

        add(panelBotons, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                if (e.getSource() == terreny[i][j]) {
                    regarFilaColumna(i, j);
                    return;
                }
            }
        }
    }

    private void regarFilaColumna(int fila, int columna) {
        // Regar toda la fila
        for (int j = 0; j < columnes; j++) {
            if (j != columna) {
                terreny[fila][j].avanzarEstat();
            }
        }
        // Regar toda la columna
        for (int i = 0; i < files; i++) {
            terreny[i][columna].avanzarEstat();
        }
    }

    private void reiniciarJoc() {
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                terreny[i][j].reinicialitzar();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FlorirJardi::new);
    }
}