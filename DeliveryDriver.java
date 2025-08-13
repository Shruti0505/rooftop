public class DeliveryDriver {
	private int id;
	private int availableAt;

	static int driverCount = 0;

	public DeliveryDriver() {
		this.id = ++driverCount;
		this.availableAt = 0;
	}

	public int getId() {
		return id;
	}

	public int getAvailableAt() {
		return availableAt;
	}

	public void setAvailableAt(int time) {
		this.availableAt = time;
	}

	public boolean isAvailable(int currentTime) {
		return currentTime >= availableAt;
	}

	@Override
	public String toString() {
		return "D" + id;
	}
}
