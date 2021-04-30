import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame implements ActionListener {
	
	    private Container container;
	    private JLabel title;
	    private JLabel firstNameLabel;
	    private JTextField firstNameTextField;
	    private JLabel dateOfBirthLabel;
	    private JComboBox day;
	    private JComboBox month;
	    private JComboBox year;
	    private JButton submitButton;
	    private JButton resetButton;
	
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
	                "2019", "2020", "2021" };
	        
	        public void RegistrationForm() {
	        	
	        }
	        
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
