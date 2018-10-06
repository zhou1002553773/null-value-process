package com.example.web;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan("com.example.**.mapper.")
public class NullValueProcessWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NullValueProcessWebApplication.class, args);
    }

    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    // 配置事物管理器
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public OffsetLimitInterceptor offsetLimitInterceptor(){
        OffsetLimitInterceptor page = new OffsetLimitInterceptor();
        page.setDialectClass("com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect");
        return page;
    }
}
