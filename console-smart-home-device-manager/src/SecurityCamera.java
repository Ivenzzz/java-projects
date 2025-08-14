public class SecurityCamera extends SmartDevice {
    private boolean isRecording;
    public SecurityCamera(String deviceID, boolean status) {
        super(deviceID, status);
    }

    public boolean isRecording() {
        return isRecording;
    }

    public void setRecording(boolean recording) {
        isRecording = recording;
    }

    @Override
    public void performFunction() {
        System.out.println("Camera Status: " + (isRecording? "Recording" : "Not Recording"));
        isRecording = !isRecording;
        System.out.println("Camera Status: " + (isRecording? "Recording" : "Not Recording"));
    }
}
