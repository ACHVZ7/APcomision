package gui;

import modelos.Casa;
import servicio.SupabaseClient;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class InterfazCasa extends JFrame {
    private JTextField txtNombre, txtDireccion, txtPrecio, txtTamano, txtHabitaciones, txtBanos;
    private JCheckBox chkVendida;

    public InterfazCasa() {
        setTitle("🏡 Registro de Casa");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);

        panel.add(new JLabel("Precio (€):"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        panel.add(new JLabel("Tamaño (m²):"));
        txtTamano = new JTextField();
        panel.add(txtTamano);

        panel.add(new JLabel("Habitaciones:"));
        txtHabitaciones = new JTextField();
        panel.add(txtHabitaciones);

        panel.add(new JLabel("Baños:"));
        txtBanos = new JTextField();
        panel.add(txtBanos);

        panel.add(new JLabel("¿Vendida?"));
        chkVendida = new JCheckBox();
        panel.add(chkVendida);

        // Botón
        JButton btnInsertar = new JButton("Insertar en Supabase");
        panel.add(new JLabel()); // espacio vacío
        panel.add(btnInsertar);

        add(panel, BorderLayout.CENTER);

        // Acción botón
        btnInsertar.addActionListener(e -> insertarCasa());
    }

    private void insertarCasa() {
        try {
            Casa casa = new Casa(
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    new BigDecimal(txtPrecio.getText()),
                    new BigDecimal(txtTamano.getText()),
                    Integer.parseInt(txtHabitaciones.getText()),
                    Integer.parseInt(txtBanos.getText()),
                    chkVendida.isSelected()
            );

            SupabaseClient supabase = new SupabaseClient();
            supabase.insertarCasa(casa);

            JOptionPane.showMessageDialog(this, "✅ Casa insertada correctamente.");
            limpiarCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Error al insertar: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtPrecio.setText("");
        txtTamano.setText("");
        txtHabitaciones.setText("");
        txtBanos.setText("");
        chkVendida.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazCasa().setVisible(true));
    }
}
