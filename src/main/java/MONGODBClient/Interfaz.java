package MONGODBClient;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.bson.Document;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Interfaz extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Document pokemonInfo = null;
    private JLabel lblNombre;
    private JLabel lblNivel;
    private JLabel lblTipo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz frame = new Interfaz();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Interfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1066, 425);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton_2 = new JButton("Informacion del Pokemon");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pokemonInfo = MongoConector.mostrarInfo("Bulbasur");
                if (pokemonInfo != null) {
                    updateLabels();
                } else {
                    lblNombre.setText("Información no encontrada");
                    lblNivel.setText("");
                    lblTipo.setText("");
                }
            }
        });
        btnNewButton_2.setBounds(10, 11, 200, 23);
        contentPane.add(btnNewButton_2);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 50, 300, 23);
        contentPane.add(lblNombre);

        lblNivel = new JLabel("Nivel:");
        lblNivel.setBounds(10, 80, 300, 23);
        contentPane.add(lblNivel);

        lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(10, 110, 300, 23);
        contentPane.add(lblTipo);
    }

    private void updateLabels() {
        lblNombre.setText("Nombre: " + pokemonInfo.getString("name"));
        lblNivel.setText("Nivel: " + pokemonInfo.getString("level"));
        lblTipo.setText("Tipo: " + pokemonInfo.getString("type"));
    }
}
