package pl.zgora.uz.wiea.tna.service.exception;

public class AttendanceNotFoundException extends ResourceNotFoundException {

    public AttendanceNotFoundException() {
        super("Attendance not found.");
    }
}
