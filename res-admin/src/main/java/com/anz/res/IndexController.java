package com.anz.res;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author gyg
 * @date 2015
 * @version v1.0
 */

@RestController
public class IndexController {

	@RequestMapping("/")
	public String index(@RequestParam(value = "name", required = false, defaultValue = "Res Admin") String name) {
		return "Welcome " + name;
	}

}
