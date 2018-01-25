package com.mytrekadvisor.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mytrekadvisor.web.dao.Post;
public class CsvReaderUtil {
	
	
	public List<Post> readCsv() {
		
		 String csvFile = "D:\\file\\posts.csv";
		 List<Post> postData = new ArrayList<Post>();
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] postCsv = line.split(cvsSplitBy);
	                
	                Post post = new Post();
	                
	                post.setTitle(postCsv[0]);
	                post.setDescription(postCsv[1]);
	                post.setPrice(postCsv[2]);
	                postData.add(post);

	                System.out.println("Title [code= " + postCsv[0] + " , Description=" + postCsv[1] + ", Description="+ postCsv[2]+"]");
	            }
	            

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        
	        try {
	        	File file = new File("D:\\file\\posts.csv");
	        	file.delete();
	        } 
	        
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	        
	        System.out.println(postData.size());
			return postData;
			

	    }

}
