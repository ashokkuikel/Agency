package com.mytrekadvisor.web.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mytrekadvisor.web.dao.Category;
import com.mytrekadvisor.web.dao.Photo;
import com.mytrekadvisor.web.dao.Post;
import com.mytrekadvisor.web.service.CategoryService;

@Controller
public class FileUploadController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ServletContext servletContext;
	
	CsvReaderUtil csvReaderUtil = null;
	private String saveDirectory = "D:\\file\\";
	
	@RequestMapping(value = "fileUpload", method = RequestMethod.GET)
	public String showFileUpload(Model model) {

		List<Category> category = new ArrayList<Category>();
		category = categoryService.getAllCategory();

		model.addAttribute("categories", category);
		return "fileupload";
	}						

	@RequestMapping(method = RequestMethod.POST, value = "uploadFile")
	public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload, @RequestParam("categoryName") String categoryName,Model model)
			throws Exception {


		// retrieve class ko object categoryName liyera

		System.out.println("description: " + request.getParameter("description"));

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}

		//COde for Adding CLass selected to the students data uploaded via csv file
		
		csvReaderUtil = new CsvReaderUtil();
		// String webappRoot = servletContext.getRealPath("/");
		 //String relativeFolder = webappRoot + "resources/images/" ;
		//String relativeFolder = "resources/images/" ;
		 //System.out.println("relativeFolder"+relativeFolder);
		Photo photo = new Photo( "default-icon.png","C:\\Users\\PC\\Springtest\\springmvc\\WebContent\\resources\\images\\");
		 //Photo photo = new Photo( "default-icon.png",relativeFolder);
		List<Post> students = csvReaderUtil.readCsv();
		
//		category.setStudents(students);
//
//		//For Lopping to set variable of a POJO object inside ArrayList
////		for (int i = 0; i < students.size(); i++) {
////			students.get(i).setStudentClass(category);
////			students.get(i).setPhoto(photo);
////
////		}
//		
//		for(Post student : students) {
//			student.setStudentClass(category);
//			student.setPhoto(photo);
//		}
//
//		classDao.createClass(category);
		
		/*categoryService.savePostsToCategory(categoryName, students, photo);*/
		return "result";
	}
}
