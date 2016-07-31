
package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author soulemane
 */
public class Display extends JFrame {

   
    public Display(){
        startGUI();
    }
    
     private void startGUI() {
         
        //Gui properties
        setTitle("Coffee Machine");
        setSize(new Dimension(650, 350));
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Dependent classes
        Alert classAlert= new Alert();
        DBread dbRead= new DBread();
        DBwrite dbWrite= new DBwrite();
        Delivery classDelivery= new Delivery(dbRead,dbWrite);
        Threshold classThreshold = new Threshold(dbRead,classDelivery);
        
        
        //Panels
        JPanel panelMain = new JPanel();
        JPanel panelTop = new JPanel(new BorderLayout(0, 0));
        JPanel panelSelection = new JPanel(new BorderLayout());
        
        
        //Labels
        JLabel labelAlert = new JLabel("");
        
        //Buttons
        JButton btnAdmin = new JButton("Admin");
        JButton btnChoice1 = new JButton("Nor. Coffee without Milk");
        JButton btnChoice2 = new JButton("Nor. Coffee with Milk");
        JButton btnChoice3 = new JButton("Cappuccino");
        JButton btnChoice4 = new JButton("Milk Coffee");
        
        //Separator
        JSeparator separator = new JSeparator();

        //Setting the main panel
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        add(panelMain);
        
        panelTop.setMaximumSize(new Dimension(650, 0));
        

          labelAlert.setText(classAlert.getAlertText());
              
        //Setting the admin alert label
        labelAlert.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        panelTop.add(labelAlert);
        
        //Setting Admin button
        btnAdmin.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelTop.add(btnAdmin, BorderLayout.EAST);
        
        //Setting the admin button event listener 
        btnAdmin.addActionListener(e->{
             EventQueue.invokeLater(() -> {
             Admin admin = new Admin(dbRead, dbWrite,classAlert);
             admin.setVisible(true);
             this.dispose();
             //this.setVisible(false);
        });
        });
        
        //Setting the separator
        separator.setForeground(Color.gray);
        panelTop.add(separator, BorderLayout.SOUTH);
        
        //Adding top panel to main
        panelMain.add(panelTop);
        
        //Selection panel
        panelSelection.setBorder(BorderFactory.createEmptyBorder(1, 4, 10, 10));
        panelSelection.setLayout(new GridLayout(1,4, 10,10));

        //Setting selection buttons
        panelSelection.add(btnChoice1);
        panelSelection.add(btnChoice2);
        panelSelection.add(btnChoice3);
        panelSelection.add(btnChoice4);
        //event listener 
        btnChoice1.addActionListener(e->{
        
          classAlert.setAlertAdmin(classThreshold.checkThreshold("ncwom"));
          labelAlert.setText(classAlert.getAlertText());
 
            
        });
        
        btnChoice2.addActionListener(e->{

                //Check threshold
          classAlert.setAlertAdmin(classThreshold.checkThreshold("ncwm"));
          labelAlert.setText(classAlert.getAlertText());
            
        });
        
        btnChoice3.addActionListener(e->{

          classAlert.setAlertAdmin(classThreshold.checkThreshold("cap"));
          labelAlert.setText(classAlert.getAlertText());
            
        });
        
        btnChoice4.addActionListener(e->{
            
          classAlert.setAlertAdmin(classThreshold.checkThreshold("mc"));
          labelAlert.setText(classAlert.getAlertText());
               
        });
     
        
        
        panelMain.add(panelSelection);

       
    }
     
    
}
