package com.api.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.InputDto.LoginDto;
import com.api.Service.AdminService;

@RequestMapping("/login/admin")
@RestController
public class LoginAdminController {
	
	@Autowired 
	AdminService adminService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public Boolean login(@RequestBody LoginDto credenciais) {
		return adminService.accessAdminPage(credenciais);
	}
}
