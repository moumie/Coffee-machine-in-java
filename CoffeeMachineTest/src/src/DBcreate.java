
package src;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author soulemane
 */
//import statements
public class DBcreate 
{
    public DBcreate() 
    {
      
        //Directory
        String dir = "demo.xlsx";

      
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Coffee Machine Data");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("0", new Object[] {" ", "water", "milk", "coffee", "espresso"});
        data.put("1", new Object[] {"ncwom", 0, 0, 0, 0});
        data.put("2", new Object[] {"ncwm", 0, 0, 0, 0});
        data.put("3", new Object[] {"cap", 0, 0, 0, 0});
        data.put("4", new Object[] {"cof", 0, 0, 0, 0});
        data.put("5", new Object[] {"total", 0, 0, 0, 0});  
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(dir));
            workbook.write(out);
            out.close();
            System.out.println("demo.xlsx written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
