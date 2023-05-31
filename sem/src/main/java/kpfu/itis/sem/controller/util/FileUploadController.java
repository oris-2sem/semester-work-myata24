//package kpfu.itis.sem.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Controller
//@RequestMapping("/storage/*")
//public class FileUploadController {
//
//    private String storagePath;
//
//    @GetMapping
//    public void getPicture() throws IOException {
//        String fileName = req.getPathInfo().substring(1);
//
//        InputStream inputStream = new FileInputStream(storagePath + "\\" + fileName);
//
//        byte[] imageBytes = inputStream.readAllBytes();
//        resp.setContentType(getServletContext().getMimeType("image/jpeg"));
//        resp.getOutputStream().write(imageBytes);
//    }
//
//
//}
