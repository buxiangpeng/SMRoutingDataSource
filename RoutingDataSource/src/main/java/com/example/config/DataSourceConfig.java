package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {

	@Bean(name = "readDataSource")
	@ConfigurationProperties(prefix = "datasource.read")
    public DataSource readDataSource() {
        return new DruidDataSource();
    }
	
	@Bean(name = "writeDataSource")
	@ConfigurationProperties(prefix = "datasource.write")
    public DataSource writeDataSource() {
        return new DruidDataSource();
    }
	

    @Bean(name = "writeOrReadTransactionManager")
	public DataSourceTransactionManager transactionManager(RoutingDataSouceImpl roundRobinDataSouceProxy) {
		//Spring 的jdbc事务管理器
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(roundRobinDataSouceProxy);
		return transactionManager;
	}
 
    @Bean
    public SqlSessionFactory clusterSqlSessionFactory(RoutingDataSouceImpl roundRobinDataSouceProxy)
            throws Exception {
    	
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(roundRobinDataSouceProxy);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 实体类对应的位置
		bean.setTypeAliasesPackage("com.example.model");
		// mybatis的XML的配置
		bean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		return bean.getObject();
    }
	
}
