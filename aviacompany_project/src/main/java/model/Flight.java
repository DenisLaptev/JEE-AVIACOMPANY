package main.java.model;

public class Flight {

    private int idFlight;
    private String name;
    private String flightFrom;
    private String flightTo;
    private String date;
    private String orderStatus;
    private int idOrder;

    

	public Flight() {
    }

    public Flight(int idFlight, String name, String flightFrom, String flightTo, String date) {
        this.idFlight = idFlight;
        this.name = name;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.date = date;
        this.orderStatus = "free";
        this.idOrder = -1;
    }

    public Flight(int idFlight, String name, String flightFrom, String flightTo, String date,String orderStatus,int idOrder) {
        this.idFlight = idFlight;
        this.name = name;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.date = date;
        this.orderStatus = orderStatus;
        this.idOrder = idOrder;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((flightFrom == null) ? 0 : flightFrom.hashCode());
		result = prime * result + ((flightTo == null) ? 0 : flightTo.hashCode());
		result = prime * result + idFlight;
		result = prime * result + idOrder;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
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
		Flight other = (Flight) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (flightFrom == null) {
			if (other.flightFrom != null)
				return false;
		} else if (!flightFrom.equals(other.flightFrom))
			return false;
		if (flightTo == null) {
			if (other.flightTo != null)
				return false;
		} else if (!flightTo.equals(other.flightTo))
			return false;
		if (idFlight != other.idFlight)
			return false;
		if (idOrder != other.idOrder)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [idFlight=" + idFlight + ", name=" + name + ", flightFrom=" + flightFrom + ", flightTo="
				+ flightTo + ", date=" + date + ", orderStatus=" + orderStatus + ", idOrder=" + idOrder + "]";
	}

   
}
