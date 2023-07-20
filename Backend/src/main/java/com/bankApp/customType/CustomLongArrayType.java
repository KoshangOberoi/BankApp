package com.bankApp.customType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class CustomLongArrayType implements UserType {

	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return new int[] { Types.VARCHAR };
	}

	@Override
	public Class<?> returnedClass() {
		// TODO Auto-generated method stub
		return Long[].class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		// TODO Auto-generated method stub
		if (x instanceof Long[] && y instanceof Long[]) {
			return Arrays.deepEquals((Long[]) x, (Long[]) y);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		// TODO Auto-generated method stub
		return Arrays.hashCode((Long[]) x);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws SQLException {
		String value = rs.getString(names[0]);
		if (value != null) {
			String[] tokens = value.split(",");
			Long[] array = new Long[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				array[i] = Long.parseLong(tokens[i]);
			}
			return array;
		}
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws SQLException {
		if (value != null) {
            Long[] array = (Long[]) value;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i < array.length - 1) {
                    sb.append(",");
                }
            }
            st.setString(index, sb.toString());
        } else {
            st.setNull(index, sqlTypes()[0]);
        }
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		if (value == null) {
			return null;
		}
		Long[] a = (Long[]) value;
		return Arrays.copyOf(a, a.length);
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return original;
	}

}
