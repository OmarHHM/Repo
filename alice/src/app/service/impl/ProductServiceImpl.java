package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.ProductDao;
import app.model.InventarioProductos;
import app.model.MessageTransaction;
import app.model.Productos;
import app.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Transactional(rollbackFor = Exception.class)
	public MessageTransaction save(Productos products) {
		MessageTransaction ms = new MessageTransaction();
		ms = productDao.save(products);

		products.setId(ms.getIdResult());

		if (products.getNoExistencias() != null && products.getNoExistencias().length != 0) {

			for (int i = 0; i < products.getNoExistencias().length; i++) {
				InventarioProductos inventario = new InventarioProductos();
				inventario.setProductID(products.getId());
				inventario.setNoExistencias(products.getNoExistencias()[i]);
				inventario.setObservaciones("");

				// se obtiene la sucursal
				if (products.getNoSucursales() == 0) {
					inventario.setSucursalID(0);

				} else {
					inventario.setSucursalID(products.getSucursalID()[i]);
				}

				ms = productDao.saveInv(inventario);

				if (products.getNoSucursales() == 0) {
					break;
				}
			}
		}

		return ms;
	}

	@Transactional(rollbackFor = Exception.class)
	public MessageTransaction update(Productos products) {
		MessageTransaction ms = new MessageTransaction();
		ms = productDao.update(products);

		return ms;
	}
	
	public Productos getAll(Productos products) {
		Productos pro = productDao.getAll(products);
		return pro;
	}
	public Object[] listProducts(String filtro, int sucursal) {
		return productDao.listProducts(filtro, sucursal);
	}
	public Object[] comboBoxCat(int tipo) {
		if (tipo == 1) {
			return productDao.comboBoxCatUnid(tipo);
		} else if (tipo == 2) {
			return productDao.comboBoxCatMarc(tipo);
		} else if (tipo == 3) {
			return productDao.comboBoxCatCla(tipo);
		}

		return null;
	}
	
	public Object[] lstSucursalesProducto(int id) {
		return productDao.listInv(id);
	}

	public MessageTransaction updateInv(Productos products) {
		MessageTransaction ms = new MessageTransaction();
		InventarioProductos inv = new InventarioProductos();
		
		inv.setNoExistencias(products.getNoNuevasUnidades());
		inv.setProductID(products.getIdProductSelec());
		inv.setSucursalID(products.getSucursalDisponible());
		inv.setTipoActInv(3);
		
		ms = productDao.updateInv(inv);
		
		return ms;
	}

}
