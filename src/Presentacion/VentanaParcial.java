package Presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Logica.Parcial;

public class VentanaParcial extends JFrame implements ActionListener {

    private static final long serialVersionUID = -7304515019707757390L;
	private JTextField txtA;
    private JTextField txtB;
    private JTextField txtC;
    private JLabel lblResultado;
    private Parcial parcial;

    public VentanaParcial() {
        parcial = new Parcial();

        setTitle("Examen Santiago Castano");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 15));

        txtA = new JTextField();
        txtB = new JTextField();
        txtC = new JTextField();
        lblResultado = new JLabel("");

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);

        add(new JLabel("a:", SwingConstants.RIGHT));
        add(txtA);

        add(new JLabel("b:", SwingConstants.RIGHT));
        add(txtB);

        add(new JLabel("c:", SwingConstants.RIGHT));
        add(txtC);

        add(btnCalcular);
        add(lblResultado);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            int a = Integer.parseInt(txtA.getText().trim());
            int b = Integer.parseInt(txtB.getText().trim());
            int c = Integer.parseInt(txtC.getText().trim());

            lblResultado.setText(parcial.calcularRaices(a, b, c));

        } catch (NumberFormatException e) {
            lblResultado.setText("");
            JOptionPane.showMessageDialog(
                this,
                "Ingrese numeros enteros en los 3 apartados.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {
            lblResultado.setText("");
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaParcial();
            }
        });
    }
}
