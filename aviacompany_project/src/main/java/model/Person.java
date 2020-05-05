package main.java.model;

public class Person {

    private int idPerson;
    private int idPersonal;
    private String firstName;
    private String lastName;
    private String profession;

    public Person() {
    }

    public Person(int idPerson, int idPersonal, String firstName, String lastName, String profession) {
    	this.idPerson = idPerson;
    	this.idPersonal = idPersonal;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profession = profession;
	}

	public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + idPerson;
		result = prime * result + idPersonal;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idPerson != other.idPerson)
			return false;
		if (idPersonal != other.idPersonal)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", idPersonal=" + idPersonal + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", profession=" + profession + "]";
	}
}
