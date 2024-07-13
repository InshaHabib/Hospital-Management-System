import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientData {
    private String patientNo;
    private String patientName;
    private String phoneNo;
    private String address;

    public PatientData(String patientNo, String patientName, String phoneNo, String address) {
//        if (patientNo == null || patientNo.isEmpty() || !patientNo.matches("\\d+")) {
  //          throw new IllegalArgumentException("Invalid patient number");
    //    }
        if (patientName == null || patientName.isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        this.patientNo = patientNo;
        this.patientName = patientName;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    // Add any additional getters/setters as needed
}
