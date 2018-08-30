package app.dao;

import app.model.*;

public interface ProductDao {
	
	public MessageTransaction save(Productos products);
	public MessageTransaction update(Productos products);
	public Productos getAll(Productos products);	
	public Object[] listProducts(String filter,int sucursal);
	public MessageTransaction saveInv(InventarioProductos pr);
	public Object[]	comboBoxCatUnid(int tipo);
	public Object[]	comboBoxCatMarc(int tipo);
	public Object[]	comboBoxCatCla(int tipo);
	public Object[] listInv(int productID);
	public MessageTransaction updateInv(InventarioProductos products);
	
}
