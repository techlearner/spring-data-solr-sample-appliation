package com.lsi.lpidsearch.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableSolrRepositories("com.lsi.lpidsearch.repository")
@PropertySource("classpath:solrsearch.properties")
@EnableWebMvc
@ComponentScan(basePackages = {"com.lsi"})
public class AppContext {

	@Autowired private Environment environement;
	
	@Bean
	public EmbeddedSolrServerFactoryBean embededSolrServerFactoryBean() {
		EmbeddedSolrServerFactoryBean embeddedSolrServerFactoryBean = new EmbeddedSolrServerFactoryBean();
		embeddedSolrServerFactoryBean.setSolrHome(environement.getProperty("solr.server.url"));
		return embeddedSolrServerFactoryBean;
	}
	
	@Bean
	public SolrServer solrServer() {
		SolrServer solrServer = new HttpSolrServer(environement.getProperty("solr.server.url"));
		return solrServer;
	}
	
	@Bean
	public SolrTemplate solrTemplate() throws Exception {
		SolrTemplate solrTemplate = new SolrTemplate(solrServer());
		return solrTemplate;
	}
}
