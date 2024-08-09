package proyecto.clientes;

public class Clientes {
    private String nombre;
    private String tipoDocumento;
    private String id;
    private String[] detallesCompras;
    private int[] preciosCompras;
    private int contadorCompras;

    // Constructor
    public Clientes(String nombre, String tipoDocumento, String id) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.id = id;
        this.detallesCompras = new String[10]; 
        this.preciosCompras = new int[10];
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
        if(tipoDocumento.equalsIgnoreCase("tarjeta de identidad")) {
            System.out.println("No se permite la compra con Tarjeta de Identidad (solo mayores de 18).");
        } else {
            this.tipoDocumento = tipoDocumento;
        }
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
        if (contadorCompras >= detallesCompras.length) {
            expandirArreglos();
        }
        detallesCompras[contadorCompras] = descripcion;
        preciosCompras[contadorCompras] = precio;
        contadorCompras++;
    }

    
    private void expandirArreglos() {
        int nuevoTamano = detallesCompras.length * 2;
        String[] nuevosDetalles = new String[nuevoTamano];
        int[] nuevosPrecios = new int[nuevoTamano];

        for (int i = 0; i < detallesCompras.length; i++) {
            nuevosDetalles[i] = detallesCompras[i];
            nuevosPrecios[i] = preciosCompras[i];
        }

        detallesCompras = nuevosDetalles;
        preciosCompras = nuevosPrecios;
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

    // Método main para pruebas
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes("Juan Perez", "CEDULA", "1234567890");
        cliente1.agregarCompra("Aguardiente", 50000);
        cliente1.agregarCompra("Cerveza", 5000);
        cliente1.agregarCompra("Shot de Tequila", 3000);

        // Simulando que hay más de 100 compras para probar la expansión
        for (int i = 0; i < 150; i++) {
            cliente1.agregarCompra("Compra " + (i + 1), 1000 * (i + 1));
        }

        System.out.println("Nombre: " + cliente1.getNombre());
        System.out.println("Tipo de Documento: " + cliente1.getTipoDocumento());
        System.out.println("ID: " + cliente1.getId());
        System.out.println("Historial de Compra: " + cliente1.historialDeCompra());
        System.out.println("Detalles de Compra: \n" + cliente1.detallesCompra());
    }
}
