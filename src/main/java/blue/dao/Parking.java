package blue.dao;

import java.util.Date;

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
	private String capacityBike;

	@Column(name = "CAPACITY_CAR")
	private String capacityCar;

	@Column(name = "CAPACITY_CAMPER")
	private Date capacityCamper;

	@Column(name = "ZONE_ID")
	private String zoneId;

	@Column(name = "COST_BIKE")
	private long costBike;

	@Column(name = "COST_CAR")
	private long costCar;

	@Column(name = "COST_CAMPER")
	private String costCamper;

	@Column(name = "CAPACITY_ELECTRIC_VEHICLE")
	private String capacityElectricVehicle;

	@Column(name = "COST_ELECTRIC_VEHICLE")
	private String costElectricVehicle;

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

	public String getCapacityBike() {
		return capacityBike;
	}

	public void setCapacityBike(String capacityBike) {
		this.capacityBike = capacityBike;
	}

	public String getCapacityCar() {
		return capacityCar;
	}

	public void setCapacityCar(String capacityCar) {
		this.capacityCar = capacityCar;
	}

	public Date getCapacityCamper() {
		return capacityCamper;
	}

	public void setCapacityCamper(Date capacityCamper) {
		this.capacityCamper = capacityCamper;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
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

	public String getCostCamper() {
		return costCamper;
	}

	public void setCostCamper(String costCamper) {
		this.costCamper = costCamper;
	}

	public String getCapacityElectricVehicle() {
		return capacityElectricVehicle;
	}

	public void setCapacityElectricVehicle(String capacityElectricVehicle) {
		this.capacityElectricVehicle = capacityElectricVehicle;
	}

	public String getCostElectricVehicle() {
		return costElectricVehicle;
	}

	public void setCostElectricVehicle(String costElectricVehicle) {
		this.costElectricVehicle = costElectricVehicle;
	}

	public Parking() {
	}

	public Parking(String parkingName, String capacityBike, String capacityCar, Date capacityCamper, String zoneId,
			long costBike, long costCar, String costCamper, String capacityElectricVehicle,
			String costElectricVehicle) {

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

}
