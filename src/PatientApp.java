import javax.swing.*;

public class PatientApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SmartMed");
        JLabel label = new JLabel("Welcome to SmartMed Patient System", JLabel.CENTER);
        frame.add(label);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
