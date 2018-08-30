package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.BranchDao;
import app.model.CatSucursales;
import app.service.BranchService;

@Service("branchService")
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchDao branchDao;
	
	
	public CatSucursales save(CatSucursales suc) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CatSucursales update(CatSucursales suc) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CatSucursales delete(CatSucursales suc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CatSucursales getAll(CatSucursales suc) {
		return branchDao.getAll(suc);
	}

	public Object[] listBranchsAct(CatSucursales suc) {
		return branchDao.listBranchsAct(suc);
	}

}
