package app.service;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;

import app.model.*;

public interface SaleService {
	
	/**
	 * Metodo Guarda ventas
	 * Return Object*/
	public MessageTransaction save(Ventas sales);
	
	/**
	 * Metodo Cancela ventas
	 * Return Object*/
	public MessageTransaction delete(Ventas sales);
	
	/**
	 * Metodo Devolucion por productos 
	 * Return Object*/
	public MessageTransaction refundByProduct(Ventas sales);
	
	public ByteArrayOutputStream reportSale(String nameReport,HttpServletRequest request);
	public Ventas getAll(Ventas sales);
	public Object[] listSales(String filter);
	public Object[] listSalesWithProducts(long id);
}
