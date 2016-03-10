package com.smoothie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smoothie.beans.User;
import com.smoothie.beans.UserImage;
import com.smoothie.repositories.UserImageRepository;
import com.smoothie.repositories.UserRespository;

@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserRespository userRepo;

	@Autowired
	private UserImageRepository userImageRepo;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("repoCount", userRepo.count());
		return "greeting";
	}

	@RequestMapping("/")
	public String listing(Model model) {
		model.addAttribute("users", userRepo.findAllByOrderByFirstNameAscLastNameAsc());
		return "list";
	}

	@RequestMapping("/user/{userId}")
	public String profile(@PathVariable long userId, Model model) {
		model.addAttribute("user", userRepo.findOne(userId));

		List<UserImage> images = userImageRepo.findByUserId(userId);
		if (!CollectionUtils.isEmpty(images)) {
			model.addAttribute("userImage", images.get(0));
		}
		return "profile";
	}

	@RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.GET)
	public String profileEdit(@PathVariable long userId, Model model) {
		model.addAttribute("user", userRepo.findOne(userId));

		List<UserImage> images = userImageRepo.findByUserId(userId);
		if (!CollectionUtils.isEmpty(images)) {
			model.addAttribute("userImage", images.get(0));
		}
		return "profileEdit";
	}

	@RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.POST)
	public String profileSave(@ModelAttribute User user,
			@PathVariable long userId,
			@RequestParam(name = "removeImage", defaultValue = "false") boolean removeImage,
			@RequestParam("file") MultipartFile file,
			Model model) {

		log.debug("Saving user " + user);
		userRepo.save(user);
		model.addAttribute("message", "User " + user.getEmail() + " saved.");

		if (!file.isEmpty()) {
			try {
				List<UserImage> images = userImageRepo.findByUserId(user.getId());
				UserImage img = (images.size() > 0) ? images.get(0) : new UserImage(userId);
				img.setContentType(file.getContentType());
				img.setImage(file.getBytes());
				userImageRepo.save(img);

				log.debug("Saved Image");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		} else if (removeImage) {
			log.debug("Removing Image");
			// user.setImage(null);
			List<UserImage> images = userImageRepo.findByUserId(user.getId());

			for (UserImage img : images) {
				userImageRepo.delete(img);
			}
		}

		return profile(userId, model);
	}
}
