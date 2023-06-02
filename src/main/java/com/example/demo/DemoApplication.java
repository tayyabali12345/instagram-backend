package com.example.demo;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.config.CloudinaryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		System.out.println("helllllllllllllll");
//
//
//
//		Cloudinary cloudinary = CloudinaryConfig.getInstance();
//
//		File imageFile = new File("/home/dev/Desktop/cloud.jpeg");
//
//
//
//		JFileChooser fileChooser = new JFileChooser();
//
//		// Display the file chooser dialogue
//		int returnValue = fileChooser.showOpenDialog(null);
//
//		if (returnValue == JFileChooser.APPROVE_OPTION) {
//			// Get the selected file
//			File selectedFile = fileChooser.getSelectedFile();
//
//			// Upload the image to Cloudinary
//			try {
//				// Upload the image
//				ApiResponse response = cloudinary.uploader().upload(selectedFile, ObjectUtils.emptyMap());
//
//				// Retrieve the public URL of the uploaded image
//				String imageUrl = (String) response.get("secure_url");
//
//				// Print the URL
//				System.out.println("Image URL: " + imageUrl);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//
//
//
//
//
//
//		try {
//			// Upload image
//			Map<?, ?> uploadResult = cloudinary.uploader().upload(imageFile, ObjectUtils.emptyMap());
//
//			// Get the URL of the uploaded image
//			String imageUrl = (String) uploadResult.get("secure_url");
//
//			System.out.println("Image uploaded successfully. URL: " + imageUrl);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}


//		JFileChooser fileChooser = new JFileChooser();
//
//		// Display the file chooser dialogue
//		int returnValue = fileChooser.showOpenDialog(null);
//
//		if (returnValue == JFileChooser.APPROVE_OPTION) {
//			// Get the selected file
//			File selectedFile = fileChooser.getSelectedFile();
//
//			// Upload the image to Cloudinary
//			try {
//				// Upload the image
//
//				ApiResponse response = cloudinary.uploader().upload(selectedFile, ObjectUtils.emptyMap());
//
//				// Retrieve the public URL of the uploaded image
//				String imageUrl = (String) response.get("secure_url");
//
//				// Print the URL
//				System.out.println("Image URL: " + imageUrl);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

	}
}
