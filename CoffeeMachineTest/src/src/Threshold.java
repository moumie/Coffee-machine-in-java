
package src;

/**
 *
 * @author soulemane
 */
public class Threshold {
    Delivery classDelivery;
    DBread dbRead;
    public Threshold(DBread dbRead, Delivery classDelivery){
        System.out.println("Threshold Called");
        this.dbRead = dbRead;
        this.classDelivery = classDelivery;
    }
    
    //Threshold variables
    double threshold_water=2000.0;
    double threshold_milk=200.0;
    double threshold_coffee=200.0;
    double threshold_espresso=1000.0;     

  public void setThreshold_water(double threshold_water) {
    this.threshold_water = threshold_water;
  }

  public void setThreshold_coffee(double threshold_coffee) {
    this.threshold_coffee = threshold_coffee;
  }

  public void setThreshold_milk(double threshold_milk) {
    this.threshold_milk = threshold_milk;
  }

  public void setThreshold_espresso(double threshold_espresso) {
    this.threshold_espresso = threshold_espresso;
  }

  
    public boolean checkThreshold(String coffeType){
            switch (coffeType) {
            case "ncwom": 
                if( (( dbRead.getTotal_water() - dbRead.getNcwom_water()) > threshold_water ) && 
                    (( dbRead.getTotal_coffee()- dbRead.getNcwom_coffee()) > threshold_coffee )
                  )
                {
                   classDelivery.updateCoffeeQuantities(coffeType);
                   return false ;
                }
                else return true;
   
            case "ncwm":  ;
                if( (( dbRead.getTotal_water() - dbRead.getNcwm_water()) > threshold_water ) && 
                    (( dbRead.getTotal_milk()- dbRead.getNcwm_milk()) > threshold_milk ) &&
                    (( dbRead.getTotal_coffee()- dbRead.getNcwm_coffee()) > threshold_coffee )
                  )
                {
                   classDelivery.updateCoffeeQuantities(coffeType);
                   return false ;
                }
                else return true;
                
            case "cap":  ;
                    
                if( (( dbRead.getTotal_water() - dbRead.getCapu_water()) > threshold_water ) ||
                    (( dbRead.getTotal_milk()- dbRead.getCapu_milk()) > threshold_milk ) ||
                    (( dbRead.getTotal_espresso()- dbRead.getCapu_espresso()) > threshold_espresso )
                  )
                {
                   classDelivery.updateCoffeeQuantities(coffeType);
                   return false ;
                }
                else return true;
                
            case "mc":  ;
                if( (( dbRead.getTotal_water() - dbRead.getCof_water()) > threshold_water ) && 
                    (( dbRead.getTotal_milk()- dbRead.getCof_milk()) > threshold_milk ) &&
                    (( dbRead.getTotal_coffee()- dbRead.getCof_coffee()) > threshold_coffee )
                  )
                {
                   classDelivery.updateCoffeeQuantities(coffeType);
                   return false ;
                }
                else return true;
        }
            
      return true;      
    }
}
