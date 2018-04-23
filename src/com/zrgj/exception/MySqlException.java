package com.zrgj.exception;

import java.sql.SQLException;

public class MySqlException extends SQLException {

	private static final long serialVersionUID = 4974256110840403826L;

	public MySqlException() {
		super();
	}

	public MySqlException(String reason) {
		super(reason);
	}

	
}
