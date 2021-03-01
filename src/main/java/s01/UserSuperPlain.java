package s01;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserSuperPlain {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MAIL")
    private String mail;
    
    @Column(name = "ZONE")
    private long zoneId;
    
    @Column(name = "PHONE")
    private long phone;
    


    public CoderPlain() {
    }

    public CoderPlain(long id, String firstName, String lastName, double salary) {
        this(id, firstName, lastName, LocalDate.now(), salary);
    }

    public CoderPlain(long id, String firstName, String lastName, LocalDate hireDate, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "CoderPlain [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hireDate=" + hireDate
                + ", salary=" + salary + "]";
    }
}