package io.github.junxworks.ep.seed;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import io.github.junxworks.ep.core.EnableGlobalExceptionHandler;
import io.github.junxworks.ep.core.ds.EnableDynamicDataSource;
import io.github.junxworks.ep.core.security.access.EnableAccessFilter;
import io.github.junxworks.ep.core.security.sql.EnableSQLFilter;
import io.github.junxworks.ep.core.security.xss.EnableXSSFilter;
import io.github.junxworks.ep.core.utils.SpringContextUtils;
import io.github.junxworks.ep.fs.annotation.EnableEPFS;
import io.github.junxworks.ep.scheduler.annotations.EnableEPScheduler;
import io.github.junxworks.ep.sys.annotations.EnableEPSys;

@EnableSQLFilter //开启防SQL注入
@EnableXSSFilter //开启防XSS攻击
@EnableAccessFilter //开启访问日志
@EnableGlobalExceptionHandler //开启全局异常捕获
@EnableDynamicDataSource //开启EP数据源配置
@EnableEPSys //开启EP基础系统，含人员管理、菜单管理等基础功能，其他模块注解要在这个注解下面
@EnableEPScheduler //开启EP定时任务，需要事先开启EP基础系统
@EnableEPFS //开启文件服务器
@Import({ SpringContextUtils.class })
@MapperScan(basePackages = { "io.github.junxworks.ep.*" }, annotationClass = Mapper.class) //io.github.junxworks.ep是ep的mapper扫苗，还可以添加项目自身的mapper扫描，如com.xxx.ccc.mapper
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class JunxEpSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunxEpSeedApplication.class, args);
	}

}
