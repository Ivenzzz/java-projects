public class Thermostat extends SmartDevice implements Schedulable {
    private double temperature;

    public Thermostat(String deviceID, boolean status, double temperature) {
        super(deviceID, status);
        setTemperature(temperature);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature <= 30 && temperature >= 16) {
            this.temperature = temperature;
        } else {
            throw new IllegalArgumentException("Temperature must be between 16 - 30. ");
        }
    }

    @Override
    public void performFunction() {
        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();
        setTemperature(temperature);
        System.out.println(this.getClass().getSimpleName() + " temperature has been adjusted to " + temperature);
    }

    @Override
    public void schedule(String time) {
        System.out.println(this.getClass().getSimpleName() + " is set to activate at " + time);
    }
}
