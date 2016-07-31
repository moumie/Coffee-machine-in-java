
package src;

/**
 *
 * @author soulemane
 */
public class Delivery {
    //External class
    DBread dbRead;
    DBwrite dbWrite;
    double qtyWater=0.0;
    double qtyMilk=0.0;
    double qtyCoffee=0.0;
    double qtyEspresso=0.0;
    
    public Delivery(DBread dbRead, DBwrite dbWrite){
        System.out.println("Delivery Called");
        this.dbRead = dbRead;
        this.dbWrite = dbWrite;
    }
    public void updateCoffeeQuantities(String coffeeType){
        
        if(coffeeType.equals("ncwom")){
            qtyWater = dbRead.getTotal_water() - dbRead.getNcwom_water();
            dbWrite.setTotal_water(qtyWater);
            qtyWater=0.0;
            
            qtyCoffee = dbRead.getTotal_coffee()-dbRead.getNcwom_coffee();
            dbWrite.setTotal_coffee(qtyCoffee);
            qtyCoffee=0.0;
        }
        else if(coffeeType.equals("ncwm")){
            qtyWater = dbRead.getTotal_water() - dbRead.getNcwm_water();
            dbWrite.setTotal_water(qtyWater);
            qtyWater=0.0;
            
            qtyMilk = dbRead.getTotal_milk()- dbRead.getNcwm_milk();
            dbWrite.setTotal_milk(qtyMilk);
            qtyMilk=0.0;
            
            qtyCoffee = dbRead.getTotal_coffee()-dbRead.getNcwm_coffee();
            dbWrite.setTotal_coffee(qtyCoffee);
            qtyCoffee=0.0;
        }
        else if(coffeeType.equals("cap")){
            qtyWater = dbRead.getTotal_water() - dbRead.getCapu_water();
            dbWrite.setTotal_water(qtyWater);
            qtyWater=0.0;
            
            qtyEspresso = dbRead.getTotal_espresso()-dbRead.getCapu_espresso();
            dbWrite.setTotal_espresso(qtyEspresso);
            qtyEspresso=0.0;
        }
        else if(coffeeType.equals("mc")){
            qtyWater = dbRead.getTotal_water() - dbRead.getCof_water();
            dbWrite.setTotal_water(qtyWater);
            qtyWater=0.0;
            
            qtyMilk = dbRead.getTotal_milk()- dbRead.getCof_milk();
            dbWrite.setTotal_milk(qtyMilk);
            qtyMilk=0.0;
            
            qtyCoffee = dbRead.getTotal_coffee()-dbRead.getCof_coffee();
            dbWrite.setTotal_coffee(qtyCoffee);
            qtyCoffee=0.0;
        }
    }
    
    
}
