/*
 ***************************************************************************************
 * EP for web developers.Supported By Junxworks
 * @Title:  Config.java   
 * @Package io.github.junxworks.ep.seed.config   
 * @Description: (用一句话描述该文件做什么)   
 * @author: Administrator
 * @date:   2021-2-28 17:19:39   
 * @version V1.0 
 * @Copyright: 2021 Junxworks. All rights reserved. 
 * 注意：
 *  ---------------------------------------------------------------------------------- 
 * 文件修改记录
 *     文件版本：         修改人：             修改原因：
 ***************************************************************************************
 */
package io.github.junxworks.ep.seed.config;

import org.apache.shiro.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.github.junxworks.ep.auth.cache.EPShiroMemCacheManager;

@Configuration
public class Config {

	/**
	 * 注入shiro缓存管理，这里默认开发环境为本地内存
	 * EP框架默认是redis缓存，如果是测试环境或者是生产环境，不用配置这个bean
	 *
	 * @return the cache manager
	 */
	@Bean
	@Profile("dev")
	public CacheManager epShiroMemCacheManager() {
		return new EPShiroMemCacheManager();
	}
}
