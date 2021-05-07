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
	    JLabel userLabel = new JLabel("USERNAME/EMAIL");
	    JLabel passwordLabel = new JLabel("PASSWORD");
	    JTextField userTextField = new JTextField();
	    JPasswordField passwordField = new JPasswordField();
	    JButton loginButton = new JButton("LOGIN");
	    JButton resetButton = new JButton("RESET");
	    JButton registerButton = new JButton("REGISTER?");
	    JCheckBox showPassword = new JCheckBox("Show Password");


	    public LoginFrame() {
	    	this.dbHelper = new DBHelper();
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
	        userLabel.setBounds(25, 150, 1000, 30);
	        passwordLabel.setBounds(25, 220, 100, 30);
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
	    
	    private boolean isLoginInfoCorrect(String username, String password) {
	    	
	    	Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#$%^&-+=()])(?=\\S+$).{8,20}$");
	    	Matcher passwordMatcher = passwordPattern.matcher(password);
	    	
	    	Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
	    	Matcher emailMatcher = emailPattern.matcher(username);
	    	
	    	Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_-]{3,15}$");
	    	Matcher usernameMatcher = usernamePattern.matcher(username);
	    	
	    	boolean usernameMatcherFound = usernameMatcher.find();
	    	boolean emailMatcherFound = emailMatcher.find();
	    	boolean passwordMatcherFound = passwordMatcher.find();
	    	
	    	if((usernameMatcherFound || emailMatcherFound) && passwordMatcherFound) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }
	    
	    //TO DO
	    private boolean checkIfCredentialsMatchInDB(String username,String Password) {
	    	return false; 
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == loginButton) {
	            String userText;
	            String passwordText;
	            userText = userTextField.getText();
	            passwordText = passwordField.getText();
	            if (this.isLoginInfoCorrect(userText, passwordText)) {
	                JOptionPane.showMessageDialog(this, "Login Successful");
	                this.dbHelper.checkLoginUser(userText,passwordText);
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid Username/E-mail or Password");
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
	        	this.dispose();
	        	RegistrationFrame registerFrame = new RegistrationFrame();
	        	registerFrame.setVisible(true);
	        }
	    }
}
