package main.java.model;

public class Order {

    private int idOrder;
    private int idFlight;
    private int idPersonal;
    private String status;

    public Order() {
    }

    public Order(int idOrder, int idFlight, int idPersonal, String status) {
        this.idOrder = idOrder;
        this.idFlight = idFlight;
        this.idPersonal = idPersonal;
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idFlight;
        result = prime * result + idOrder;
        result = prime * result + idPersonal;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (idFlight != other.idFlight)
            return false;
        if (idOrder != other.idOrder)
            return false;
        if (idPersonal != other.idPersonal)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [idOrder=" + idOrder + ", idFlight=" + idFlight + ", idPersonal=" + idPersonal + ", status="
                + status + "]";
    }

}
