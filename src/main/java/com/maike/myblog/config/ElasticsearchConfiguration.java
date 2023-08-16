package com.maike.myblog.config;

//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.env.Environment;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//import javax.annotation.Resource;
//
///**
// * @author geekcjj
// * @Description
// * @date 2020/4/4 10:37 下午
// * @Version 1.0
// */
//
//@Configuration
////@PropertySource(value = "classpath:elasticsearch.properties")
//@EnableElasticsearchRepositories(basePackages = "com.maike.myblog")
//public class ElasticsearchConfiguration {
//    @Resource
//    private Environment environment;
//    @Bean
//    public Client client() {
//        TransportClient client = new TransportClient();
//        TransportAddress address = new InetSocketTransportAddress("127.0.0.1", 8091);
//        client.addTransportAddress(address);
//        return client;
//    }
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchTemplate(client());
//    }
//
//}
