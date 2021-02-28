/*
 ***************************************************************************************
 * EP for web developers.Supported By Junxworks
 * @Title:  DataSourceConfig.java   
 * @Package io.github.junxworks.ep.seed.config   
 * @Description: (用一句话描述该文件做什么)   
 * @author: Administrator
 * @date:   2021-2-28 17:17:44   
 * @version V1.0 
 * @Copyright: 2021 Junxworks. All rights reserved. 
 * 注意：
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package io.github.junxworks.ep.seed.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import io.github.junxworks.ep.core.ds.DynamicDataSource;
import io.github.junxworks.ep.core.ds.DynamicDataSourceBuilder;

/**
 * 数据源注入配置
 *
 * @ClassName:  DataSourceConfig
 * @author: Michael
 * @date:   2021-2-28 17:17:44
 * @since:  v1.0
 */
@Configuration
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.druid.main")
	public DataSource mainDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public DynamicDataSource dynamicDataSource(DataSource mainDataSource) {
		return DynamicDataSourceBuilder.create().setPrimarySource("main", mainDataSource).build();
	}
	
	/* 多数据源配置
	@Bean
	@ConfigurationProperties("spring.datasource.druid.xxx")
	public DataSource xxxDataSource()
	{
	    return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public DynamicDataSource dynamicDataSource(DataSource mainDataSource,DataSource xxxDataSource)
	{
	    return DynamicDataSourceBuilder.create().setPrimarySource("main", mainDataSource).addDataSource("xxx", xxxDataSource)..build();
	}
	
	*/

}
