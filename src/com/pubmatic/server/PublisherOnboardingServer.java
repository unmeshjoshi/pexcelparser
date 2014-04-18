package com.pubmatic.server;


import com.pubmatic.parser.JsonBuilder;
import com.pubmatic.parser.Onboarding;
import com.pubmatic.parser.PublisherOnboardingExcelParser;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;

public class PublisherOnboardingServer extends AbstractHandler {


    private static final MultipartConfigElement MULTI_PART_CONFIG = new MultipartConfigElement(System.getProperty("java.io.tmpdir"));

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new PublisherOnboardingServer());
        server.start();
        server.join();
    }


    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        request.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, MULTI_PART_CONFIG);


        Part filePart = httpServletRequest.getPart("file");
        String uploadedFilePath = getUploadFilePath(filePart);
        System.out.println("Writing uploaded filePart to = " + uploadedFilePath);

        writeUploadedFileContent(filePart, uploadedFilePath);

        Onboarding onboardingDetails = parse(uploadedFilePath);
        String json = new JsonBuilder().toJson(onboardingDetails);

        System.out.println("Writing json back = " + uploadedFilePath);


        writeResponse(httpServletResponse, json);
        request.setHandled(true);

    }

    private void writeResponse(HttpServletResponse httpServletResponse, String json) throws IOException {
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.println(json);
        writer.flush();
    }

    private String getUploadFilePath(Part file) {
        String fileName = new ContentDispositionHeader(file.getHeader("content-disposition")).getFileName();
        return "/home/unmesh" + File.separator
                + new Random().nextInt(1000000) + fileName;
    }

    private Onboarding parse(String uploadedFilePath) throws IOException {
        System.out.println("Parsing file = " + uploadedFilePath);
        PublisherOnboardingExcelParser parser = new PublisherOnboardingExcelParser();
        parser.parse(new FileInputStream(uploadedFilePath));

        return parser.getOnboardingDetails();
    }

    private void writeUploadedFileContent(Part file, String uploadedFilePath) throws IOException {
        FileOutputStream uploadedFile = new FileOutputStream(new File(uploadedFilePath));
        InputStream fileContent = file.getInputStream();
        final byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = fileContent.read(bytes)) != -1) {
            uploadedFile.write(bytes, 0, read);
        }
    }
}
