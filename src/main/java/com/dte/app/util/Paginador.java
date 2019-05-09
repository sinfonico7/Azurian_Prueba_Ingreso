package com.dte.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class Paginador<T> {

	private String url;
	private Page<T> page;
	private List<PageItem> paginas;
	
	int totalPaginas;
	int numElementosPorPaginas;
	int paginaActual;
	
	
	public Paginador(String url,Page<T> page) {
	this.url = url;
	this.page = page;
	this.paginas = new ArrayList<PageItem>();
	
	totalPaginas = page.getTotalPages();
	numElementosPorPaginas = page.getSize();
	paginaActual = page.getNumber() + 1;
	int desde,hasta;
	if(totalPaginas<=numElementosPorPaginas) {
		desde = 1;
		hasta = totalPaginas;
	}else {
		if(paginaActual <= numElementosPorPaginas / 2) {
			desde = 1;
			hasta = numElementosPorPaginas;
		}else if(paginaActual >= totalPaginas - numElementosPorPaginas/2) {
			desde = totalPaginas - numElementosPorPaginas + 1;
			hasta = numElementosPorPaginas;
		}else {
			desde = paginaActual - numElementosPorPaginas / 2;
			hasta = numElementosPorPaginas;
		}
	}
	for (int i = 0; i < hasta; i++) {
		paginas.add(new PageItem(desde+i,paginaActual == desde + i));
	}
	
		
	}


	public String getUrl() {
		return url;
	}


	public List<PageItem> getPaginas() {
		return paginas;
	}


	public int getTotalPaginas() {
		return totalPaginas;
	}


	public int getPaginaActual() {
		return paginaActual;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
	
}
