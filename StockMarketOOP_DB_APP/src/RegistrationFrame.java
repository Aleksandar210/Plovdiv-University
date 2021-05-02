import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame implements ActionListener {
		private DBHelper dbHelper;
		private HashMap<String,ArrayList<String>> countriesAndCities;
		private StringBuilder sb;
		// Components of the Form
	    private Container c;
	    private JLabel title;
	    private JLabel name;
	    private JTextField tname;
	    private JLabel emailLabel;
	    private JTextField emailTextField;
	    private JLabel usernameLabel;
	    private JTextField usernameTextField;
	    private JLabel passwordLabel;
	    private JPasswordField passwordField;
	    private JLabel mno;
	    private JComboBox countries;
	    private JLabel gender;
	    public JComboBox city;
	    private ButtonGroup gengp;
	    private JLabel dob;
	    private JComboBox date;
	    private JComboBox month;
	    private JComboBox year;
	    private JLabel add;
	    private JTextArea tadd;
	    private JCheckBox term;
	    private JButton sub;
	    private JButton reset;
	    private JButton loginButton;
	    private JTextArea tout;
	    private JLabel res;
	    private JTextArea resadd;
	  
	    private String dates[]
	        = { "1", "2", "3", "4", "5",
	            "6", "7", "8", "9", "10",
	            "11", "12", "13", "14", "15",
	            "16", "17", "18", "19", "20",
	            "21", "22", "23", "24", "25",
	            "26", "27", "28", "29", "30",
	            "31" };
	    private String months[]
	        = { "Jan", "feb", "Mar", "Apr",
	            "May", "Jun", "July", "Aug",
	            "Sup", "Oct", "Nov", "Dec" };
	    private String years[]
	        = { "1995", "1996", "1997", "1998",
	            "1999", "2000", "2001", "2002",
	            "2003", "2004", "2005", "2006",
	            "2007", "2008", "2009", "2010",
	            "2011", "2012", "2013", "2014",
	            "2015", "2016", "2017", "2018",
	            "2019" };
	  
	    // constructor, to initialize the components
	    // with default values.
	    public RegistrationFrame()
	    {
	    	this.sb = new StringBuilder();
	    	this.dbHelper = new DBHelper();
	    	this.countriesAndCities = this.dbHelper.getCountriesWithCities();
	    	
	        setTitle("Stock Market Plovdvi University");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	  
	        c = getContentPane();
	        c.setLayout(null);
	  
	        title = new JLabel("Registration Form");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(300, 30);
	        c.add(title);
	  
	        name = new JLabel("Name");
	        name.setFont(new Font("Arial", Font.PLAIN, 20));
	        name.setSize(100, 20);
	        name.setLocation(100, 100);
	        c.add(name);
	  
	        tname = new JTextField();
	        tname.setFont(new Font("Arial", Font.PLAIN, 15));
	        tname.setSize(190, 20);
	        tname.setLocation(200, 100);
	        c.add(tname);
	  
	        mno = new JLabel("Country");
	        mno.setFont(new Font("Arial", Font.PLAIN, 20));
	        mno.setSize(100, 20);
	        mno.setLocation(100, 150);
	        c.add(mno);
	  
	        countries = new JComboBox(countriesAndCities.keySet().toArray());
	        countries.setFont(new Font("Arial", Font.PLAIN, 15));
	        countries.setSize(150, 20);
	        countries.setLocation(200, 150);
	        countries.addActionListener(countriesListener);
	        c.add(countries);
	  
	        gender = new JLabel("City");
	        gender.setFont(new Font("Arial", Font.PLAIN, 20));
	        gender.setSize(100, 20);
	        gender.setLocation(100, 200);
	        c.add(gender);
	        
	        // may not be needed
	        city =new JComboBox(countriesAndCities.get(countries.getSelectedItem()).toArray());
	        city.setFont(new Font("Arial", Font.PLAIN, 15));
	        city.setSize(75, 20);
	        city.setLocation(200, 200);
	        c.add(city);
	        
	        // may not be needed
	        /*female = new JRadioButton("Female");
	        female.setFont(new Font("Arial", Font.PLAIN, 15));
	        female.setSelected(false);
	        female.setSize(80, 20);
	        female.setLocation(275, 200);
	        c.add(female);
	  
	        gengp = new ButtonGroup();
	        gengp.add(male);
	        gengp.add(female);
	        */
	  
	        dob = new JLabel("Date of birth");
	        dob.setFont(new Font("Arial", Font.PLAIN, 20));
	        dob.setSize(1000, 20);
	        dob.setLocation(50, 250);
	        c.add(dob);
	  
	        date = new JComboBox(dates);
	        date.setFont(new Font("Arial", Font.PLAIN, 15));
	        date.setSize(50, 20);
	        date.setLocation(200, 250);
	        c.add(date);
	  
	        month = new JComboBox(months);
	        month.setFont(new Font("Arial", Font.PLAIN, 15));
	        month.setSize(60, 20);
	        month.setLocation(250, 250);
	        c.add(month);
	  
	        year = new JComboBox(years);
	        year.setFont(new Font("Arial", Font.PLAIN, 15));
	        year.setSize(60, 20);
	        year.setLocation(320, 250);
	        c.add(year);
	  
	        emailLabel = new JLabel("E-Mail");
	        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        emailLabel.setSize(100, 20);
	        emailLabel.setLocation(100, 300);
	        c.add(emailLabel);
	        
	        emailTextField = new JTextField();
	        emailTextField.setFont(new Font("Arial", Font.PLAIN, 15));
	        emailTextField.setSize(200, 20);
	        emailTextField.setLocation(200, 300);
	        c.add(emailTextField);
	        
	        usernameLabel = new JLabel("Username");
	        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        usernameLabel.setSize(100, 20);
	        usernameLabel.setLocation(100, 350);
	        c.add(usernameLabel);
	        
	        usernameTextField = new JTextField();
	        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
	        usernameTextField.setSize(200, 20);
	        usernameTextField.setLocation(200, 350);
	        c.add(usernameTextField);
	        
	        passwordLabel = new JLabel("Password");
	        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        passwordLabel.setSize(100, 20);
	        passwordLabel.setLocation(100, 400);
	        c.add(passwordLabel);
	        
	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
	        passwordField.setSize(200, 20);
	        passwordField.setLocation(200, 400);
	        c.add(passwordField);
	  
	  
	        sub = new JButton("Submit");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(100, 20);
	        sub.setLocation(75, 500);
	        sub.addActionListener(this);
	        c.add(sub);
	  
	        reset = new JButton("Reset");
	        reset.setFont(new Font("Arial", Font.PLAIN, 15));
	        reset.setSize(100, 20);
	        reset.setLocation(200, 500);
	        reset.addActionListener(this);
	        c.add(reset);
	        
	        loginButton = new JButton("Login?");
	        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
	        loginButton.setSize(100, 20);
	        loginButton.setLocation(325, 500);
	        loginButton.addActionListener(this);
	        c.add(loginButton);
	  
	        
	        tout = new JTextArea();
	        tout.setFont(new Font("Arial", Font.PLAIN, 15));
	        tout.setSize(300, 400);
	        tout.setLocation(500, 100);
	        tout.setLineWrap(true);
	        tout.setEditable(false);
	        c.add(tout);
	  
	        res = new JLabel("");
	        res.setFont(new Font("Arial", Font.PLAIN, 20));
	        res.setSize(500, 25);
	        res.setLocation(100, 500);
	        c.add(res);
	  
	        resadd = new JTextArea();
	        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
	        resadd.setSize(200, 75);
	        resadd.setLocation(580, 175);
	        resadd.setLineWrap(true);
	        c.add(resadd);
	  
	        setVisible(true);
	    }
	    
	    private String passwordValditaion(String password) {
	    	
	    	Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#$%^&-+=()])(?=\\S+$).{8,20}$");
	    	Matcher passwordMatcher = passwordPattern.matcher(password);
	    	
	    	if(passwordMatcher.find()) {
	    		return "Correct";
	    	}else {
	    		return "Not Correct";
	    	}
	    }
	    
	    private String emailValidation(String email) {
	    	Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
	    	Matcher emailMatcher = emailPattern.matcher(email);
	    	
	    	if(emailMatcher.find()) {
	    		return "Correct";
	    	}else {
	    		return "Not Correct";
	    	}
	    }
	    
	    private String usernameValidation(String username) {
	    	Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
	    	Matcher emailMatcher = emailPattern.matcher(username);
	    	
	    	if(emailMatcher.find()) {
	    		return "Correct";
	    	}else {
	    		return "Not Correct";
	    	}
	    }
	    
	    private String nameValidation(String names) {
	    	Pattern namePattern = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+");
	    	Matcher nameMatcher = namePattern.matcher(names);
	    	
	    	if(nameMatcher.find()) {
	    		return "Correct";
	    	}else {
	    		return "Not Correct";
	    	}
	    }
	    
	    // method actionPerformed()
	    // to get the action performed
	    // by the user and act accordingly
	    public void actionPerformed(ActionEvent e)
	    {
	        if (e.getSource() == sub) {
	        	
	        	if(!this.sb.isEmpty()) {
	        		this.sb.delete(0, this.sb.length());
	        	}
	        	
	        	String passwordString = new String(this.passwordField.getPassword());
	        	String passwordValidationResult = this.passwordValditaion(passwordString);
	        	String usernameValidationResult = this.usernameValidation(this.usernameTextField.getText());
	        	String emailValidationResult = this.emailValidation(this.emailTextField.getText());
	        	String namesValidationResult = this.nameValidation(this.tname.getText());
	        	
	        	if(passwordValidationResult.equalsIgnoreCase("Correct") &&
	        			usernameValidationResult.equalsIgnoreCase("Correct") &&
	        			emailValidationResult.equalsIgnoreCase("Correct") &&
	        			namesValidationResult.equalsIgnoreCase("Correct")) {
	        		// TO DO FINISH THIS
	        	}
	        	
	           /* if (term.isSelected()) {
	                String data1;
	                String data
	                    = "Name : "
	                      + tname.getText() + "\n"
	                      + "Mobile : ";
	                      //+ tmno.getText() + "\n";
	                if (male.isSelected())
	                    data1 = "Gender : Male"
	                            + "\n";
	                else
	                    data1 = "Gender : Female"
	                            + "\n";
	                String data2
	                    = "DOB : "
	                      + (String)date.getSelectedItem()
	                      + "/" + (String)month.getSelectedItem()
	                      + "/" + (String)year.getSelectedItem()
	                      + "\n";
	  
	                String data3 = "Address : " + tadd.getText();
	                tout.setText(data + data1 + data2 + data3);*/
	                tout.setEditable(false);
	            } else if (e.getSource() == reset) {
		            String def = "";
		            this.tname.setText(def);
		            this.tadd.setText(def);
		            this.countries.setSelectedIndex(0);
		            this.res.setText(def);
		            tout.setText(def);
		            term.setSelected(false);
		            date.setSelectedIndex(0);
		            month.setSelectedIndex(0);
		            year.setSelectedIndex(0);
		            this.resadd.setText(def);
		            this.passwordField.setText(def);
		            this.emailTextField.setText(def);
		            this.usernameTextField.setText(def);
		        }else if(e.getSource() == loginButton) {
		        	this.dispose();
		        	LoginFrame login = new LoginFrame();
		        	login.setVisible(true);      	
		        }else {
	                tout.setText("");
	                resadd.setText("");
	                res.setText("Please accept the"
	                            + " terms & conditions..");
	        }
	  
	       
	        
	    }
	    
	    ActionListener countriesListener = new ActionListener() {
	    	private DefaultComboBoxModel model;
			@Override
			public void actionPerformed(ActionEvent e) {
				
			        String countrySelected = (String)countries.getSelectedItem();
			        model = new DefaultComboBoxModel(countriesAndCities.get(countrySelected).toArray());
			        city.setModel(model);
				
			}
	    	
	    };

}
