package com.young.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file
            , HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/fileDownload")
    public String fileDownload(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "基础语法.jpg";

        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        response.setHeader("Content-Disposition", "attachment;filename=" +
                URLEncoder.encode(fileName, "utf-8"));

        File file = new File(path, fileName);
        FileInputStream fileInputStream = new FileInputStream(file);

        ServletOutputStream outputStream = response.getOutputStream();

        byte[] bytes = new byte[1024];
        int index = 0;

        while ((index = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, index);
            outputStream.flush();
        }

        outputStream.close();
        fileInputStream.close();
        return null;
    }
}
