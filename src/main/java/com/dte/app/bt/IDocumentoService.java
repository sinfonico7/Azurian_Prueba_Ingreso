package com.dte.app.bt;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dte.app.dl.entity.Documento;


public interface IDocumentoService {
	
	public List<Documento> findAll();
	
	public Page<Documento> findAll(Pageable pageable);
	
	public void save(Documento documento);
	
	public Documento findOne(Long id);
	
	public void delete(Long id);
	

}
