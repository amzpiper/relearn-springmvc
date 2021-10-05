package com.kuang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author 郭宇航
 * @date 2021/10/5
 * @apiNote
 */
@RestController
public class FileController {

    /**
     * 第一种方式
     *
     * @param file
     * @param request
     * @return
     * @RequestParam("file")将name=file空间得到的文件封装成CommonsMultipartFile对象 批量上传CommonsMultipartFile变为数组即可
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名
        String uploadName = file.getOriginalFilename();
        System.out.println("文件名：" + uploadName);
        //判断是否为空
        if (uploadName == null) {
            return "redirect:/index.jsp";
        }

        //设置保存上传路径
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在创建
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }
        System.out.println("文件保存路径：" + realPath);

        //上传文件的输入流
        InputStream inputStream = file.getInputStream();
        //创建文件输出流
        OutputStream outputStream = new FileOutputStream(new File(realPath, uploadName));

        //读取和写入
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();

        return "ok";
    }

    @PostMapping("/upload2")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        //上传路径,获取运行时的工程存放目录
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }
        System.out.println("文件保存路径：" + realPath);

        //通过transferTo写入文件
        try {
            file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("文件保存错误");
            e.printStackTrace();
        }

        return "ok";
    }

    @GetMapping("/download")
    public String download(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //要下载的图片
        String path = request.getServletContext().getRealPath("/upload");
        String filename = "新建文本文档.txt";

        //1.设置response响应头
        response.reset();//设置页面不缓存，情况buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(filename,"UTF-8"));

        //2.读取文件
        File file = new File(path,filename);
        InputStream inputStream = new FileInputStream(file);
        
        //3.写出文件
        OutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int index = 0;
        while ((index = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, index);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return "ok";
    }
}
