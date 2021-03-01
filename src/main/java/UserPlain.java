//TODO
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
public class UserPlain {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "MAIL")
    private String mail;
    
    @Column(name = "CAR_ID")
    private long carId;
    
    @Column(name = "BIKE_ID")
    private long bikeId;
    
    @Column(name = "CAMPER_ID")
    private long camperId;
    
    @Column(name = "ELECTRIC_ID")
    private long electricId;

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