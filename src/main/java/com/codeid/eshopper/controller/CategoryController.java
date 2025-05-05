package com.codeid.eshopper.controller;

import com.codeid.eshopper.entities.Category;
import com.codeid.eshopper.service.CategoryService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String showCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "modules/category/category.html"; // name of the HTML template to render
    }
    
    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("action", "Add Category");
        return "/modules/category/addEdit.html";
    }

    @PostMapping("/add")
    public String postCategory(@Valid Category category,BindingResult result, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()){
            return "/modules/category/addEdit.html";
        }

        categoryService.addCategory(category);

        redirectAttrs.addFlashAttribute("message", "Category "+category.getName()+" created!");
		return "redirect:/category/";
    }

    @GetMapping("edit/{id}")
	public String updateCategoryById(@PathVariable("id") long id,Model model) {

		Optional<Category> category = categoryService.getCategoryById(id);

		model.addAttribute("action", "Edit Category");
		model.addAttribute("category", category.get());
		return "modules/category/addEdit.html";

	}


    @GetMapping("delete/{id}")
	public String deleteCategory(@PathVariable(name = "id") Long id,RedirectAttributes redirectAttrs) {
		categoryService.deleteCategory(id);
		redirectAttrs.addFlashAttribute("message", "id "+id+" has been delete!");
		return "redirect:/category/";
	}
    
    
}

