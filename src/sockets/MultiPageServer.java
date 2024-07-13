package sockets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiPageServer {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket clientSocket;

        try {
            serverSocket = new ServerSocket(5009);

            while (true) {
                clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                handleRequest(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRequest(String request) {
        switch (request) {
            case "Doctor":
                sendDescription("Q: How can a doctor register at the Foundation Hospital?\n" +
"\n" +
"A: To register, a doctor needs to provide essential details such as Doctor Name, Specialization, Qualification, Appointment Fee, Phone, and Room Number. "
                        + "The registration process is handled by the hospital administration.\n "
                        + "Q: Can a doctor update their registration information?\n" +
"\n" +
"A: Yes, doctors have the capability to update their registration information. "
                        + "They can modify details such as contact information, specialization, or room assignment as needed.\n"
                        + "Q: What happens if a doctor's qualification changes?\n" +
"\n" +
"A: If a doctor's qualification changes, they should promptly update their registration details."
                        + " This ensures that the hospital and patients have accurate information about the doctor's credentials.");
                break;
            case "Receptionist":
                sendDescription("Register Patient:\n" +
"\n" +
"Q: How can a patient be registered by the receptionist at the Foundation Hospital?\n" +
"\n" +
"A: Patient registration involves providing essential information such as Patient Name, Phone Number, and Address. Receptionists handle "
                        + "this process to create and maintain patient records.\n" +
"Q: Can a receptionist update a patient's information after registration?\n" +
"\n" +
"A: Yes, receptionists have the ability to update patient information. If there are changes in the patient's contact details or address, "
                        + "the receptionist can modify the records accordingly.\n" +
"Q: Is it possible for a receptionist to delete a patient record from the system?\n" +
"\n" +
"A: Receptionists can remove outdated or incorrect patient records from the system. "
                        + "However, such deletions are typically done cautiously and may require verification.\n" +
"Create Drug:\n" +
"\n" +
"Q: How does a receptionist create a new drug entry in the hospital's system?\n" +
"\n" +
"A: To add a new drug, receptionists enter details such as Drug Name, Description, Price, and Quantity into the system."
                        + " This allows for effective management of hospital inventory.\n" +
"Q: Can a receptionist update the details of an existing drug?\n" +
"\n" +
"A: Yes, receptionists can update drug information. This includes modifying details like the drug's description, price, or quantity based on changes or "
                        + "requirements.\n" +
"Q: Is there an option for a receptionist to delete a drug entry?\n" +
"\n" +
"A: Receptionists can request the removal of a drug entry if it is no longer in use or if there are errors. "
                        + "However, such deletions are subject to approval and verification.\n" +
"View Doctor Detail:\n" +
"\n" +
"Q: How can a receptionist view details about a doctor in the hospital?\n" +
"\n" +
"A: Receptionists have access to the hospital's system where they can view comprehensive details about doctors, including their names, specializations, qualifications, "
                        + "appointment fees, contact numbers, and room numbers.\n" +
"Q: Is there a centralized system for receptionists to view all doctor details?\n" +
"\n" +
"A: Yes, the hospital maintains a centralized system that allows receptionists to access and view comprehensive details of all doctors. This ensures efficient management of doctor information.\n" +
"Q: Can receptionists access real-time information about doctor availability and schedules?\n" +
"\n" +
"A: Yes, receptionists have access to real-time information about doctor availability and schedules. This enables them to assist patients in scheduling appointments with the appropriate doctors.");
                break;
            case "Pharmacist":
                sendDescription("View Prescription:\n" +
"\n" +
"Q: How does a pharmacist view a prescription in the Foundation Hospital system?\n" +
"\n" +
"A: Pharmacists can access prescriptions by Prescription ID or Appointment ID. This information includes details like Prescription ID, "
                        + "Appointment ID, Doctor Name, Disease Type, and a Description of the disease.\n" +
"Q: Can a pharmacist view prescriptions from a specific doctor?\n" +
"\n" +
"A: Yes, pharmacists can filter prescriptions based on the prescribing doctor's name. This helps them organize and manage prescriptions effectively.\n" +
"Q: Is there a way for pharmacists to view comprehensive information about a patient's prescription history?\n" +
"\n" +
"A: Yes, the hospital system allows pharmacists to access a patient's prescription history, providing a comprehensive overview of their medications and treatments.\n" +
"Create Drug:\n" +
"\n" +
"Q: How can a pharmacist create a new drug entry in the hospital's system?\n" +
"\n" +
"A: To add a new drug, pharmacists enter details such as Drug Name, Description, Price, and Quantity. This information is crucial for maintaining "
                        + "an updated inventory of available medications.\n" +
"Q: Can a pharmacist update the details of an existing drug in the system?\n" +
"\n" +
"A: Yes, pharmacists have the ability to update information about existing drugs. This includes modifying details such as the drug's description, "
                        + "price, or quantity based on changes or requirements.\n" +
"Q: Is there an option for a pharmacist to delete a drug entry from the system?\n" +
"\n" +
"A: Pharmacists can request the removal of a drug entry if it is no longer in use or if there are errors. However, such deletions are subject to approval and verification.\n" +
"View Doctor List:\n" +
"\n" +
"Q: How can a pharmacist view the list of doctors in the hospital?\n" +
"\n" +
"A: Pharmacists have access to the hospital's system, where they can view a comprehensive list of doctors. This list includes Doctor Number, Doctor Name,"
                        + " Specialization, Qualification, Fee, Phone Number, and Room Number.\n" +
"Q: Can pharmacists filter the doctor list based on specialization or qualification?\n" +
"\n" +
"A: Yes, pharmacists can filter the doctor list based on specific criteria such as specialization or qualification. "
                        + "This feature assists in finding doctors with particular expertise.\n" +
"Q: Is there a centralized system for pharmacists to view real-time information about doctor availability and contact details?\n" +
"\n" +
"A: Yes, the hospital maintains a centralized system that provides real-time information about doctor availability, contact details, and room assignments."
                        + " This ensures efficient collaboration between pharmacists and doctors.");
                break;
            case "Foundation Hospital Overview":
                sendDescription("Q: What is the mission of Foundation Hospital?\n" +
"\n" +
"A: The mission of Foundation Hospital is to provide high-quality, compassionate healthcare to our community, emphasizing patient well-being and medical excellence.\n" +
"Q: What services does Foundation Hospital offer?\n" +
"\n" +
"A: Foundation Hospital offers a comprehensive range of medical services, including but not limited to general healthcare, specialized treatments, emergency care,"
                        + " and diagnostic services.\n" +
"Q: How can patients access services at Foundation Hospital?\n" +
"\n" +
"A: Patients can access services at Foundation Hospital by scheduling appointments through our appointment desk, visiting our emergency department for urgent care, "
                        + "or utilizing our online appointment system.\n" +
"Q: Are there specialized departments at Foundation Hospital?\n" +
"\n" +
"A: Yes, Foundation Hospital houses specialized departments such as cardiology, pediatrics, orthopedics, and more. Each department is staffed by experienced and "
                        + "qualified healthcare professionals.\n" +
"Q: What facilities are available at Foundation Hospital?\n" +
"\n" +
"A: Foundation Hospital is equipped with state-of-the-art facilities, including modern patient rooms, advanced diagnostic equipment, operating theaters, and"
                        + " specialized treatment areas.\n" +
"Q: How does Foundation Hospital prioritize patient safety and comfort?\n" +
"\n" +
"A: Patient safety and comfort are our top priorities. We implement rigorous safety protocols, maintain a clean and welcoming environment, and ensure "
                        + "that our staff is trained to deliver patient-centered care.\n" +
"Q: Can patients access their medical records online at Foundation Hospital?\n" +
"\n" +
"A: Yes, Foundation Hospital provides an online portal for patients to access their medical records, schedule appointments, and communicate with healthcare "
                        + "providers for enhanced convenience.\n" +
"Q: What community outreach programs does Foundation Hospital participate in?\n" +
"\n" +
"A: Foundation Hospital actively engages in community outreach programs, health education initiatives, and wellness campaigns to promote health and well-being "
                        + "in the community.\n" +
"Q: How does Foundation Hospital ensure the confidentiality of patient information?\n" +
"\n" +
"A: Foundation Hospital follows strict privacy and confidentiality policies in line with healthcare regulations. We employ secure electronic systems and "
                        + "train our staff on patient privacy protocols.\n" +
"Q: Is Foundation Hospital involved in medical research and innovation?\n" +
"\n" +
"A: Yes, Foundation Hospital is committed to medical research and innovation. We collaborate with research institutions, participate in clinical trials,"
                        + " and adopt cutting-edge technologies to advance healthcare.");
                break;
                
            default:
                sendDescription("Invalid request.");
                break;
        }
    }
    
    private void sendDescription(String description) {
        out.println(description);
    }
}