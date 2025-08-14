
public class Light extends SmartDevice implements Schedulable{
    private int brightness;
    public Light(String deviceID, boolean status) {
        super(deviceID, status);
    }

    @Override
    public void performFunction() {
        System.out.print("Enter the brightness: ");
        int brightness = scanner.nextInt();
        setBrightness(brightness);
        System.out.println(this.getClass().getSimpleName() + "'s brightness set to " + brightness);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        } else {
            throw new IllegalArgumentException("Brightness must be a positive number");
        }
    }

    @Override
    public void schedule(String time) {
        System.out.println(this.getClass().getSimpleName() + " is set to activate at " + time);
    }

}
