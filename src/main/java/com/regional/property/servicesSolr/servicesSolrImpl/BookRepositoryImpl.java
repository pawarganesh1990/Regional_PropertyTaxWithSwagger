package com.regional.property.servicesSolr.servicesSolrImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.query.result.FacetEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightEntry.Highlight;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.regional.property.servicesSolr.BookRepository;
import com.regional.property.solrRepository.Book;


@Repository
public class BookRepositoryImpl implements BookRepository{

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Book> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Book> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Book arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Book> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Book> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Book> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Book> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HighlightPage<Book> findByDescription(String description,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}/*

	@Autowired
	private BookRepository bookRepository;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Iterable<Book> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Book> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void delete(Book arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void delete(Iterable<? extends Book> arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable<Book> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Book findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Book> S save(S arg0) {
		Book book=(Book)arg0;
		return (S) book;

	}


	@Override
	public <S extends Book> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name)	;

	}


	@Override
	public HighlightPage<Book> findByDescription(String description,
			Pageable pageable) {
		HighlightPage<Book> booksHighlightPage = bookRepository.findByDescription("cookies", new PageRequest(0, 10));
		return booksHighlightPage;
	}


*/}