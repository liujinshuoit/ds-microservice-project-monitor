package com.das.consultation.config.data;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * created by jun on 2020/8/14
 * describe:动态数据源配置
 * version 1.0
 */
@Configuration
public class DynamicDataSourceConfig {

    /**
     * 创建 DataSource Bean
     * */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.dzbl")
    public DataSource dzblDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 如果还有数据源,在这继续添加 DataSource Bean
     * */
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource dzblDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceNames.DZBL, dzblDataSource);
        // 还有数据源,在targetDataSources中继续添加
//        System.out.println("DataSources:" + targetDataSources);
        return new DynamicDataSource(dzblDataSource, targetDataSources);
    }
}
