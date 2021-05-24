package com.saic.meeting.web.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author RSD
 * <p>
 * 2018年10月12日 -- 上午8:59:25
 */
@Component
@Configuration
@MapperScan("com.saic.meeting.dao")
public class DataSourceConfig {

	@Autowired
	private DataSource dataSource;

    /**
     * 分页插件
     *
     * @return
     */
//    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setDialectType(DBType.ORACLE.getDb());
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }

	@Bean
	public MybatisSqlSessionFactoryBean sqlSessionFactory() throws Exception {
		MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
		bean.setDataSource(dataSource);
//		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		bean.setTypeAliasesPackage("com.saic.meeting.model");

		GlobalConfiguration globalConfig = new GlobalConfiguration();
		//#主键类型 0：“数据库自增长”，1：“用户输入id”，2：“全局唯一id（数字类型唯一id）”，3：“全局唯一id（UUID）
		globalConfig.setIdType(IdType.UUID.getKey());
		globalConfig.setFieldStrategy(FieldStrategy.NOT_EMPTY.getKey());
		//#驼峰下划线转换
		globalConfig.setDbColumnUnderline(true);
		globalConfig.setSqlInjector(new com.baomidou.mybatisplus.mapper.LogicSqlInjector());
		//#配置逻辑删除字段为1是删除
//		globalConfig.setLogicDeleteValue(MybatisLogicDeleteEnum.LOGIC_DELETE.getValue());
		//#配置逻辑删除字段为0是未删除
//		globalConfig.setLogicNotDeleteValue(MybatisLogicDeleteEnum.LOGIC_NOT_DELETE.getValue());

//		globalConfig.setMetaObjectHandler(fillHandler());
		bean.setGlobalConfig(globalConfig);

		MybatisConfiguration configuration = new MybatisConfiguration();
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCacheEnabled(true);
		//#配置JdbcTypeForNull, oracle数据库必须配置
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.addInterceptor(paginationInterceptor());
		bean.setConfiguration(configuration);

		return bean;
	}

	/**
	 * 事务管理
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}

}
