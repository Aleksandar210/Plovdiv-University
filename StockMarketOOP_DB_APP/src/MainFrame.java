import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {
	 JTabbedPane tab = new JTabbedPane();
	 
		 
		 JTable table = new JTable();
		 JTable product_table = new JTable();
		 JTable sales_table = new JTable();
		 
		 JScrollPane scroller = new JScrollPane(table);
		 JScrollPane product_scroller = new JScrollPane(product_table);
		 JScrollPane sales_scroller = new JScrollPane(sales_table);

		 //pane users
		 JPanel users = new JPanel();
		 JPanel users_up = new JPanel();
		 JPanel users_mid = new JPanel();
		 JPanel users_down = new JPanel();
		 
		 //pane products
		 JPanel products = new JPanel();
		 JPanel products_top = new JPanel();
		 JPanel products_mid = new JPanel();
		 JPanel products_down = new JPanel();
		 
		 //pane sales
		 JPanel sales = new JPanel();
		 JPanel sales_top = new JPanel();
		 JPanel sales_mid = new JPanel();
		 JPanel sales_down = new JPanel();
		 
		 //user fields
		 JLabel user_first_name = new JLabel("First Name:");
		 JLabel user_last_name = new JLabel("Last Name:");
		 JLabel user_age = new JLabel("Age:");
		 JLabel user_city = new JLabel("City");
		 JLabel user_street = new JLabel("Street");
		 
		 JTextField user_first_name_textF = new JTextField();
		 JTextField user_last_name_textF = new JTextField();
		 JTextField user_age_textF = new JTextField();
		 JTextField user_city_textF = new JTextField();
		 JTextField user_street_textF = new JTextField();
		 
		 JButton create_user = new JButton("Create");
		 JButton edit_user = new JButton("Edit");
		 JButton delete_user = new JButton("Delete");
		 JButton search_user = new JButton("Search");
		 // end of user fields
		 
		 //product fields
		 
		 JLabel product_quantity = new JLabel("Quantity:");
		 JLabel product_price_delivery = new JLabel("Price(delivery):");
		 JLabel product_price_sale = new JLabel("Price(sale):");
		 
		 JTextField product_quantity_textF = new JTextField();
		 JTextField product_price_delivery_textF = new JTextField();
		 JTextField product_price_sale_textF = new JTextField();
		 
		 JButton create_product = new JButton("Create");
		 JButton edit_product = new JButton("Edit");
		 JButton delete_product = new JButton("Delete");
		 JButton search_product = new JButton("Search");
		 
		 //end of product fields
		 
		 //sales fields
		 
		 JLabel sales_product = new JLabel("Product:");
		 JLabel sales_product_quantity = new JLabel("Product quantity:");
		 JLabel sales_profit = new JLabel("Profit:");
		 JLabel sales_buyer = new JLabel("Buyer:");
		 JLabel sales_seller = new JLabel("Seller:");
		 
		 JTextField sales_product_textF = new JTextField();
		 JTextField sales_product_quantity_textF = new JTextField();
		 JTextField sales_profit_textF = new JTextField();
		 JTextField sales_buyer_textF = new JTextField();
		 JTextField sales_seller_textF = new JTextField();
		 
		 JButton create_sale = new JButton("Create");
		 JButton edit_sale = new JButton("Edit");
		 JButton delete_sale = new JButton("Delete");
		 JButton search_sale = new JButton("Search");
		 
		 //end of sales fields
		 
		 public MainFrame() {
			 this.setSize(500, 600);
			 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			 //this.setLayout(new GridLayout(3, 1));
			 
			 //Users Panel and shit 
			 tab.add(users, "Users");
			 users_up.setLayout(new GridLayout(5, 2));
			 
			 users_up.add(user_first_name);
			 users_up.add(user_first_name_textF);
			 
			 users_up.add(user_last_name);
			 users_up.add(user_last_name_textF);
			 
			 users_up.add(user_age);
			 users_up.add(user_age_textF);
			 
			 users_up.add(user_city);
			 users_up.add(user_city_textF);
			 
			 users_up.add(user_street);
			 users_up.add(user_street_textF);
			 
			 users_mid.add(create_user);
			 users_mid.add(edit_user);
			 users_mid.add(delete_user);
			 users_mid.add(search_user);
			 
			 users_down.add(scroller);
			 scroller.setPreferredSize(new Dimension(450,160));
			 
			 //fix this with dbHelper see what is inside the getAllData() method.
			 //table.setModel(DBHelper.getAllData());
			 
			 users.add(users_up);
			 users.add(users_mid);
			 users.add(users_down);
			 //End of users panel and shit
			 
			 //Products and shit
			 tab.add(products, "Products");
			 products_top.setLayout(new GridLayout(5, 2));
			 
			 products_top.add(product_quantity);
			 products_top.add(product_quantity_textF);
			 
			 products_top.add(product_price_delivery);
			 products_top.add(product_price_delivery_textF);
			 
			 products_top.add(product_price_sale);
			 products_top.add(product_price_sale_textF);
			 
			 products_mid.add(create_product);
			 products_mid.add(edit_product);
			 products_mid.add(delete_product);
			 products_mid.add(search_product);
			 
			 products_down.add(product_scroller);
			 product_scroller.setPreferredSize(new Dimension(450,160));
			 
			 //product_table.setModel(DBHelper.getAllDataProducts());
			 
			 products.add(products_top);
			 products.add(products_mid);
			 products.add(products_down);
			 //End of products and shit
			 
			 //Sales and shit
			 tab.add(sales, "Sales");
			 sales_top.setLayout(new GridLayout(5, 2));
			 
			 sales_top.add(sales_product);
			 sales_top.add(sales_product_textF);
			 
			 sales_top.add(sales_product_quantity);
			 sales_top.add(sales_product_quantity_textF);
			 
			 sales_top.add(sales_product_quantity);
			 sales_top.add(sales_product_quantity_textF);
			 
			 sales_top.add(sales_profit);
			 sales_top.add(sales_profit_textF);
			 
			 sales_top.add(sales_seller);
			 sales_top.add(sales_seller_textF);
			 
			 sales_top.add(sales_buyer);
			 sales_top.add(sales_buyer_textF);
			 
			 sales_mid.add(create_sale);
			 sales_mid.add(edit_sale);
			 sales_mid.add(delete_sale);
			 sales_mid.add(search_sale);
			 
			 sales_down.add(sales_scroller);
			 sales_scroller.setPreferredSize(new Dimension(450,160));
			 
			 //fix this by looking what is inside the getAllDataSales() method and implementing it in DBHelper
			 //sales_table.setModel(DBHelper.getAllDataSales());
			 
			 sales.add(sales_top);
			 sales.add(sales_mid);
			 sales.add(sales_down);
			 
			 //End of sales and shit
			 
			 
			 this.add(tab);
			 
			 this.setVisible(true);
		 }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
