package blue.dao;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKINGS")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARKING_ID")
	private long id;

	@Column(name = "PARKING_NAME")
	private String parkingName;

	@Column(name = "CAPACITY_BIKE")
	private long capacityBike;

	@Column(name = "CAPACITY_CAR")
	private long capacityCar;

	@Column(name = "CAPACITY_CAMPER")
	private long capacityCamper;

	@Column(name = "ZONE_ID")
	private long zoneId;

	@Column(name = "COST_BIKE")
	private long costBike;

	@Column(name = "COST_CAR")
	private long costCar;

	@Column(name = "COST_CAMPER")
	private long costCamper;

	@Column(name = "CAPACITY_ELECTRIC_VEHICLE")
	private long capacityElectricVehicle;

	@Column(name = "COST_ELECTRIC_VEHICLE")
	private long costElectricVehicle;

	public Parking(String parkingName, long capacityBike, long capacityCar, long capacityCamper, long zoneId,
			long costBike, long costCar, long costCamper, long capacityElectricVehicle, long costElectricVehicle) {
		super();
		this.parkingName = parkingName;
		this.capacityBike = capacityBike;
		this.capacityCar = capacityCar;
		this.capacityCamper = capacityCamper;
		this.zoneId = zoneId;
		this.costBike = costBike;
		this.costCar = costCar;
		this.costCamper = costCamper;
		this.capacityElectricVehicle = capacityElectricVehicle;
		this.costElectricVehicle = costElectricVehicle;
	}

	public Parking() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public long getCapacityBike() {
		return capacityBike;
	}

	public void setCapacityBike(long capacityBike) {
		this.capacityBike = capacityBike;
	}

	public long getCapacityCar() {
		return capacityCar;
	}

	public void setCapacityCar(long capacityCar) {
		this.capacityCar = capacityCar;
	}

	public long getCapacityCamper() {
		return capacityCamper;
	}

	public void setCapacityCamper(long capacityCamper) {
		this.capacityCamper = capacityCamper;
	}

	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	public long getCostBike() {
		return costBike;
	}

	public void setCostBike(long costBike) {
		this.costBike = costBike;
	}

	public long getCostCar() {
		return costCar;
	}

	public void setCostCar(long costCar) {
		this.costCar = costCar;
	}

	public long getCostCamper() {
		return costCamper;
	}

	public void setCostCamper(long costCamper) {
		this.costCamper = costCamper;
	}

	public long getCapacityElectricVehicle() {
		return capacityElectricVehicle;
	}

	public void setCapacityElectricVehicle(long capacityElectricVehicle) {
		this.capacityElectricVehicle = capacityElectricVehicle;
	}

	public long getCostElectricVehicle() {
		return costElectricVehicle;
	}

	public void setCostElectricVehicle(long costElectricVehicle) {
		this.costElectricVehicle = costElectricVehicle;
	}

}
