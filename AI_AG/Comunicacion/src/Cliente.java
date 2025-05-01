import java.io.Serializable;

public class Cliente implements Serializable{
    int idPersona, idCliente;
    double precioPromedio, totalFacturas, cupo, pagoUltimoMes;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getPrecioPromedio() {
        return precioPromedio;
    }

    public void setPrecioPromedio(double precioPromedio) {
        this.precioPromedio = precioPromedio;
    }

    public double getTotalFacturas() {
        return totalFacturas;
    }

    public void setTotalFacturas(double totalFacturas) {
        this.totalFacturas = totalFacturas;
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }

    public double getPagoUltimoMes() {
        return pagoUltimoMes;
    }

    public void setPagoUltimoMes(double pagoUltimoMes) {
        this.pagoUltimoMes = pagoUltimoMes;
    }

    public Cliente(int idPersona, int idCliente, double precioPromedio, double totalFacturas, double cupo, double pagoUltimoMes) {
        this.idPersona = idPersona;
        this.precioPromedio = precioPromedio;
        this.totalFacturas = totalFacturas;
        this.cupo = cupo;
        this.pagoUltimoMes = pagoUltimoMes;
        this.idCliente = idCliente;
    }
    
    public Cliente(){
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idPersona=" + idPersona +
                ", precioPromedio=" + precioPromedio +
                ", totalFacturas=" + totalFacturas +
                ", cupo=" + cupo +
                ", pagoUltimoMes=" + pagoUltimoMes +
                '}';
    }    
}