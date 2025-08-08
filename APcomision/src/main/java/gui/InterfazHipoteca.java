package gui;

import modelos.Casa;
import util.CalculadoraHipoteca;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class InterfazHipoteca extends JFrame {
    private JTextField txtPrecio, txtInteres, txtAnios;
    private JLabel lblResultado;

    public InterfazHipoteca() {
        setTitle("Calculadora de Hipoteca");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));

        // Componentes
        panel.add(new JLabel("💰 Precio de la casa:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        panel.add(new JLabel("📈 Interés anual (%):"));
        txtInteres = new JTextField();
        panel.add(txtInteres);

        panel.add(new JLabel("📅 Años:"));
        txtAnios = new JTextField();
        panel.add(txtAnios);

        JButton btnCalcular = new JButton("Calcular cuota");
        panel.add(btnCalcular);

        lblResultado = new JLabel("Cuota: -");
        panel.add(lblResultado);

        add(panel);

        // Evento
        btnCalcular.addActionListener(e -> calcularCuota());
    }

    private void calcularCuota() {
        try {
            BigDecimal precio = new BigDecimal(txtPrecio.getText());
            double interes = Double.parseDouble(txtInteres.getText());
            int anios = Integer.parseInt(txtAnios.getText());

            BigDecimal cuota = CalculadoraHipoteca.calcularCuota(precio, interes, anios);
            lblResultado.setText("Cuota: " + cuota + " $");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠️ Error en los datos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazHipoteca().setVisible(true));
    }
}
