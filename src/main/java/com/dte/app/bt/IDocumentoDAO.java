package com.dte.app.bt;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dte.app.dl.entity.Documento;

public interface IDocumentoDAO extends PagingAndSortingRepository<Documento, Long> {

}
