public interface Driveable{

	double MAX_SPEED_CAR = 250.00;
	double MAX_SPEED_BIKE = 100.00;

	void accelerate(int speedFactor);
	void breaks(int speedFactor);

	void stop();

}