package com.regional.property.servicesSolr;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.regional.property.solrRepository.Book;

@Repository
public interface BookRepository extends SolrCrudRepository<Book, String> {

	List<Book> findByName(String name);
	
	@Highlight(prefix = "<highlight>", postfix = "</highlight>")
	HighlightPage<Book> findByDescription(String description, Pageable pageable);
}