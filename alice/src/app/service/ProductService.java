package app.service;

import app.model.MessageTransaction;
import app.model.Productos;

public interface ProductService {
	public MessageTransaction save(Productos products);
	public MessageTransaction update(Productos products);
	public MessageTransaction updateInv(Productos products);
	
	public Productos getAll(Productos products);
	public Object[] listProducts(String filtro, int sucursal);
	public Object[] comboBoxCat(int tipo);
	public Object[] lstSucursalesProducto(int id);
	
}
