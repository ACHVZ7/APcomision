package modelos;

import java.math.BigDecimal;
import java.util.UUID;

public class Casa {
    private UUID id;
    private String nombre;
    private String direccion;
    private BigDecimal precio;
    private BigDecimal tamaño;
    private int habitaciones;
    private int baños;
    private boolean vendida;

    // Constructor
    public Casa(String nombre, String direccion, BigDecimal precio, BigDecimal tamaño,
                int habitaciones, int baños, boolean vendida) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.direccion = direccion;
        this.precio = precio;
        this.tamaño = tamaño;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.vendida = vendida;
    }

    // Getters y Setters (genera automáticamente en IntelliJ: Alt + Insert)
    public UUID getId() { return id; }
    public String getNombre() { return nombre; }

}