
package blue.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DATE_OF_BIRTH")
	private Date birthOfDate;

	@Column(name = "EMAIL")
	private String eMail;

	@Column(name = "VEHICLE_ID")
	private long vehicleId;

	@Column(name = "CREDIT")
	private long credit;

	@Column(name = "LICENSE_PLATE")
	private String licensePlate;

	public User() {
	}

	public User(String firstName, String lastName, String password, Date birthOfDate, String eMail, long vehicleId,
			String licensePlate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.birthOfDate = birthOfDate;
		this.eMail = eMail;
		this.vehicleId = vehicleId;
		this.credit = 0;
		this.licensePlate = licensePlate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public long getCredit() {
		return credit;
	}

	public void setCredit(long credit) {
		this.credit = credit;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthOfDate=" + birthOfDate
				+ ", eMail=" + eMail + ", vehicleId=" + vehicleId + ", credit=" + credit + ", licensePlate="
				+ licensePlate + "]";
	}



}