public class producto {
    private String nombreProducto;
    private int idProducto;
    private double valor;
    private int cantidad;
    
    public producto(String nombreProducto, int idProducto, double valor, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
        this.valor = valor;
        this.cantidad = cantidad;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
