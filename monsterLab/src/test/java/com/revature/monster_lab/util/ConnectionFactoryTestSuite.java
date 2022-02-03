package com.revature.monster_lab.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import com.revature.monster_lab.util.datasource.ConnectionFactory;

public class ConnectionFactoryTestSuite {

	@Test
	public void test_getConnection_returnValidConnection_givenProvidenCredentials() {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println(conn);
			Assert.assertNotNull(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
