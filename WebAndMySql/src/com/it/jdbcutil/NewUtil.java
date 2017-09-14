package com.it.jdbcutil;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class NewUtil {
	private static ComboPooledDataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static QueryRunner getQueryRunner() {
		
		QueryRunner qr = new QueryRunner(dataSource);
		return qr;
	}
	
	
}
