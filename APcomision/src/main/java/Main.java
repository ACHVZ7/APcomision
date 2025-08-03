import modelos.Casa;
import servicio.SupabaseClient;
import util.CalculadoraHipoteca;
import java.math.BigDecimal;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear una casa de ejemplo
        Casa casa = new Casa(
                "Casa en la playa",
                "Av. Costa 123",
                new BigDecimal("350000.50"),
                new BigDecimal("90.75"),
                2,
                1,
                false
        );

        // Insertar en Supabase
        SupabaseClient supabase = new SupabaseClient();
        try {
            supabase.insertarCasa(casa);
        } catch (IOException e) {
            System.err.println("❌ Error al insertar: " + e.getMessage());
        }

        // Calcular hipoteca
        BigDecimal cuota = CalculadoraHipoteca.calcularCuota(
                new BigDecimal("350000"),
                3.5,
                30
        );
        System.out.println("💰 Cuota mensual: " + cuota + " €");
    }
}