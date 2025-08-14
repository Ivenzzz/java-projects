public class Main {
    public static void main(String[] args) {

        SmartDevice device1 = new Light("0001", false);
        SmartDevice device2 = new SecurityCamera("0002", false);
        SmartDevice device3 = new Thermostat("0003", false, 65);

        SmartDevice[] devices = { device1, device2, device3 };
        SmartHomeController controller = new SmartHomeController(devices);

        controller.turnOnAllDevices();
        controller.performAllFunction();
        controller.scheduleDevices("5:00 AM");

    }
}
