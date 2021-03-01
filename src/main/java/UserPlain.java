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
    @Column(name = "ID_USER")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_OF_DATE")
    private LocalDate birthOfDate;

    @Column(name = "EMAIL")
    private String eMail;
    
    @Column(name = "VEHICLE_ID")
    private long vehicleId;
    
    @Column(name = "CREDIT")
    private long credit;
    
    @Column(name = "LICENSE_PLATE")
    private String licensePlate;
    


    public UserPlain() {
    }

    public UserPlain(long id, String firstName, String lastName, double salary) {
        this(id, firstName, lastName, LocalDate.now(), salary);
    }

    public UserPlain(long id, String firstName, String lastName, LocalDate hireDate, double salary) {
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