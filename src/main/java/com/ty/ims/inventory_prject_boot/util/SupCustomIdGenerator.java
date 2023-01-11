package com.ty.ims.inventory_prject_boot.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SupCustomIdGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "Sup-";
		Connection connection = session.connection();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select max(supplier_Id) as Id from Supplier");

			if (rs.next()) {
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();
				return generatedId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
