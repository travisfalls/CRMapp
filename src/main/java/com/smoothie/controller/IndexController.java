package com.smoothie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smoothie.repositories.UserRespository;

@Controller
public class IndexController {

	@Autowired
	private UserRespository userRepo;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("repoCount", userRepo.count());
		return "greeting";
	}

	@RequestMapping("/")
	public String listing(String name, Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "list";
	}
}
