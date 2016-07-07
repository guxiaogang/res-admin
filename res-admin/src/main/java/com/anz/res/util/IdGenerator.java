package com.anz.res.util;

import java.util.Date;

/**
 * @Description:
 * @author gyg
 * @date 2016
 * @version v1.0
 */

public class IdGenerator {
	
	private IdGenerator() {

	}

	public static Long generateId() {
		return new Date().getTime();
	}
}
