package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Map<Integer, String> answers = new HashMap<>();

    public static void main(String[] args) {
        // Store random answers for questions
        storeAnswers();

        try (ServerSocket serverSocket = new ServerSocket(5022)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                // Send 5 random questions to the client
                for (int i = 1; i <= 5; i++) {
                    writer.println("Question " + i + "?");
                }

                // Continuously handle client requests
                while (true) {
                    try {
                        // Receive selected question number from the client
                        int selectedQuestion = Integer.parseInt(reader.readLine());

                        // Get the corresponding answer and send it back to the client
                        String answer = answers.getOrDefault(selectedQuestion, "Invalid question number");
                        writer.println(answer);
                    } catch (IOException | NumberFormatException e) {
                        // If an exception occurs, break the loop and close the connection
                        break;
                    }
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void storeAnswers() {
        // Random answers stored for 5 questions
        answers.put(1, "To register, a doctor needs to provide essential details such as Doctor Name, Specialization, Qualification, Appointment Fee, Phone, and Room Number."
                + " The registration process is handled by the hospital administration.\n");
        answers.put(2, "Yes, doctors have the capability to update their registration information. "
                + "They can modify details such as contact information, specialization, or room assignment as needed.\n");
        answers.put(3, "Patient registration involves providing essential information such as Patient Name, Phone Number, and Address. Receptionists handle "
                        + "this process to create and maintain patient records.\n");
        answers.put(4, "Yes, receptionists have the ability to update patient information. If there are changes in the patient's contact details or address, "
                        + "the receptionist can modify the records accordingly.\n");
        answers.put(5, " Receptionists can remove outdated or incorrect patient records from the system. "
                        + "However, such deletions are typically done cautiously and may require verification.\n");
    }
}
