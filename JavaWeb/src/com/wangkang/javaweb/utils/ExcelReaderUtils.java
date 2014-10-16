package com.wangkang.javaweb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReaderUtils
{
	// 文件二进制输入流
	private InputStream is = null;
	// 当前sheet
	private int currSheet;
	// 当前位置
	private int currPosition;
	// sheet数量
	private int numOfSheets;
	// HSSFWorkbook
	HSSFWorkbook workbook = null;
	//得到标题列表
	private  List<String>  titleList;
	//得到这张表中的行数
	private  int      lastRowNum;    
	//得到列数
	private   int filledColumns;
	// 构造函数创建一个ExcelReader
	public ExcelReaderUtils(File file) throws IOException, Exception
	{

		is = new FileInputStream(file);
		// 如果是Excel文件则创建HSSFWorkbook读取
		workbook = new HSSFWorkbook(is);
		// 设置sheet数
		titleList=this.getTitle();

	}
	
	// 函数readLine读取文本的一行
	public List<String> readLine() throws IOException
	{
		// 根据currSheet值获得当前的sheet
		HSSFSheet sheet = workbook.getSheetAt(currSheet);
		// 判断当前行是否到当前sheet的结尾
		if (currPosition > sheet.getLastRowNum())
		{
			// 当前行位置清零
			currPosition = 0;
			// 判断是否还有Sheet
			while (currSheet != numOfSheets - 1)
			{
				// 得到下一个sheet
				sheet = workbook.getSheetAt(currSheet + 1);
				// 判断当前行是否到当前sheet的结尾
				if (currPosition == sheet.getLastRowNum())
				{
					currSheet++;
					continue;
				} else
				{
					// 获取当前行数
					int row = currPosition;
					currPosition++;
					// 读取当前行数据
					return getLine(sheet, row);
				}
			}
			return null;
		}
		// 获取当前行数
		int row = currPosition;
		currPosition++;
		// 读取当前行数据
		return getLine(sheet, row);

	}

	// 函数getLine返回sheet的一行数据
	private List<String> getLine(HSSFSheet sheet, int row)
	{
		List<String> list=new ArrayList<String>();
		// 根据行数取得sheet的一行
		HSSFRow rowLine = sheet.getRow(row);
		// 获取挡前行的列数
		HSSFCell cell = null;
		// 循环遍历所有列
		for (int i = 0; i < filledColumns; i++)
		{
			// 取得当前cell
			cell = rowLine.getCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
			String cellValue = cell.getStringCellValue();
			list.add(cellValue);
		}
		// 以字符串返回该行的数据
		return  list;
	}
    private    List<String>   getTitle() throws IOException
    {
    	List<String>   list=new ArrayList<String>();
    	HSSFSheet sheet=workbook.getSheetAt(0);
    	HSSFRow rowLine = sheet.getRow(currPosition);
    	currPosition++;
		// 获取挡前行的列数
		int filledColumns = rowLine.getLastCellNum();
		HSSFCell cell = null;
		// 循环遍历所有列
		for (int i = 0; i < filledColumns; i++)
		{
			// 取得当前cell
			cell = rowLine.getCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
			String cellValue = cell.getStringCellValue();
			if(cellValue.equals(""))
			{
				this.filledColumns=list.size();
				return  list;
			}
			list.add(cellValue);
			lastRowNum=sheet.getLastRowNum();
		}
		this.filledColumns=list.size();
    	return  list;
    }
	
	// close函数执行流的关闭操作
	public void close()
	{
		// 如果id不为空，则关闭InputStream文件输入流
		if (is != null)
		{
			try
			{
				is.close();
			} catch (IOException e)
			{
				is = null;
			}
		}

	}

	public List<String> getTitleList()
	{
		return titleList;
	}

	public int getLastRowNum()
	{
		return lastRowNum;
	}

}
