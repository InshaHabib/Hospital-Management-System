package sockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private JTextField answerField;
    private JLabel[] questionLabels;

    public Client() {
        setTitle("Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1));

        questionLabels = new JLabel[5];
        for (int i = 0; i < questionLabels.length; i++) {
            questionLabels[i] = new JLabel();
            panel.add(questionLabels[i]);
        }

        answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(50, 30));

        JButton sendButton = new JButton("Get Answer");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getAnswer();
            }
        });

        panel.add(new JLabel("Select a number to get the answer:"));
        panel.add(answerField);
        panel.add(sendButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        connectToServer();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 5022);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 0; i < 5; i++) {
                String question = reader.readLine();
                questionLabels[i].setText(question); // Set the question text to JLabels
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAnswer() {
        try {
            int selectedQuestion = Integer.parseInt(answerField.getText());
            writer.println(selectedQuestion);

            String response = reader.readLine();
            JOptionPane.showMessageDialog(null, "Answer: " + response);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }
}
