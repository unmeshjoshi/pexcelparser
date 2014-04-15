package com.pubmatic.server;


import com.google.gson.Gson;
import com.pubmatic.parser.JsonBuilder;
import com.pubmatic.parser.Onboarding;
import com.pubmatic.parser.PublisherOnboardingExcelParser;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.ProtectionDomain;

public class PublisherOnboardingServer extends AbstractHandler {


    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        server.setHandler(new PublisherOnboardingServer());
        server.start();
        server.join();
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);

        PublisherOnboardingExcelParser parser = new PublisherOnboardingExcelParser();
        parser.parse(new FileInputStream(httpServletRequest.getParameter("fileName")));

        Onboarding onboardingDetails = parser.getOnboardingDetails();
        PrintWriter writer = httpServletResponse.getWriter();
        writer.println(new JsonBuilder().toJson(onboardingDetails));
        writer.flush();
    }
}
