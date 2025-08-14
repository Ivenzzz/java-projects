import java.util.Scanner;

public abstract class SmartDevice {
    private String deviceID;
    private boolean status;
    Scanner scanner = new Scanner(System.in);

    public SmartDevice(String deviceID, boolean status) {
        this.deviceID = deviceID;
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public abstract void performFunction();

    public void showStatus() {
        String state = getStatus()? "ON" : "OFF";
        System.out.println("The device is " + state);
    }

    public void toggleStatus() {
        status = !status;
        System.out.println("The " + this.getClass().getSimpleName() + " is now " + (status? "ON" : "OFF"));
    }
}
