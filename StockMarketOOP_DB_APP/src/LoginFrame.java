import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
		DBHelper dbHelper =null;
	    Container container = getContentPane();
	    JLabel userLabel = new JLabel("USERNAME");
	    JLabel passwordLabel = new JLabel("PASSWORD");
	    JTextField userTextField = new JTextField();
	    JPasswordField passwordField = new JPasswordField();
	    JButton loginButton = new JButton("LOGIN");
	    JButton resetButton = new JButton("RESET");
	    JButton registerButton = new JButton("REGISTER?");
	    JCheckBox showPassword = new JCheckBox("Show Password");


	    public LoginFrame(DBHelper dbHelper) {
	    	this.dbHelper = dbHelper;
	        setLayoutManager();
	        setLocationAndSize();
	        addComponentsToContainer();
	        addActionEvent();
	        this.setTitle("Login Form");
	        this.container.setLayout(null);
	        this.setVisible(true);
	        this.setBounds(10, 10, 370, 600);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(false);
	        this.setLocationRelativeTo(null);
	    }

	    public void setLayoutManager() {
	        container.setLayout(null);
	    }

	    public void setLocationAndSize() {
	        userLabel.setBounds(50, 150, 100, 30);
	        passwordLabel.setBounds(50, 220, 100, 30);
	        userTextField.setBounds(150, 150, 150, 30);
	        passwordField.setBounds(150, 220, 150, 30);
	        showPassword.setBounds(150, 250, 150, 30);
	        loginButton.setBounds(25, 300, 100, 30);
	        resetButton.setBounds(225, 300, 100, 30);
	        registerButton.setBounds(125, 300, 100, 30);

	    }

	    public void addComponentsToContainer() {
	        container.add(userLabel);
	        container.add(passwordLabel);
	        container.add(userTextField);
	        container.add(passwordField);
	        container.add(showPassword);
	        container.add(loginButton);
	        container.add(resetButton);
	        container.add(registerButton);
	    }

	    public void addActionEvent() {
	        loginButton.addActionListener(this);
	        resetButton.addActionListener(this);
	        showPassword.addActionListener(this);
	        registerButton.addActionListener(this);
	    }
	    
	    private int isLoginInfoCorrect(String username, String password) {
	    	Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
	    	Matcher passwordMatcher = passwordPattern.matcher(password);
	    	
	    	Pattern emailPattern = Pattern.compile("^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$");
	    	Matcher emailMatcher = emailPattern.matcher(username);
	    	
	    	Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_-]{3,15}$");
	    	Matcher usernameMatcher = usernamePattern.matcher(username);
	    	
	    	//if()
	    	return 4;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == loginButton) {
	            String userText;
	            String passwordText;
	            userText = userTextField.getText();
	            passwordText = passwordField.getText();
	            //do method with logic on login
	            if (userText.equalsIgnoreCase("alex")) {
	                JOptionPane.showMessageDialog(this, "Login Successful");
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
	            }

	        }
	        if (e.getSource() == resetButton) {
	            userTextField.setText("");
	            passwordField.setText("");
	        }
	        if (e.getSource() == showPassword) {
	            if (showPassword.isSelected()) {
	                passwordField.setEchoChar((char) 0);
	            } else {
	                passwordField.setEchoChar('*');
	            }


	        }
	        
	        if(e.getSource() == registerButton) {
	        	
	        }
	    }
}
