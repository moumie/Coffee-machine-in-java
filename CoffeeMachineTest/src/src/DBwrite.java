
package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author soulemane
 */
//import statements
public class DBwrite 
{
    //Coffee types and ingredients
    //normal coffee with milk
    double ncwm_water=0.0;
    double ncwm_milk=0.0;
    double ncwm_coffee=0.0;
    double ncwm_espresso=0.0;
    
    //normal coffee without milk
    double ncwom_water=0.0;    
    double ncwom_milk=0.0;
    double ncwom_coffee=0.0;
    double ncwom_espresso=0.0;
    
    //normal coffee with milk
    double capu_water=0.0;
    double capu_milk=0.0;
    double capu_coffee=0.0;
    double capu_espresso=0.0;
    
    //normal coffee without milk
    double cof_water=0.0;  
    double cof_milk=0.0;
    double cof_coffee=0.0;
    double cof_espresso=0.0;

    //total quantity for each ingredient
    double total_water=0.0;
    double total_milk=0.0;
    double total_coffee=0.0;
    double total_espresso=0.0;   
    
    //directory
    String dir = "demo.xlsx";

    public DBwrite() 
    {
     
        
    }
    
    
      //Total quantity for each ingredient setters
    public void setTotal_water(double total_water) {
        this.total_water = total_water;
         writeToDb(5, 1, total_water);
    }

    public void setTotal_milk(double total_milk) {
        this.total_milk = total_milk;
        writeToDb(5, 2, total_milk);
    }

    public void setTotal_coffee(double total_coffee) {
        this.total_coffee = total_coffee;
        writeToDb(5, 3, total_coffee);
    }

    public void setTotal_espresso(double total_espresso) {
        this.total_espresso = total_espresso;
        writeToDb(5, 4, total_espresso);
    }
   
    //Coffee types and ingredients setters
    
    public void setNcwom_water(double ncwom_water) {
        this.ncwom_water = ncwom_water;
        writeToDb(1, 1, ncwom_water);
    }

    public void setNcwom_milk(double ncwom_milk) {
        this.ncwom_milk = ncwom_milk;
        writeToDb(1, 2, ncwom_milk);
    }

    public void setNcwom_coffee(double ncwom_coffee) {
        this.ncwom_coffee = ncwom_coffee;
        writeToDb(1, 3, ncwom_coffee);
    }

    public void setNcwom_espresso(double ncwom_espresso) {
        this.ncwom_espresso = ncwom_espresso;
        writeToDb(1, 4, ncwom_espresso);
    }

    
    public void setNcwm_water(double ncwm_water) {
        this.ncwm_water = ncwm_water;
         writeToDb(2, 1, ncwm_water);
    }

    public void setNcwm_milk(double ncwm_milk) {
        this.ncwm_milk = ncwm_milk;
        writeToDb(2, 2, ncwm_milk);
    }

    public void setNcwm_coffee(double ncwm_coffee) {
        this.ncwm_coffee = ncwm_coffee;
        writeToDb(2, 3, ncwm_coffee);
    }

    public void setNcwm_espresso(double ncwm_espresso) {
        this.ncwm_espresso = ncwm_espresso;
        writeToDb(2, 4, ncwm_espresso);
    }

    
    public void setCapu_water(double capu_water) {
        this.capu_water = capu_water;
        writeToDb(3, 1, capu_water);
    }

    public void setCapu_milk(double capu_milk) {
        this.capu_milk = capu_milk;
        writeToDb(3, 2, capu_milk);
    }

    public void setCapu_coffee(double capu_coffee) {
        this.capu_coffee = capu_coffee;
        writeToDb(3, 3, capu_coffee);
    }

    public void setCapu_espresso(double capu_espresso) {
        this.capu_espresso = capu_espresso;
        writeToDb(3, 4, capu_espresso);
    }

    public void setCof_water(double cof_water) {
        this.cof_water = cof_water;
        writeToDb(4, 1, cof_water);
    }

    public void setCof_milk(double cof_milk) {
        this.cof_milk = cof_milk;
        writeToDb(4, 2, cof_milk);
    }

    public void setCof_coffee(double cof_coffee) {
        this.cof_coffee = cof_coffee;
        writeToDb(4, 3, cof_coffee);
    }

    public void setCof_espresso(double cof_espresso) {
        this.cof_espresso = cof_espresso;
        writeToDb(4, 4, cof_espresso);
    }



    public void writeToDb(int row, int cell, double value){
         try
        {
            FileInputStream file = new FileInputStream(new File(dir));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            file.close();
           // sheet.createRow(row).createCell(cell).setCellValue(value);
            sheet.getRow(row).getCell(cell).setCellValue(value);
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(dir));
            workbook.write(out);
            out.close();           
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}