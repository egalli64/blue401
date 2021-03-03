package blue.dao;

public class ParkingObj {
	
	private String parkingName;
	private long cost;
	private long capacity;
	
	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public ParkingObj(String parkingName, long cost, long capacity) {
		super();
		this.parkingName = parkingName;
		this.cost = cost;
		this.capacity = capacity;
	}
	
	

}
