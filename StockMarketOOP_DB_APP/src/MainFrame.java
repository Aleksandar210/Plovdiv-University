import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DBHelper dbHelper;
	 JTabbedPane tab = new JTabbedPane();
	 
	 String[] productCategories;
		 
		 JTable table = new JTable();
		 JTable product_table = new JTable();
		 JTable sales_table = new JTable();
		 
		 JScrollPane scroller = new JScrollPane(table);
		 JScrollPane product_scroller = new JScrollPane(product_table);
		 JScrollPane sales_scroller = new JScrollPane(sales_table);

		 
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
		 
		 
		 //product fields
		 
		 private TableRowSorter<TableModel> rowSorter;
         
		 
		 JLabel product_quantity = new JLabel("Quantity:");
		 JLabel product_price_delivery = new JLabel("Price(delivery):");
		 JLabel product_price_sale = new JLabel("Price(sale):");
		 JLabel product_Product_Name = new JLabel("Product name:");
		 JLabel product_Product_CategoryOptionsLabel = new JLabel("Category:");
		 
		 
		 JTextField product_quantity_textF = new JTextField();
		 JTextField product_price_delivery_textF = new JTextField();
		 JTextField product_price_sale_textF = new JTextField();
		 JTextField product_Product_Name_textF = new JTextField();
		 JComboBox product_Product_CategoryOptions;
		 
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
		 
		 JButton search_sale = new JButton("Search");
		 
		 //end of sales fields
		 
		 public MainFrame() {
			 productCategories = new String[] {"Electronics","Food","Clothes","Vehicle","Cryptocurrency","Housing"};
			 product_Product_CategoryOptions = new JComboBox<String>(productCategories);
			 this.dbHelper = new DBHelper();
			 //this.setSize(500, 600);
			 setTitle("Stock Market Plovdvi University");
		        setBounds(300, 90, 900, 600);
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		        setResizable(false);
			 //this.setLayout(new GridLayout(3, 1));
			 
			 //Users Panel and shit 
			
			 //Products and shit
			 tab.add(products, "Products");
			 products_top.setLayout(new GridLayout(5, 2));
			 
			
			 
			 products_top.add(product_price_delivery);
			 products_top.add(product_price_delivery_textF);
			 
			 products_top.add(product_price_sale);
			 products_top.add(product_price_sale_textF);
			 
			 products_top.add(product_Product_Name);
			 products_top.add(product_Product_Name_textF);
			 
			 products_top.add(product_Product_CategoryOptionsLabel);
			 products_top.add(product_Product_CategoryOptions);
			 
			 create_product.addActionListener(actionListenerCreateButton);
			 delete_product.addActionListener(actionListenerDeleteButton);
			 edit_product.addActionListener(new EditProductAction());
			 search_product.addActionListener(new SearchProductAction());
			 
			 products_mid.add(create_product);
			 products_mid.add(search_product);
			 products_mid.add(delete_product);
			 products_mid.add(edit_product);
			
			 products_down.add(product_scroller);
			 product_scroller.setPreferredSize(new Dimension(450,160));
			 
			 product_table.setModel(this.dbHelper.getAllDataProducts());
			 
			 
			 products.add(products_top);
			 products.add(products_mid);
			 products.add(products_down);
			 //End of products and shit
			 rowSorter = new TableRowSorter<>(product_table.getModel());
			 //Sales and shit
			 tab.add(sales, "Sales");
			 sales_top.setLayout(new GridLayout(5, 2));
			 
			 sales_top.add(sales_product);
			 sales_top.add(sales_product_textF);
			 		 
			
			 sales_top.add(sales_seller);
			 sales_top.add(sales_seller_textF);
			 
			
			 sales_mid.add(search_sale);
			 
			 sales_down.add(sales_scroller);
			 sales_scroller.setPreferredSize(new Dimension(450,160));
			 
			 //fix this by looking what is inside the getAllDataSales() method and implementing it in DBHelper
			 sales_table.setModel(this.dbHelper.getAllDataSales());
			 
			 sales.add(sales_top);
			 sales.add(sales_mid);
			 sales.add(sales_down);
			 
			 //End of sales and shit
			 
			 
			 this.add(tab);
			 
			 this.setVisible(true);
		 }
		 
		 
		private class EditProductAction implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
				
					  int row = product_table.getSelectedRow();
				       int id = (int) product_table.getModel().getValueAt(row, 0);
					
					String[] productsDataEdited = new String[] {product_price_delivery_textF.getText()
							,product_price_sale_textF.getText()
							,product_Product_Name_textF.getText()
							,(String) product_Product_CategoryOptions.getSelectedItem()};
					dbHelper.editProducts(productsDataEdited,id);
					
				product_table.setModel(dbHelper.getAllDataProducts());
				}
			 }
		
		
		
		private class SearchProductAction implements ActionListener{
			 
				@Override
				public void actionPerformed(ActionEvent e) {
				
					String[] productsDataSearchBy = new String[] {product_price_delivery_textF.getText()
							,product_price_sale_textF.getText()
							,product_Product_Name_textF.getText()
							,(String) product_Product_CategoryOptions.getSelectedItem()};
					
				try {
					product_table.setModel(new MyModel(dbHelper.searchProducts(productsDataSearchBy)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 }
		 
		 
	
		 
		 ActionListener actionListenerCreateButton = new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			       String[] productDataGivenCreate = new String[4];
			       
			       productDataGivenCreate[0] = product_Product_Name_textF.getText();
			       productDataGivenCreate[1] = product_price_delivery_textF.getText();
			       productDataGivenCreate[2] = product_price_sale_textF.getText();
			       productDataGivenCreate[3] = (String) product_Product_CategoryOptions.getSelectedItem();
			       
			       dbHelper.createProduct(productDataGivenCreate);
			       
			       product_table.setModel(dbHelper.getAllDataProducts());
			    }
			};
			
			ActionListener actionListenerDeleteButton = new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			       int row = product_table.getSelectedRow();
			       int id = (int) product_table.getModel().getValueAt(row, 0);
			       
			       dbHelper.deleteProduct(id);
			       
			       product_table.setModel(dbHelper.getAllDataProducts());
			    }
			};
			
			

			private String removeLastChar(String s) {
			    if (s == null || s.length() == 0) {
			        return s;
			    }
			    return s.substring(0, s.length()-1);
			}
		
}
