package com.ppdai.demo.数据迁移性能优化.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.ppdai.demo.数据迁移性能优化.properties.DataSourceProperties;
import com.ppdai.demo.数据迁移性能优化.properties.DruidProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by huanglijun on 2017/8/9.
 */
@Configuration
@EnableConfigurationProperties({DataSourceProperties.class,DruidProperties.class})
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    // 精确到 dataSource 目录
    static final String PACKAGE = "com.ppdai.demo.数据迁移性能优化.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private DruidProperties druidProperties;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());


        dataSource.setInitialSize(druidProperties.getInitialSize());
        dataSource.setMinIdle(druidProperties.getMinIdle());
        dataSource.setMaxActive(druidProperties.getMaxActive());
        dataSource.setMaxWait(druidProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druidProperties.getValidationQuery());
        dataSource.setTestWhileIdle(druidProperties.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidProperties.isTestOnBorrow());
        dataSource.setTestOnReturn(druidProperties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druidProperties.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidProperties.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            dataSource.setFilters(druidProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties(druidProperties.getConnectionProperties());
        dataSource.setUseGlobalDataSourceStat(druidProperties.isUseGlobalDataSourceStat());

        return dataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
