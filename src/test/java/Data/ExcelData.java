package Data;

import Utilities.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData extends BaseClass {

        private String dataFileSheet = "Shoe_Portal_details.xlsx";
        private List<Object[]> data = new ArrayList<>();
        private Workbook workbook;


        public ExcelData() throws IOException {
            super();
            try {


                Path Path = Paths.get("src/test/Resources", dataFileSheet);
                FileInputStream stream = new FileInputStream(Path.toFile());
                workbook = new XSSFWorkbook(stream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public List<Object[]> getDataFromSheet(String sheetName) {

            Sheet sheet =workbook.getSheet(sheetName);

            Iterator<Row> rowIterator =sheet.rowIterator();
            rowIterator.next(); //skip the first row that has headings
            while (rowIterator.hasNext()){
                List<Object>cellData =new ArrayList<>();
                Row row =rowIterator.next();

//iterator method-will hold every values, iterate one by one.
                Iterator<Cell> cellIterator =row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell =cellIterator.next();

                    if (cell.getCellType()== CellType.STRING){
                        cellData.add(cell.getStringCellValue());
                    }
                    if (cell.getCellType()== CellType.NUMERIC){
                        cellData.add(cell.getNumericCellValue());
                    }
                    if (cell.getCellType()== CellType.BOOLEAN){
                        cellData.add(cell.getBooleanCellValue());
                    }
                }
                data.add(cellData.toArray());
            }
            return data;
        }

        @DataProvider
        public Iterator<Object[]> ShoePortal_dataProvider()
        {
            return getDataFromSheet("Shoe-details").iterator();
        }

    }
