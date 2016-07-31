
package src;

/**
 *
 * @author soulemane
 */
public class Alert {
    
    public Alert(){
      System.out.println("Alert called");
    }
    boolean alertAdmin= false; // ?????? I should perform an initial check for all types of coffee
    
    String  alertText="";
    String callAdmin = "Quantity below the threshold";
    String notCall ="";
    
    public boolean getAlertAdmin(){
        return alertAdmin;
    }
    
    public void setAlertAdmin(boolean alertAdmin){
        this.alertAdmin = alertAdmin;
    }

    
    public void setAlertText(String alertText) {
        
           if(getAlertAdmin()){
             this.alertText = callAdmin;
            } 
        
            else{
             this.alertText = notCall;
            } 
    }
  
     public String getAlertText(){
            
            if(getAlertAdmin()){
             return callAdmin;
            } 
        
            else{
                return notCall;
            } 
        }
   
    
}
