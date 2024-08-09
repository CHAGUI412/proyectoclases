package proyecto.clientes;

import java.util.Arrays;

public class Clientes {
    private String nombre;
    private String tipoDocumento;
    private String id;
    private String[] detallesCompras;
    private int[] preciosCompras;
    private int contadorCompras;

   
    public Clientes(String nombre, String tipoDocumento, String id) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.id = id;
        this.detallesCompras = new String[0]; 
        this.preciosCompras = new int[0];
        this.contadorCompras = 0;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() == 10) {
            this.id = id;
        } else {
            System.out.println("El ID debe tener 10 dígitos.");
        }
    }

    
    public void agregarCompra(String descripcion, int precio) {
        
        String[] nuevosDetallesCompras = Arrays.copyOf(detallesCompras, detallesCompras.length + 1);
        int[] nuevosPreciosCompras = Arrays.copyOf(preciosCompras, preciosCompras.length + 1);

        
        nuevosDetallesCompras[contadorCompras] = descripcion;
        nuevosPreciosCompras[contadorCompras] = precio;

       
        detallesCompras = nuevosDetallesCompras;
        preciosCompras = nuevosPreciosCompras;

        contadorCompras++;
    }

   
    public int historialDeCompra() {
        return contadorCompras;
    }

    
    public String detallesCompra() {
        StringBuilder detalles = new StringBuilder();
        for (int i = 0; i < contadorCompras; i++) {
            detalles.append(detallesCompras[i])
                    .append(" - ")
                    .append(preciosCompras[i])
                    .append("\n");
        }
        return detalles.toString();
    }

    // este main es para pruebas
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes("Juan Perez", "DNI", "1234567890");
        cliente1.agregarCompra("Aguardiente", 50000);
        cliente1.agregarCompra("Cerveza", 5000);
        cliente1.agregarCompra("Shot de Tequila", 3000);

        System.out.println("Nombre: " + cliente1.getNombre());
        System.out.println("Tipo de Documento: " + cliente1.getTipoDocumento());
        System.out.println("ID: " + cliente1.getId());
        System.out.println("Historial de Compra: " + cliente1.historialDeCompra());
        System.out.println("Detalles de Compra: \n" + cliente1.detallesCompra());
    }
}
