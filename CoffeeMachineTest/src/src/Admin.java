
package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 *
 * @author soulemane
 */
public class Admin extends JFrame implements	ListSelectionListener{
   //Global variables
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    
    //Dependent classes
    Alert classAlert;
    DBread db;
    DBwrite dbWrite;

    public Admin( DBread dbRead, DBwrite dbWrite, Alert alert){
        this.db= dbRead;
        this.dbWrite = dbWrite;
        this.classAlert = alert;
        
        startGUI();
        System.out.println("Admin called");
    }
    
    private void startGUI() {
    //External class
    //DBread db = dbRead;
	setTitle( "Admnistrative panel" );
	setBackground( Color.gray );   
    setSize(new Dimension(550, 350));
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    
    //Buttons
    JButton btnDisplay = new JButton("Display");
    
    //Setting panel top
    topPanel = new JPanel();
    topPanel.setLayout( new BorderLayout() );
    getContentPane().add( topPanel );
        
    // create columns names
    String columnNames[] = { "", "Water", "Milk", "Coffe.P", "Expresso.P" };
    // create some data
    String [][]dataValues = new String [5][5];
        
    //Initial values   
    //dataValues[0][0] = "";
    dataValues[0][0] = "Nor. coffee without milk";
    dataValues[1][0] = "Nor. coffee with milk";
    dataValues[2][0] = "Cappuccino";
    dataValues[3][0] = "Milk coffee";
    dataValues[4][0] = "Max quantity";
        
    //normal coffee without milk
    dataValues[0][1] = String.valueOf(db.getNcwom_water());
    dataValues[0][2] = String.valueOf(db.getNcwom_milk());
    dataValues[0][3] = String.valueOf(db.getNcwom_coffee());
    dataValues[0][4] = String.valueOf(db.getNcwom_espresso());
        
    //normal coffee with milk
    dataValues[1][1] = String.valueOf(db.getNcwm_water());
    dataValues[1][2] = String.valueOf(db.getNcwm_milk());
    dataValues[1][3] = String.valueOf(db.getNcwm_coffee());
    dataValues[1][4] = String.valueOf(db.getNcwm_espresso());
        
    //cappuccino
    dataValues[2][1] = String.valueOf(db.getCapu_water());
    dataValues[2][2] = String.valueOf(db.getCapu_milk());
    dataValues[2][3] = String.valueOf(db.getCapu_coffee());
    dataValues[2][4] = String.valueOf(db.getCapu_espresso());
        
    //milk cofee
    dataValues[3][1] = String.valueOf(db.getCof_water());
    dataValues[3][2] = String.valueOf(db.getCof_milk());
    dataValues[3][3] = String.valueOf(db.getCof_coffee());
    dataValues[3][4] = String.valueOf(db.getCof_espresso());
        
    //totals
    dataValues[4][1] = String.valueOf(db.getTotal_water());
    dataValues[4][2] = String.valueOf(db.getTotal_milk());
    dataValues[4][3] = String.valueOf(db.getTotal_coffee());
    dataValues[4][4] = String.valueOf(db.getTotal_espresso());
    
    
    // create a new table instance
	  table = new JTable( dataValues, columnNames );
      
    // Handle the listener
	  ListSelectionModel selectionModel = table.getSelectionModel();
	  selectionModel.addListSelectionListener( this);
                
    // add the table to a scrolling pane
    scrollPane = new JScrollPane( table );
    topPanel.add( scrollPane, BorderLayout.CENTER );
    topPanel.add( btnDisplay, BorderLayout.SOUTH );
    
    //Setting the admin button event listener 
        btnDisplay.addActionListener(e->{
             EventQueue.invokeLater(() -> {
             Display gui = new Display();
             gui.setVisible(true);
             this.dispose();
             });
        });
    
    //test
        /*
    System.out.println("ncwom :"+ct_norm_cof_without_milk);
    System.out.println("ncwm :"+ct_norm_cof_with_milk);
    System.out.println("cap :"+ct_cappuccino);
    System.out.println("mc :"+ct_milk_coffee);
            */
    }
     
    @Override
     public void valueChanged(ListSelectionEvent event){
         
         //See if this is a valid table selection
         if(event.getSource() == table.getSelectionModel() && event.getFirstIndex() >=0){
             
             //Get the data model for this table
             TableModel model = (TableModel)table.getModel();
             
             //Determine the selected item
             String selectedValue =(String)model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
             //model.setValueAt("0", table.getSelectedRow(), table.getSelectedColumn());
             //DBread db = new DBread();
             double value = Double.valueOf(selectedValue);
             //DBwrite dbwrite = new DBwrite();
             int selectedRow = table.getSelectedRow();
             int selectedCol = table.getSelectedColumn();
             
             //Normal coffee without milk
             if(selectedRow == 0 && selectedCol==1){
                 this.dbWrite.setNcwom_water(value);
             }
             else if(selectedRow == 0 && selectedCol==2){
                 this.dbWrite.setNcwom_milk(value);
             }
             else if(selectedRow == 0 && selectedCol==3){
                 this.dbWrite.setNcwom_coffee(value);
             }
             else if(selectedRow == 0 && selectedCol==4){
                 this.dbWrite.setNcwom_espresso(value);
             }
             
             //Normal coffee with milk
             if(selectedRow == 1 && selectedCol==1){
                 this.dbWrite.setNcwm_water(value);
             }
             else if(selectedRow == 1 && selectedCol==2){
                 this.dbWrite.setNcwm_milk(value);
             }
             else if(selectedRow == 1 && selectedCol==3){
                 this.dbWrite.setNcwm_coffee(value);
             }
             else if(selectedRow == 1 && selectedCol==4){
                 this.dbWrite.setNcwm_espresso(value);
             }
             
             //Cappuccino
            if(selectedRow == 2 && selectedCol==1){
                 this.dbWrite.setCapu_water(value);
             }
             else if(selectedRow == 2 && selectedCol==2){
                 this.dbWrite.setCapu_milk(value);
             }
             else if(selectedRow == 2 && selectedCol==3){
                 this.dbWrite.setCapu_coffee(value);
             }
             else if(selectedRow == 2 && selectedCol==4){
                 this.dbWrite.setCapu_espresso(value);
             }
            
             //Milk Coffee
            if(selectedRow == 3 && selectedCol==1){
                 this.dbWrite.setCof_water(value);
             }
             else if(selectedRow == 3 && selectedCol==2){
                 this.dbWrite.setCof_milk(value);
             }
             else if(selectedRow == 3 && selectedCol==3){
                 this.dbWrite.setCof_coffee(value);
             }
             else if(selectedRow == 3 && selectedCol==4){
                 this.dbWrite.setCof_espresso(value);
             }
              
             //Total quantity
            if(selectedRow == 4 && selectedCol==1){
                 this.dbWrite.setTotal_water(value);
             }
             else if(selectedRow == 4 && selectedCol==2){
                 this.dbWrite.setTotal_milk(value);
             }
             else if(selectedRow == 4 && selectedCol==3){
                 this.dbWrite.setTotal_coffee(value);
             }
             else if(selectedRow == 4 && selectedCol==4){
                 this.dbWrite.setTotal_espresso(value);
             }
            
            //Clear the alert message
             classAlert.setAlertAdmin(false);
            // showMessageDialog(null, "new value is "+ string);
             System.out.println( "Value selected = " + value );
             System.out.println( "row selected = " + selectedRow );
             System.out.println( "col selected = " + selectedCol );
         }
     }
    
      
}
