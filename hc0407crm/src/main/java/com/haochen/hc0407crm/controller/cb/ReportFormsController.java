package com.haochen.hc0407crm.controller.cb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochen.hc0407crm.service.cb.CstLostService;
import com.haochen.hc0407crm.service.cb.ReportFormsService;
import com.haochen.hc0407crm.utils.Paging;
import com.haochen.hc0407crm.utils.ParseExcelUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 针对报表操作的控制器
 * 
 * @author Mr.Cao
 * @date 2018年1月14日 下午4:30:44
 */
@Controller
public class ReportFormsController {

	@Autowired
	private ReportFormsService reportFormsService;
	@Autowired
	private CstLostService CstLostService;

	/**
	 * -----------------------------------------客户贡献部分--------------------------
	 * ----------------- 分页数据
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustAccountedByPage.do")
	public @ResponseBody Map listCustAccountedByPage(Paging pg) {
		return reportFormsService.listCustAccounted(pg).getResultMap();
	}

	/**
	 * 报表数据
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustAccounted.do")
	public @ResponseBody List listCustAccounted(Paging pg) {
		List<Map> list = reportFormsService.listCustAccounted(pg).getData();
		return list;
	}

	/**
	 * 报表数据
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("custAccountedParseExcel.do")
	public @ResponseBody List custAccountedParseExcel(Paging pg, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		List<Map<String, Object>> lis = reportFormsService.listCustAccounted(pg).getData();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_KHGX.xlsx").getBytes()));
		ParseExcelUtil.listMapParseExcel(lis).write(response.getOutputStream());
		return lis;
	}

	/**
	 * 报表数据PDF
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("custAccountedParsePDF.do")
	public @ResponseBody List custAccountedParsePDF(Paging pg, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		List<Map<String, Object>> lis = reportFormsService.listCustAccounted(pg).getData();
		response.setContentType("application/pdf;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_KHGX.pdf").getBytes()));
		Document document = new Document(PageSize.A4);
		response.setContentType("multipart/form-data");
		try {

			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			FontSelector font = new FontSelector();
			font.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
			font.addFont(FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));
			PdfPTable table = new PdfPTable(2); // 2列
			table.setTotalWidth(100);
			PdfPCell cell;
			cell = new PdfPCell(font.process("客户贡献"));
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(font.process("客户ID")); // 客户等级
			table.addCell(cell);
			cell = new PdfPCell(font.process("金额(人民币)"));
			table.addCell(cell);

			for (int i = 0; i < lis.size(); i++) {
				table.addCell(lis.get(i).get("custId").toString());
				table.addCell(lis.get(i).get("value").toString());
			}

			document.add(table);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		document.close();

		return lis;
	}

	/**
	 * -----------------------------------------客户构成部分--------------------------
	 * -----------------
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustConstituteByPage.do")
	public @ResponseBody Map listCustConstituteByPage(Paging pg) {
		return reportFormsService.listCustConstitute(pg).getResultMap();
	}

	/**
	 * 报表数据
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustConstitute.do")
	public @ResponseBody List listCustConstitute(Paging pg) {
		List<Object> list = reportFormsService.listCustConstitute(pg).getData();
		return list;
	}

	/**
	 * 解析Excel
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("custConstituteParseExcel.do")
	public @ResponseBody List CustConstituteParseExcel(Paging pg, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		List<Map<String, Object>> lis = reportFormsService.listCustConstitute(pg).getData();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" 
		+ new String((new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_KHGC.xlsx").getBytes()));
		ParseExcelUtil.listMapParseExcel(lis).write(response.getOutputStream());
		return lis;
	}

	/**
	 * 解析Excel
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("custConstituteParsePDF.do")
	public @ResponseBody List custConstituteParsePDF(Paging pg, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		List<Map<String, Object>> lis = reportFormsService.listCustConstitute(pg).getData();
		response.setContentType("application/pdf;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_KHGX.pdf").getBytes()));
		Document document = new Document(PageSize.A4);
		response.setContentType("multipart/form-data");
		try {

			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			FontSelector font = new FontSelector();
			font.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
			font.addFont(FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));
			PdfPTable table = new PdfPTable(2); // 2列
			table.setTotalWidth(100);
			PdfPCell cell;
			cell = new PdfPCell(font.process("客户等级"));
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(font.process("客户名称")); // 客户等级
			table.addCell(cell);
			cell = new PdfPCell(font.process("数量"));
			table.addCell(cell);

			for (int i = 0; i < lis.size(); i++) {
				table.addCell(font.process(lis.get(i).get("name").toString()));
				table.addCell(lis.get(i).get("value").toString());
			}

			document.add(table);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		document.close();

		return lis;
	}

	/**
	 * -----------------------------------------客户服务数据部分------------------------
	 * -------------------
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustServiceByPage.do")
	public @ResponseBody Map listCustServiceByPage(Paging pg) {
		return reportFormsService.listCustService(pg).getResultMap();
	}

	/**
	 * 报表数据
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustService.do")
	public @ResponseBody List listCustService(Paging pg) {
		List<Map<String, Object>> list = reportFormsService.listCustService(pg).getData();

		List<Object> series = new ArrayList<Object>();
		Set<String> set = new HashSet<String>();
		for (Map<String, Object> s : list) {
			set.add((String) s.get("name"));
		}
		for (String s : set) {
			Map<String, Object> seriesA = new HashMap<String, Object>();
			seriesA.put("name", s);
			String[] dataArray = new String[12];
			for (int k = 0; k < dataArray.length; k++) {
				dataArray[k] = "0";
			}
			for (int i = 0; i < 12; i++) {
				String month = i + 1 + "";
				for (int j = 0; j < list.size(); j++) {
					if (s.equals(list.get(j).get("name").toString())
							&& month.equals(list.get(j).get("type").toString())) {
						dataArray[i] = list.get(j).get("value").toString();
					}
				}
				seriesA.put("data", dataArray);
			}
			seriesA.put("type", "bar");
			Map<String, Object> markPointMap = new HashMap<String, Object>();
			List<Map<String, String>> markPointMapData = new ArrayList<Map<String, String>>();
			Map<String, String> max = new HashMap<String, String>();
			Map<String, String> min = new HashMap<String, String>();
			max.put("type", "max");
			max.put("name", "最大值");
			min.put("type", "min");
			min.put("name", "最小值");
			markPointMapData.add(max);
			markPointMapData.add(min);
			markPointMap.put("data", markPointMapData);
			seriesA.put("markPoint", markPointMap);
			Map<String, Object> markLineMap = new HashMap<String, Object>();
			List<Map<String, String>> markLineMapData = new ArrayList<Map<String, String>>();
			Map<String, String> average = new HashMap<String, String>();
			average.put("type", "average");
			average.put("name", "平均值");
			markLineMapData.add(average);
			markLineMap.put("data", markLineMapData);
			seriesA.put("markLine", markLineMap);
			series.add(seriesA);
		}
		return series;
	}

	/**
	 * 解析Excel
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("custServiceParseExcel.do")
	public @ResponseBody List CustServiceParseExcel(Paging pg, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		List<Map<String, Object>> lis = reportFormsService.listCustService(pg).getData();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_KHGC.xlsx").getBytes()));
		ParseExcelUtil.listMapParseExcel(lis).write(response.getOutputStream());
		return lis;
	}

	/**
	 * -----------------------------------------客户流失数据部分------------------------
	 * ------------------- 报表数据
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("listCustLost.do")
	public @ResponseBody List listCustLost() {
		List<Map<String, Object>> list = reportFormsService.listCustLost();

		List<Object> series = new ArrayList<Object>();
		Set<String> set = new HashSet<String>();
		for (Map<String, Object> s : list) {
			set.add((String) s.get("name"));
		}
		for (String s : set) {
			Map<String, Object> seriesA = new HashMap<String, Object>();
			seriesA.put("name", s);
			String[] dataArray = new String[12];
			for (int k = 0; k < dataArray.length; k++) {
				dataArray[k] = "0";
			}
			for (int i = 0; i < 12; i++) {
				String month = i + 1 + "";
				for (int j = 0; j < list.size(); j++) {
					if (s.equals(list.get(j).get("name").toString())
							&& month.equals(list.get(j).get("type").toString())) {
						dataArray[i] = list.get(j).get("value").toString();
					}
				}
				seriesA.put("data", dataArray);
			}
			seriesA.put("type", "bar");
			Map<String, Object> markPointMap = new HashMap<String, Object>();
			List<Map<String, String>> markPointMapData = new ArrayList<Map<String, String>>();
			Map<String, String> max = new HashMap<String, String>();
			Map<String, String> min = new HashMap<String, String>();
			max.put("type", "max");
			max.put("name", "最大值");
			min.put("type", "min");
			min.put("name", "最小值");
			markPointMapData.add(max);
			markPointMapData.add(min);
			markPointMap.put("data", markPointMapData);
			seriesA.put("markPoint", markPointMap);
			Map<String, Object> markLineMap = new HashMap<String, Object>();
			List<Map<String, String>> markLineMapData = new ArrayList<Map<String, String>>();
			Map<String, String> average = new HashMap<String, String>();
			average.put("type", "average");
			average.put("name", "平均值");
			markLineMapData.add(average);
			markLineMap.put("data", markLineMapData);
			seriesA.put("markLine", markLineMap);
			series.add(seriesA);
		}
		return series;
	}

	/**
	 * 解析Excel
	 * 
	 * @param pg
	 * @return
	 */
	@RequestMapping("custLostParseExcel.do")
	public @ResponseBody List custLostParseExcel(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		List<Map<String, Object>> lis = reportFormsService.listCustLost();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_KHLS.xlsx").getBytes()));
		ParseExcelUtil.listMapParseExcel(lis).write(response.getOutputStream());
		return lis;
	}

}
