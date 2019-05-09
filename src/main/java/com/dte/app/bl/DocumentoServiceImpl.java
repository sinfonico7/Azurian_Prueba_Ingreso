package com.dte.app.bl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dte.app.bt.IDocumentoDAO;
import com.dte.app.bt.IDocumentoService;
import com.dte.app.dl.entity.Documento;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

	
	@Autowired
	private IDocumentoDAO documentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		return (List<Documento>)  documentoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Documento documento) {
		documentoDao.save(documento);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Documento> findAll(Pageable pageable) {
		return documentoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Documento findOne(Long id) {
		return documentoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		documentoDao.deleteById(id);
		
	}

	



}
