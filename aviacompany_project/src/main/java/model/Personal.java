package main.java.model;

public class Personal {

	private int idPersonal;
	private int idPilot1;
	private int idPilot2;
	private int idShturman;
	private int idRadist;
	private int idSt1;
	private int idSt2;
	private int idSt3;
	private int idOrder;

	public Personal() {
	}

	public Personal(int idPilot1, int idPilot2, int idShturman, int idRadist, int idSt1, int idSt2, int idSt3,
			int idOrder) {
		this.idPilot1 = idPilot1;
		this.idPilot2 = idPilot2;
		this.idShturman = idShturman;
		this.idRadist = idRadist;
		this.idSt1 = idSt1;
		this.idSt2 = idSt2;
		this.idSt3 = idSt3;
		this.idOrder = idOrder;
	}

	public Personal(int idPersonal, int idPilot1, int idPilot2, int idShturman, int idRadist, int idSt1, int idSt2,
			int idSt3, int idOrder) {
		this.idPersonal = idPersonal;
		this.idPilot1 = idPilot1;
		this.idPilot2 = idPilot2;
		this.idShturman = idShturman;
		this.idRadist = idRadist;
		this.idSt1 = idSt1;
		this.idSt2 = idSt2;
		this.idSt3 = idSt3;
		this.idOrder = idOrder;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public int getIdPilot1() {
		return idPilot1;
	}

	public void setIdPilot1(int idPilot1) {
		this.idPilot1 = idPilot1;
	}

	public int getIdPilot2() {
		return idPilot2;
	}

	public void setIdPilot2(int idPilot2) {
		this.idPilot2 = idPilot2;
	}

	public int getIdShturman() {
		return idShturman;
	}

	public void setIdShturman(int idShturman) {
		this.idShturman = idShturman;
	}

	public int getIdRadist() {
		return idRadist;
	}

	public void setIdRadist(int idRadist) {
		this.idRadist = idRadist;
	}

	public int getIdSt1() {
		return idSt1;
	}

	public void setIdSt1(int idSt1) {
		this.idSt1 = idSt1;
	}

	public int getIdSt2() {
		return idSt2;
	}

	public void setIdSt2(int idSt2) {
		this.idSt2 = idSt2;
	}

	public int getIdSt3() {
		return idSt3;
	}

	public void setIdSt3(int idSt3) {
		this.idSt3 = idSt3;
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
		result = prime * result + idOrder;
		result = prime * result + idPersonal;
		result = prime * result + idPilot1;
		result = prime * result + idPilot2;
		result = prime * result + idRadist;
		result = prime * result + idShturman;
		result = prime * result + idSt1;
		result = prime * result + idSt2;
		result = prime * result + idSt3;
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
		Personal other = (Personal) obj;
		if (idOrder != other.idOrder)
			return false;
		if (idPersonal != other.idPersonal)
			return false;
		if (idPilot1 != other.idPilot1)
			return false;
		if (idPilot2 != other.idPilot2)
			return false;
		if (idRadist != other.idRadist)
			return false;
		if (idShturman != other.idShturman)
			return false;
		if (idSt1 != other.idSt1)
			return false;
		if (idSt2 != other.idSt2)
			return false;
		if (idSt3 != other.idSt3)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", idPilot1=" + idPilot1 + ", idPilot2=" + idPilot2
				+ ", idShturman=" + idShturman + ", idRadist=" + idRadist + ", idSt1=" + idSt1 + ", idSt2=" + idSt2
				+ ", idSt3=" + idSt3 + ", idOrder=" + idOrder + "]";
	}

}
