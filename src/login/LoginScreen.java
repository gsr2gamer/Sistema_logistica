package login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public LoginScreen() {
        setTitle("Acesso principal");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel);

        JPanel loginPanel = createLoginPanel();
        cardPanel.add(loginPanel, "Acesso");

        MainScreenPanel mainScreenPanel = new MainScreenPanel();
        cardPanel.add(mainScreenPanel, "main");

        // Show the login panel initially
        cardLayout.show(cardPanel, "Acesso");
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel usernameLabel = new JLabel("Acesso:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Replace this with your actual login logic
                if (isValidLogin(username, password)) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Acesso permitido!");
                    cardLayout.show(cardPanel, "main"); // Switch to the main screen after successful login
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Senha invalida.");
                }
            }
        });

        return panel;
    }

    // Replace this with your actual login logic
    private boolean isValidLogin(String username, String password) {
        // For simplicity, let's hardcode a valid username and password
        String validUsername = "123";
        String validPassword = "123";

        return username.equals(validUsername) && password.equals(validPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}

class MainScreenPanel extends JPanel {
    public MainScreenPanel() {
        setLayout(new BorderLayout());
        JLabel mainLabel = new JLabel("Bem Vim ao sistema!");
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        add(mainLabel);
    }
}


