package com.example.demo.config;

import com.cloudinary.Cloudinary;

public class CloudinaryConfig {
    public static Cloudinary getInstance() {
        Cloudinary cloudinary = new Cloudinary(Cloudinary.asMap(
                "cloud_name", "dowlid60o",
                "api_key", "824288453657451",
                "api_secret", "FGSmAQM10rffCBc0F2XBC_aShvE"
        ));
        return cloudinary;
    }
}

