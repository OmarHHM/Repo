package app.dao;

import app.model.*;

public interface SaleDao {

	public MessageTransaction save(Ventas sales);
	public MessageTransaction update(Ventas sales);
	public MessageTransaction delete(Ventas sales);
	public MessageTransaction refundByProduct(ArticulosVendidos soldProducts,long id);
	public MessageTransaction saveSoldProducts(ArticulosVendidos soldProducts, long id);
	public Ventas getAll(Ventas sales);
	public Object[] listSales(String filter);
	public Object[] listSalesWithProducts(long id);
	
}
