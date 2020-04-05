package com.icypt.sboot.tags;
 
import java.util.HashSet;
import java.util.Set;
 
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
/**
 * PlatForm：冰点IT
 * projectName: Thymeleaf 学习
 * Author：icypt
 * CreateTime： 2020/1/19 16:17
 * Version：2.0
 * Description：注册自定义标签
 * URL: www.icypt.com
 */
@Component
public class CustomTag extends AbstractProcessorDialect{
	/**
	 * 定义方言名称
	 */
	private static final String NAME="系统自定义标签";
	
	/**
	 * 定义方言属性
	 */
	private static final String PREFIX="Fw";
	
	protected CustomTag() {
		super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
	}
 
	@Override
	public Set<IProcessor> getProcessors(final String dialectPrefix) {
		final Set<IProcessor> processor=new HashSet<>();
		//<bm:select>标签
		processor.add(new CustomTagSelect(PREFIX));
		return processor;
	}
}