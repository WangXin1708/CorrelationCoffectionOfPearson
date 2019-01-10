
/**
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.*;
import java.io.*;
import org.apache.poi.ss.usermodel.*;

/**
 * @author SinWang
 *
 */
public class CallClass {
	
	
	public static void main(String[] args) throws IOException{
		double CORR = 0.0;
		List<String> xList = new ArrayList<String>();;
		List<String> yList = new ArrayList<String>();
		System.out.println("批量计算Pearson相关系数");
		String filePath = ".\\例11.6.xls";
	FileInputStream stream = new FileInputStream(filePath);
	HSSFWorkbook workbook = new HSSFWorkbook(stream);//读取现有的Excel
	HSSFSheet sheet= workbook.getSheet("Sheet3");//得到指定名称的Sheet
	//HSSFRow Row=null;
	// HSSFCell Cell=null;
	
	for (Row row : sheet)
	{
 	for (Cell cell : row)
 	{
 		// System.out.print(cell.getCellType());
 		//如果是第一列就把它放到xlist，如果是第二列就把它放到ylist
 		if(cell.getColumnIndex()==0){
 			//Get the value of the cell as a number.      return double
 			double x=cell.getNumericCellValue();
 			System.out.print(x+"\t");
 			//String x1=Double.toString(x);
 			String x1=String.valueOf(x);
 			xList.add(x1);
 		}else{
 			//Get the value of the cell as a number.      return double
 			double y=cell.getNumericCellValue();
 			System.out.print(y+"");
 			//String y1=Double.toString(y);
 			String y1=String.valueOf(y);
 			yList.add(y1);
 		}
 	}
 	System.out.println();
	}
		

		
		NumeratorCalculate nc = new NumeratorCalculate(xList,yList);
		double numerator = nc.calcuteNumerator();
		DenominatorCalculate dc = new DenominatorCalculate();
		double denominator = dc.calculateDenominator(xList, yList);
		CORR = numerator/denominator;
		System.out.println("运算结果是：");
		System.out.printf("CORR = "+CORR);
	}
}

