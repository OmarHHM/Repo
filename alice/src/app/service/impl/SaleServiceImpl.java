package app.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.SaleDao;
import app.model.ArticulosVendidos;
import app.model.MessageTransaction;
import app.model.Ventas;
import app.service.SaleService;
import app.utils.Report;
import app.utils.ReportGenerator;


@Service("saleService")
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleDao saleDao;
		
	@Transactional(rollbackFor=Exception.class)
	public MessageTransaction save(Ventas sales) {
		MessageTransaction ms= new MessageTransaction();
		ms=	saleDao.save(sales);		
		sales.setId(ms.getIdResult());
			
		if(sales.getProductoID()!=null && sales.getProductoID().length!=0){
			for (int i=0; i<sales.getProductoID().length;i++){
				ArticulosVendidos articulosVendidos = new ArticulosVendidos();
				articulosVendidos.setUnidadesVendidas(sales.getExistencias()[i]);
				articulosVendidos.setProductID(sales.getProductoID()[i]);
				articulosVendidos.setSucursalID(sales.getSucursalID());
				ms=	saleDao.saveSoldProducts(articulosVendidos, sales.getId());
			}
		}	
		
	    ms.setIdResult(Integer.valueOf(String.valueOf(sales.getId())));
		return ms;
	}
	
	public Ventas getAll(Ventas sales) {
		return saleDao.getAll(sales);
	}

	@Transactional(rollbackFor=Exception.class)
	public MessageTransaction delete(Ventas sales) {
		MessageTransaction ms= new MessageTransaction();
		ms=	saleDao.delete(sales);		

		System.out.println("message service :"+ ms.getMessage());

		return ms;
	}

	@Transactional(rollbackFor=Exception.class)
	public MessageTransaction refundByProduct(Ventas sales) {
		MessageTransaction ms= new MessageTransaction();
		if(sales.getArticulosVendidos()!=null){
			Iterator<ArticulosVendidos> it = sales.getArticulosVendidos().iterator();
			while(it.hasNext()){
				ArticulosVendidos soldProducts = new ArticulosVendidos();
				soldProducts=it.next();
				ms=	saleDao.refundByProduct(soldProducts,sales.getId());
			}
		}
		return ms;
	}

	public Object[] listSales(String filter){
		return saleDao.listSales(filter);
	}
	
	public Object[] listSalesWithProducts(long id){
		return saleDao.listSalesWithProducts(id);
	}

	public ByteArrayOutputStream reportSale(String nameReport, HttpServletRequest request) {
		ByteArrayOutputStream out=null;
		Report parametrosReporte = new Report();
		try {
			 parametrosReporte.agregaParametro("Par_Sucursal", request.getParameter("vendedor"));
			 parametrosReporte.agregaParametro("Par_NombreVendedor",request.getParameter("sucursal"));
			 parametrosReporte.agregaParametro("Par_Folio",request.getParameter("folio"));
	
			out= 	ReportGenerator.creaPDFReporte(nameReport+".prpt",  parametrosReporte );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
}
