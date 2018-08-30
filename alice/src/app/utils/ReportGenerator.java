package app.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.modules.output.table.html.HtmlReportUtil;
import org.pentaho.reporting.engine.classic.core.util.LibLoaderResourceBundleFactory;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;



/**
 * This is the base class used with the report generation examples. It contains the actual <code>embedding</code>
 * of the reporting engine and report generation. All example embedded implementations will need to extend this class
 * and perform the following:
 * <ol>
 * <li>Implement the <code>getReportDefinition()</code> method and return the report definition (how the report
 * definition is generated is up to the implementing class).
 * <li>Implement the <code>getTableDataFactory()</code> method and return the data factory to be used (how
 * this is created is up to the implementing class).
 * <li>Implement the <code>getReportParameters()</code> method and return the set of report parameters to be used.
 * If no report parameters are required, then this method can simply return <code>null</code>
 * </ol>
 */
public  class ReportGenerator{
	  public ReportGenerator(){
	  }
	  
	  public static String creaHtmlReporte(String nombreReporte, Report parametrosReporte) throws Exception
	  {
	    ClassicEngineBoot.getInstance().start();
	    
	    String htmlString = null;
	    
	    Properties propiedades = new Properties();
	
	    /**Cargamos el archivo desde la ruta especificada*/
	    propiedades.load(new FileInputStream("C:/Users/Sicof/Desktop/WorkspaceSTS/ivomaV1/morrito.properties"));
	  
	    /**Obtenemos los parametros definidos en el archivo*/
	    String rutaReporte = propiedades.getProperty("rutaReporte");
	    String parImagen = propiedades.getProperty("rutaLogo");

	    String path =rutaReporte + nombreReporte;
	    File filePath = new File(path);
	    URL reportDefinition = filePath.toURI().toURL();
	    
	    try
	    {
	      ResourceManager manager = new ResourceManager();
	      manager.registerDefaults();
	      Resource res = manager.createDirectly(reportDefinition, MasterReport.class);
	      MasterReport reporte = (MasterReport)res.getResource();
	      LibLoaderResourceBundleFactory f = (LibLoaderResourceBundleFactory)reporte.getResourceBundleFactory();
	      f.setLocale(java.util.Locale.US);
	      if (parametrosReporte != null) {
	        String pathImg = parImagen;
	        parametrosReporte.agregaParametro("Par_RutaImagen", pathImg);
	        
	        agregraParametros(reporte, parametrosReporte);
	      }
	      

	      ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
	      HtmlReportUtil.createStreamHTML(reporte, byteArray);
	      htmlString = byteArray.toString();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      //htmlString = Constantes.htmlErrorReporte;
	    }
	    
	    return htmlString;
	  }
	  
	  private static void agregraParametros(MasterReport reporte, Report parametrosReporte) {
	    Iterator it = parametrosReporte.getParametros().entrySet().iterator();
	    while (it.hasNext()) {
	      Map.Entry e = (Map.Entry)it.next();
	      reporte.getParameterValues().put((String)e.getKey(), e.getValue());
	    }
	  }
	  
	  public static ByteArrayOutputStream creaPDFReporte(String nombreReporte, Report parametrosReporte) throws Exception
	  {
	    ClassicEngineBoot.getInstance().start();
	    Properties propiedades = new Properties();
	    
	    
	    /**Cargamos el archivo desde la ruta especificada*/
	    propiedades.load(new FileInputStream("C:/Users/Sicof/Desktop/WorkspaceSTS/ivomaV1/morrito.properties"));
	    /**Obtenemos los parametros definidos en el archivo*/
	    String rutaReporte = propiedades.getProperty("rutaReporte");
	    String parImagen = propiedades.getProperty("rutaLogo");
	    
	    
	    String path = rutaReporte + nombreReporte;
	    File f = new File(path);
	    URL reportDefinition = f.toURI().toURL();
	    

	    ByteArrayOutputStream byteArray = null;
	    try
	    {
	      ResourceManager manager = new ResourceManager();
	      manager.registerDefaults();
	      Resource res = manager.createDirectly(reportDefinition, MasterReport.class);
	      MasterReport reporte = (MasterReport)res.getResource();
	      
	      if (parametrosReporte != null)
	      {
	        String pathImg =parImagen;
	        parametrosReporte.agregaParametro("Par_RutaImagen", pathImg);
	        
	        agregraParametros(reporte, parametrosReporte);
	      }
	      byteArray = new ByteArrayOutputStream();
	      org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfReportUtil.createPDF(reporte, byteArray);

	    }
	    catch (Exception e)
	    {

	      e.printStackTrace();
	      //htmlString = Constantes.htmlErrorReporte;
	    }
	    
	    return byteArray;
	  }
	
	
}