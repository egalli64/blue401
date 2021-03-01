package blue.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUPERUSERS")
public class Superuser {
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

	@Column(name = "MAIL")
	private String mail;

	@Column(name = "ZONE")
	private long zoneId;

	@Column(name = "PHONE")
	private long phone;

	public Superuser() {

	}

	public Superuser(long id, String firstName, String lastName, String password, String mail, long zoneId,
			long phone) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mail = mail;
		this.zoneId = zoneId;
		this.phone = phone;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Superuser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", zoneId=" + zoneId + ", phone=" + phone + "]";
	}

}
