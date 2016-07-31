
package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author soulemane
 */
//import statements
public  class DBread 
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
    
    //invalid value
    double invalid_total=0.0;
    double invalid_ingredient=1000000;
    
    //max quantity
    double max_water= 4000;
    double max_milk=1000;
    double max_coffee=1000;
    double max_espresso=50;
    //String dir = "E:\\2015\\db\\demo.xlsx";
    String dir = "demo.xlsx";

    public DBread() 
    {
        try
        {
            FileInputStream file = new FileInputStream(new File(dir));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
          
            //Iterate through each rows one by one
            int rowIndex =0;
            int columnIndex =0;
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "  ");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "  ");
                            break;
                    }
                
                    //Normal coffee without milk

                    if(rowIndex==1 && columnIndex==6){
                       this.ncwom_water=cell.getNumericCellValue();   
                       System.out.println("RC "+ rowIndex + " - "+ columnIndex + " = "+ cell.getNumericCellValue());
                    }
                    else if(rowIndex==1 && columnIndex==7){
                       this.ncwom_milk=cell.getNumericCellValue();  
                    }
                    else if(rowIndex==1 && columnIndex==8){
                       this.ncwom_coffee=cell.getNumericCellValue();
                    }
                    else if(rowIndex==1 && columnIndex==9){
                       this.ncwom_espresso=cell.getNumericCellValue(); 
                    }
                    
                    //Normal coffee with milk

                    if(rowIndex==2 && columnIndex==11){
                       this.ncwm_water=cell.getNumericCellValue(); 
                    }
                    else if(rowIndex==2 && columnIndex==12){
                       this.ncwm_milk =cell.getNumericCellValue();
                    }
                    else if(rowIndex==2 && columnIndex==13){
                       this.ncwm_coffee=cell.getNumericCellValue(); 
                    }
                    else if(rowIndex==2 && columnIndex==14){
                       this.ncwm_espresso=cell.getNumericCellValue(); 
                    }
                    
                    //cappuccino

                    if(rowIndex==3 && columnIndex==16){
                       this.capu_water=cell.getNumericCellValue();   
                    }
                    else if(rowIndex==3 && columnIndex==17){
                       this.capu_milk=cell.getNumericCellValue();
                    }
                    else if(rowIndex==3 && columnIndex==18){
                       this.capu_coffee=cell.getNumericCellValue();
                    }
                    else if(rowIndex==3 && columnIndex==19){
                       this.capu_espresso=cell.getNumericCellValue();
                    }
                    
                    //Normal coffee without milk

                    if(rowIndex==4 && columnIndex==21){
                        
                       this.cof_water=cell.getNumericCellValue();  
                    }
                    else if(rowIndex==4 && columnIndex==22){
                       this.cof_milk=cell.getNumericCellValue();
                    }
                    else if(rowIndex==4 && columnIndex==23){
                       this.cof_coffee=cell.getNumericCellValue(); 
                    }
                    else if(rowIndex==4 && columnIndex==24){
                       this.cof_espresso=cell.getNumericCellValue();
                    }
                   
                     //Total

                    if(rowIndex==5 && columnIndex==26){
                       this.total_water=cell.getNumericCellValue();                    
                    }
                    else if(rowIndex==5 && columnIndex==27){
                       this.total_milk=cell.getNumericCellValue();                    
                    }
                    else if(rowIndex==5 && columnIndex==28){
                       this.total_coffee=cell.getNumericCellValue();                    
                    }
                    else if(rowIndex==5 && columnIndex==29){
                       this.total_espresso=cell.getNumericCellValue();                    
                    }
                   
                    columnIndex++;
                }
                System.out.println("  ");
            
            rowIndex++;
            }
            file.close();
 
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
    
    //Total quantity for each ingredient getters
    public double getTotal_water() {
        if(this.total_water >=0 && this.total_water<=max_water)
        return this.total_water;
        else return this.invalid_total;
    }

    public double getTotal_milk() {
        if(this.total_milk >=0 && this.total_milk<=max_milk)
        return this.total_milk;
        else return this.invalid_total;
    }

    public double getTotal_coffee() {
        if(this.total_coffee >=0 && this.total_coffee<=max_coffee)
        return this.total_coffee;
        else return this.invalid_total;
    }

    public double getTotal_espresso() {
        if(this.total_espresso >=0 && this.total_espresso<=max_espresso)
        return this.total_espresso;
        else return this.invalid_total;
    }
      
    //Coffee types and ingredients getters
    public double getNcwm_water() {
        if(this.ncwm_water==220) return this.ncwm_water;
        else return invalid_ingredient;   
    }
    public double getNcwm_milk() {
        if(this.ncwm_milk==30)return this.ncwm_milk;
        else return invalid_ingredient; 
    }

    public double getNcwm_coffee() {
        if(this.ncwm_coffee==14)return this.ncwm_coffee;
        else return invalid_ingredient; 
    }

    public double getNcwm_espresso() {
        if(this.ncwm_espresso==0) return this.ncwm_espresso;
        else return invalid_ingredient; 
    }

    public double getNcwom_water() {
        if(this.ncwom_water==250)return this.ncwom_water;
        else return invalid_ingredient; 
    }

    public double getNcwom_milk() {
        if(this.ncwom_milk==0)return this.ncwom_milk;
        else return invalid_ingredient; 
    }

    public double getNcwom_coffee() {
        if(this.ncwom_coffee==14)return this.ncwom_coffee;
        else return invalid_ingredient; 
    }

    public double getNcwom_espresso() {
        if(this.ncwom_espresso==0) return this.ncwom_espresso;
        else return invalid_ingredient; 
    }

    public double getCapu_water() {
        if(this.capu_water==30) return this.capu_water;
        else return invalid_ingredient; 
    }

    public double getCapu_milk() {
        if(this.capu_milk==0) return this.capu_milk;
        else return invalid_ingredient; 
    }

    public double getCapu_coffee() {
        if(this.capu_coffee==0) return this.capu_coffee;
        else return invalid_ingredient; 
    }

    public double getCapu_espresso() {
        if(this.capu_espresso==7) return this.capu_espresso;
        else return invalid_ingredient; 
    }

    public double getCof_water() {
        if(this.cof_water==30) return this.cof_water;
        else return invalid_ingredient; 
    }

    public double getCof_milk() {
        if(this.cof_milk==60) return this.cof_milk;
        else return invalid_ingredient; 
    }

    public double getCof_coffee() {
        if(this.cof_coffee==14) return this.cof_coffee;
        else return invalid_ingredient; 
    }

    public double getCof_espresso() {
        if(this.cof_espresso==0) return this.cof_espresso;
        else return invalid_ingredient; 
    }   
    
}