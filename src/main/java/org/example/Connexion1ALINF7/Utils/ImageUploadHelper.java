package org.example.Connexion1ALINF7.Utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ImageUploadHelper {
    private Cloudinary cloudinary;

    public ImageUploadHelper() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dmq1chqss",
                "api_key", "635414379795592",
                "api_secret", "D0ZmpEDJ0p-yggQt-bnSiBEdjho",
                "secure", true));
    }


    public String upload(File multipartFile) throws Exception {
        try {
            Map<String, String> optionsMap = new HashMap<>();
            Map result = cloudinary.uploader().upload(multipartFile, optionsMap);
            return result.get("secure_url").toString();
        } catch (Exception e) {
            throw new Exception("Erreur lors de l'upload de l'image");
        }
    }
}
