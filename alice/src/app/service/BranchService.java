package app.service;

import app.model.CatSucursales;

public interface BranchService {

	public CatSucursales save(CatSucursales suc);
	public CatSucursales update(CatSucursales suc);
	public CatSucursales delete(CatSucursales suc);
	public CatSucursales getAll(CatSucursales suc);
	public Object[] listBranchsAct(CatSucursales suc);
	
}
