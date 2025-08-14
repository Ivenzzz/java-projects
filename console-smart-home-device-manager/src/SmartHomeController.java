public class SmartHomeController {
    private SmartDevice[] devices;
    public SmartHomeController(SmartDevice[] devices) {
        this.devices = devices;
    }

    public void turnOnAllDevices() {
        for (SmartDevice device : devices) {
            device.toggleStatus();
        }
    }

    public void performAllFunction() {
        for (SmartDevice device : devices) {
            device.performFunction();
        }
    }

    public void scheduleDevices(String time) {
        for (SmartDevice device : devices) {
            if (device instanceof Schedulable) {
                ((Schedulable) device).schedule(time);
            }
        }
    }
}
