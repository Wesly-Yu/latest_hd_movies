package com.new_movies.latest_hd_movies.config;
import org.springframework.beans.factory.annotation.Value;
import	java.awt.Component;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@ComponentScan(basePackages ={"com.gitee.sunchenbin.mybatis.actable.manager.*"})
public class MybatisMapperScannerConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String useraccount;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSourceTransactionManager  dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

    }



}
