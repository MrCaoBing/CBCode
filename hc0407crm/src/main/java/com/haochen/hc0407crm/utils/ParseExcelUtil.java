package com.haochen.hc0407crm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ 时 间   2017 - 12 - 29
 * @author Mr.Cao
 *
 */
public class ParseExcelUtil {

	/**
	 * 对不同版本的excel进行处理,得到一个Workbook
	 * 
	 * @return Workbook
	 */
	private static Workbook getWordbook(MultipartFile excelFile) {
		try {
			/** 2003版本 */
			return new HSSFWorkbook(excelFile.getInputStream());
		} catch (Exception e) {
			try {
				/** 2007版本 */
				return new XSSFWorkbook(excelFile.getInputStream());
			} catch (IOException e1) {
				System.out.println("错误: getWordbook方法,得到版本错误!");
			}
			return null;
		} finally {
			try {
				excelFile.getInputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 对列的值进行处理
	 * 
	 * @param cell			列对象
	 * @return 					返回处理好的值
	 */
	public static String getCellValue(Cell cell) {
		String val = "";
		/** 如果列不等于空那么就与Excel自定义的类型进行比较,然后转换成相应java类型 */
		if (cell != null) {
			/** 得到其类型 格式化为指定格式字符串,后面由类型转换器进行转换*/
			switch (cell.getCellType()) {
			/** String类型 */
			case Cell.CELL_TYPE_STRING:
				val = cell.getStringCellValue();
				break;
			/** boolean类型 */
			case Cell.CELL_TYPE_BOOLEAN:
				val = cell.getBooleanCellValue()+"";
				break;
			/** 数值类型 */
			case Cell.CELL_TYPE_NUMERIC:
				/** 如果为时间类型 */
				if (DateUtil.isCellDateFormatted(cell)) {
					Date theDate = cell.getDateCellValue();
					SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					val = dff.format(theDate);
				} else {
					/** 普通数值 */
					val = cell.getNumericCellValue()+"";
				}
				break;
			/** 空白格 */
			case Cell.CELL_TYPE_BLANK:
				break;
			}
		}
		return val;
	}

	/**
	 * 类型转换器 
	 * @param str						----要转化的字符串
	 * @param dataType			----目标对象类型
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static Object parseValue(String str, Class dataType) {
		Object obj = null;
		
		String dataTypeName = dataType.getName();

		if (str != null && str != "") {
			/** excel中的数字解析之后可能末尾会有.0，需要去除 */
			if (str.endsWith(".0")) {
				str = str.substring(0, str.length() - 2);
			}
			/** 类型转换 */
			if ("java.lang.Byte".equals(dataTypeName) || "byte".equals(dataTypeName)) {
				obj = new Byte(str);
			} else if ("java.lang.Short".equals(dataTypeName) || "short".equals(dataTypeName)) {
				obj = new Short(str);
			} else if ("java.lang.Integer".equals(dataTypeName) || "int".equals(dataTypeName)) {
				obj = new Integer(str);
			} else if ("java.lang.Long".equals(dataTypeName) || "long".equals(dataTypeName)) {
				obj = new Long(str);
			} else if ("java.lang.Float".equals(dataTypeName) || "float".equals(dataTypeName)) {
				obj = new Float(str);
			} else if ("java.lang.Double".equals(dataTypeName) || "double".equals(dataTypeName)) {
				obj = new Double(str);
			} else if ("java.lang.Char".equals(dataTypeName) || "char".equals(dataTypeName)) {
				obj = new Character(str.charAt(0));
			} else if ("java.lang.Boolean".equals(dataTypeName) || "boolean".equals(dataTypeName)) {
				obj = new Boolean("true".equals(str));
			} else if ("java.lang.String".equals(dataTypeName)) {
				obj = str;
			} else if ("java.util.Date".equals(dataTypeName)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try {
					obj = sdf.parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	/**
	 * 首字母转小写
	 * @param s 
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 将excel解析为:List<List<String>>
	 * 
	 * @param MultipartFile 	excel文件
	 * @return List<List<String>>
	 */
	public static List<List<String>> readIntoList(MultipartFile excelFile) {

		/** 得到第一个shell */
		Sheet sheet = getWordbook(excelFile).getSheetAt(0);

		/** 储存行数据集合 */
		List<List<String>> data = new ArrayList<List<String>>();

		/** 得到首行长度 */
		int firstSize = 0;

		/** 遍历行数据 */
		for (Row r : sheet) {
			if (firstSize == 0) {
				firstSize = r.getPhysicalNumberOfCells();
			}
			/** 储存列数据集合 */
			List<String> rowData = new ArrayList<String>();

			/** 遍历列数据 */
			for (int i = 0; i < firstSize; i++) {
				if (r.getCell(i) != null) {
					rowData.add(getCellValue(r.getCell(i)));
				} else {
					rowData.add(null);
				}
			}

			/** 存储行数据 */
			data.add(rowData);
		}

		return data;
	}
	
	/**
	 * 
	 * @param excelFile excel文件
	 * @param c 转换类型
	 * @return 返回包含目标对象的List
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> readIntoObject(MultipartFile excelFile, Class<T> c) {

		/** 获得excel数据 */
		List<List<String>> excelData = readIntoList(excelFile);

		/** 获得实例后的对象集合 */
		List<T> classList = new ArrayList<T>();

		/** 储存首行数据,对应对象属性 */
		String[] titles = new String[excelData.get(0).size()];

		/** 存入首行数据,即该对象的属性 */
		for (int i = 0; i < titles.length; i++) {
			titles[i] = excelData.get(0).get(i);
		}

		/** 得到该类的所有方法 */
		Method[] method = c.getMethods();

		try {
			/** 实例化该类 */
			Object obj = null;
			for (int k = 1; k < excelData.size(); k++) {
				/** 确保每次得到的是一个全新的对象引用 */
				obj = c.newInstance();
				/** 外层循环逐一匹配标题 */
				for (int i = 0; i < titles.length; i++) {
					/** 循环所有方法,给匹配正确的方法赋值 */
					for (int j = 0; j < method.length; j++) {
						/** 判断该方法是否是set方法 */
						if (method[j].getName().startsWith("set")) {
							/** 根据实体类set方法规则,截取set后面的字符,并且首字母小写,一般为该类的属性 */
							if (toLowerCaseFirstOne(method[j].getName().substring(3)).equals(titles[i])) {
								method[j].invoke(obj,parseValue(excelData.get(k).get(i), method[j].getParameterTypes()[0]));
							}
						}
					}
				}
				classList.add((T) obj);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return classList;
	}
	
	/**
	 * listParseExcel(List<List<String>> lis, String sheetName, String fileName) 方法重载
	 * @param lis
	 * @return
	 */
	public static Workbook listParseExcel(List<List<String>> lis) {
		return listParseExcel(lis, null, null);
	}
	
	/**
	 * 次方法解析格式为List<Map>
	 * listParseExcel(List<List<String>> lis, String sheetName, String fileName) 方法重载
	 * @param lis
	 * @return
	 */
	public static Workbook listMapParseExcel(List<Map<String,Object>> lis) {
		List<List<String>> list1 = new ArrayList<List<String>>();		
		for (int i = 0; i < lis.size(); i++) {
			List<String> list2 = new ArrayList<String>();
			for (String s:lis.get(i).keySet()) {
				list2.add(lis.get(i).get(s)+"");
			}
			list1.add(list2);
		}
		return listParseExcel(list1, null, null);		
	}
	
	/**
	 * 次方法解析格式为List<Map>,添加文件名
	 * listParseExcel(List<List<String>> lis, String sheetName, String fileName) 方法重载
	 * @param lis
	 * @return
	 */
	public static Workbook listMapParseExcel(List<Map<String,Object>> lis, String sheetName, String fileName) {
		List<List<String>> list1 = new ArrayList<List<String>>();		
		for (int i = 0; i < lis.size(); i++) {
			List<String> list2 = new ArrayList<String>();
			for (String s:lis.get(i).keySet()) {
				list2.add(lis.get(i).get(s)+"");
			}
			list1.add(list2);
		}
		return listParseExcel(list1, null, null);		
	}
	/**
	 * 
	 * @param lis 数据集合
	 * @param sheetName 工作簿名称
	 * @param fileName 文件名称
	 * @return
	 */
	public static Workbook listParseExcel(List<List<String>> lis, String sheetName, String fileName) {
		/** 创建一个Excel-2007对象 */
		Workbook wb = new XSSFWorkbook();
		/** 获得一个sheet */
		Sheet sheet = wb.createSheet(sheetName == null || sheetName == "" ? "newSheet" : sheetName);
		/** 行对象 */
		Row row = null;
		/** 列对象 */
		Cell cell = null;
		/** 取出集合数据,存入sheet */
		for (int i = 0; i < lis.size(); i++) {
			row = sheet.createRow(i);
			for (int j = 0; j < lis.get(0).size(); j++) {
				cell = row.createCell(j);
				cell.setCellValue(lis.get(i).get(j));
			}
		}
		return wb;
	}
	public static void main(String[] args) {
		List<String> rowData1 = new ArrayList<String>();
		List<String> rowData2 = new ArrayList<String>();
		List<String> rowData3 = new ArrayList<String>();
		
		List<List<String>> data = new ArrayList<List<String>>();
		rowData1.add("1");
		rowData1.add("张三");
		rowData1.add("123456");
		
		rowData2.add("2");
		rowData2.add("李四");
		rowData2.add("234567");
		
		rowData3.add("3");
		rowData3.add("王五");
		rowData3.add("345678");
		
		data.add(rowData1);
		data.add(rowData2);
		data.add(rowData3);
		try {
			listParseExcel(data).write(new FileOutputStream(new File("D://te.xlsx")));
			listParseExcel(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}