package com.lhb.shiro;

import java.util.LinkedHashMap;

/**
 * shiro 过滤 工厂类
 * @author Administrator
 *
 */
public class FilterFactory {
	public LinkedHashMap<String, Object> getFilter(){
		LinkedHashMap<String, Object> filteMap = new LinkedHashMap<String, Object>();
		
		// shiro 具有优先匹配原则  故该键值必须以指定顺序进行封装
		filteMap.put("/spring/login","anon" );
		filteMap.put("/spring/user","authc,roles[admin]" );
		filteMap.put("/spring/music","authc,roles[user]" );
		filteMap.put("/spring/logout","logout" );
		filteMap.put("/unauthorized.jsp","anon" );
		filteMap.put("/**", "authc");
		return filteMap;
	}
}
