package MONGODBClient;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.bson.Document;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

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
        
        JLabel lblNewLabel = new JLabel("\"Monedas\"");
        lblNewLabel.setBounds(94, 23, 77, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("POKEMON 1");
        lblNewLabel_1.setBounds(72, 100, 77, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("POKEMON 2");
        lblNewLabel_2.setBounds(72, 140, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("POKEMON 3");
        lblNewLabel_3.setBounds(72, 178, 72, 14);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("POKEMON 4");
        lblNewLabel_4.setBounds(72, 217, 72, 14);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblnumeroCodigoPokemon = new JLabel("\"numero codigo pokemon\"");
        lblnumeroCodigoPokemon.setBounds(327, 23, 148, 14);
        contentPane.add(lblnumeroCodigoPokemon);
        
        JLabel lblNewLabel_5 = new JLabel("Nombre Pokemon");
        lblNewLabel_5.setBounds(299, 73, 96, 14);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Biografia");
        lblNewLabel_6.setBounds(349, 126, 46, 14);
        contentPane.add(lblNewLabel_6);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
        chckbxNewCheckBox.setBounds(19, 96, 41, 23);
        contentPane.add(chckbxNewCheckBox);
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
        chckbxNewCheckBox_1.setBounds(19, 136, 41, 23);
        contentPane.add(chckbxNewCheckBox_1);
        
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
        chckbxNewCheckBox_2.setBounds(18, 174, 34, 23);
        contentPane.add(chckbxNewCheckBox_2);
        
        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
        chckbxNewCheckBox_3.setBounds(19, 213, 34, 23);
        contentPane.add(chckbxNewCheckBox_3);
        
        JLabel lblNewLabel_7 = new JLabel("TIPO 1");
        lblNewLabel_7.setBounds(327, 198, 46, 14);
        contentPane.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("TIPO 2");
        lblNewLabel_8.setBounds(412, 198, 46, 14);
        contentPane.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Altura");
        lblNewLabel_9.setBounds(327, 245, 46, 14);
        contentPane.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("PS: ");
        lblNewLabel_10.setBounds(327, 295, 46, 14);
        contentPane.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("Imagen");
        lblNewLabel_11.setBounds(448, 52, 77, 62);
        contentPane.add(lblNewLabel_11);

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
        //btnNewButton_2.setBounds(197, 182, 200, 23);
        //contentPane.add(btnNewButton_2);

        //lblNombre = new JLabel("Nombre:");
        //lblNombre.setBounds(10, 50, 300, 23);
       //contentPane.add(lblNombre);

        //lblNivel = new JLabel("Nivel:");
       //lblNivel.setBounds(10, 80, 300, 23);
        //contentPane.add(lblNivel);

        //lblTipo = new JLabel("Tipo:");
        //lblTipo.setBounds(10, 110, 300, 23);
        //contentPane.add(lblTipo);
        
        //JLabel lblSaldoDisponible = new JLabel("SALDO DISPONIBLE:");
        //lblSaldoDisponible.setBounds(10, 144, 300, 23);
        //contentPane.add(lblTipo);
    }

    private void updateLabels() {
        lblNombre.setText("Nombre: " + pokemonInfo.getString("name"));
        lblNivel.setText("Nivel: " + pokemonInfo.getString("level"));
        lblTipo.setText("Tipo: " + pokemonInfo.getString("type"));
        
    }
}
