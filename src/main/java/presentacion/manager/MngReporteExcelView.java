/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: MngReporteExcelView.java
 * Autor: heriberto
 */
package presentacion.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import dominio.ReparacionEquipo;
import static presentacion.manager.ConstantesPresentacion.FORMATO_FECHA;
import static presentacion.manager.ConstantesPresentacion.FORMATO_HORA;

/**
 * @author heriberto
 *
 */
public class MngReporteExcelView extends AbstractExcelView {

	private List<String> getTitulosString(){
		List<String> titulosList= new ArrayList<String>();
		titulosList.add("Id Equipo");
		titulosList.add("Tipo de equipo");
		titulosList.add("Responsable Equipo");
		titulosList.add("Estado");
		titulosList.add("Fecha de Registro");
		titulosList.add("Motivo  ");
		titulosList.add("Usuario Asignado");
		return titulosList;
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	protected void buildExcelDocument( Map model, HSSFWorkbook workbook,
	HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	List<ReparacionEquipo> reparacionEquipoList =(List<ReparacionEquipo>) model.get("reparacionEquipoList");
		HSSFSheet sheet = workbook.createSheet("SIVEC");
		PrintSetup printSetup = sheet.getPrintSetup();
	    printSetup.setLandscape(true);
	    sheet.setFitToPage(true);
	    sheet.setHorizontallyCenter(true);
	    
	    Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(45);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Reporte Movimientos");
        titleCell.setCellStyle(crearEstiloTitulo(workbook));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$G$1"));
        
        Row headerRow = sheet.createRow(1);
        headerRow.setHeightInPoints(40);
        Cell headerCell;
        int i=0;
        CellStyle estiloHeader =crearEstiloHeader(workbook);
        for(String titulo: this.getTitulosString())
        {
            headerCell = headerRow.createCell(i);
            headerCell.setCellValue(titulo);
            headerCell.setCellStyle(estiloHeader);
            sheet.setColumnWidth(i, 5000);

            i++;
        }
       
        CellStyle estiloCelda =  crearEstiloCelda(workbook);
        int rownum = 2;
        	for(ReparacionEquipo reparacionEquipo : reparacionEquipoList){
            	 Row row = sheet.createRow(rownum++);
            	 Cell celdaIdEquipo = row.createCell(0);
            	 celdaIdEquipo.setCellValue(reparacionEquipo.getEquipoComputo().getIdEquipoComputo());
            	 celdaIdEquipo.setCellStyle(estiloCelda);
            	 
            	 Cell celdaTipo = row.createCell(1);
            	 celdaTipo.setCellValue(reparacionEquipo.getEquipoComputo().getDescTipoEquipo());
            	 
            	 celdaTipo.setCellStyle(estiloCelda);
            	 
            	 Cell celdaResponsable = row.createCell(2);
            	 celdaResponsable.setCellValue(reparacionEquipo.getUsuarioByIdUsuarioResponsable().getNombreCompleto());
            	 celdaResponsable.setCellStyle(estiloCelda);
            	 
            	 Cell celdaEstado = row.createCell(3);
            	 celdaEstado.setCellValue(reparacionEquipo.getEquipoComputo().getEstadoEquipo());
            	 celdaEstado.setCellStyle(estiloCelda);
            	 
            	
            	 Cell celdaFecha = row.createCell(4);
            	 celdaFecha.setCellValue(reparacionEquipo.getFechaRegistroFormato());
            	 celdaFecha.setCellStyle(estiloCelda);
            	 
            	 Cell celdaMotivo = row.createCell(5);
            	 celdaMotivo.setCellValue(reparacionEquipo.getDescMotivo());
            	 celdaMotivo.setCellStyle(estiloCelda);
            	 
            	 Cell celdaAsignado = row.createCell(6);
            	 celdaAsignado.setCellValue(reparacionEquipo.getUsuarioByIdUsuarioAsignado().getNombreCompleto());
            	 celdaAsignado.setCellStyle(estiloCelda);
        	 }
       
		
	}
	
	private CellStyle crearEstiloTitulo(HSSFWorkbook wb){
		CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)18);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        return style;
	}
	
	private CellStyle crearEstiloHeader(HSSFWorkbook wb){
		CellStyle style;
		Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short)11);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        return style;
	}
	private CellStyle crearEstiloCelda(HSSFWorkbook wb)
	{
		CellStyle style;
		style = wb.createCellStyle();
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    style.setWrapText(true);
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(CellStyle.BORDER_THIN);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    return style;
	}
	

}
