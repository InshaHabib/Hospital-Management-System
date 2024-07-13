import java.util.Vector;

// Data class to represent an Appointment record
public class AppointmentRecord {
    private String appointmentNo;
    private String doctorName;
    private String patientName;
    private String roomNo;
    private String date;

    // Constructor
    public AppointmentRecord(String appointmentNo, String doctorName, String patientName, String roomNo, String date) {
  //     if (appointmentNo == null || appointmentNo.isEmpty() || !appointmentNo.matches("\\d+")) {
//            throw new IllegalArgumentException("Invalid appointment number");
    //    }
        if (doctorName == null || doctorName.isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty");
        }
        if (patientName == null || patientName.isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        }
  //      if (roomNo == null || roomNo.isEmpty() || !roomNo.matches("\\d+")) {
//            throw new IllegalArgumentException("Invalid room number");
    //    }
        if (date == null || date.isEmpty() || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid date format, expected yyyy-MM-dd");
        }

        this.appointmentNo = appointmentNo;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.roomNo = roomNo;
        this.date = date;
    }

    // Getters
    public String getAppointmentNo() {
        return appointmentNo;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getDate() {
        return date;
    }

    // Static method to convert a Vector to an AppointmentRecord
    public static AppointmentRecord fromVector(Vector<String> vector) {
        if (vector.size() != 5) {
            throw new IllegalArgumentException("Invalid vector size, expected 5 elements");
        }
        return new AppointmentRecord(
                vector.get(0),
                vector.get(1),
                vector.get(2),
                vector.get(3),
                vector.get(4)
        );
    }
}
