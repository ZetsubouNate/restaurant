package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SignInView extends JFrame {

    private JPanel contentPane;
    private JTextField usernameField;
    private JTextField passField;
    private JButton signUpButton;
    private JButton loginButton;

    public SignInView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 488, 364);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Food Ordering");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(69, 11, 329, 26);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setBounds(69, 89, 78, 26);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(69, 162, 78, 26);
        contentPane.add(lblNewLabel_1_1);

        signUpButton = new JButton("SignUp");
        signUpButton.setBounds(339, 263, 123, 34);
        contentPane.add(signUpButton);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginButton.setBounds(163, 259, 147, 43);
        contentPane.add(loginButton);

        usernameField = new JTextField();
        usernameField.setBounds(163, 89, 221, 26);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passField = new JTextField();
        passField.setColumns(10);
        passField.setBounds(163, 162, 221, 26);
        contentPane.add(passField);
    }

    public void showMessage(String result) {
        JOptionPane.showMessageDialog(this, result, "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
}
