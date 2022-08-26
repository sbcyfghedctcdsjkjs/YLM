/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author sunjiv6
 */
//@WebServlet(
//	  name = "DataImageUploadServlet",
//	  description = "Servlet to upoad image and data using form in html",
//	  urlPatterns = {"/owner/upload/servlet"}
//	)
@MultipartConfig
public class DataImageUploadServlet  extends HttpServlet{
    
	    @Override
	    protected void doGet(
	      HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException {	 
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<p>Hello World!</p>");
	    }
            
            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                    response.setContentType("text/html;charset=UTF-8");
                    // Create path components to save the file
                    String ownerPhone = request.getParameter("ownerPhone");
                    String ownerEmail = request.getParameter("ownerEmail");
                    String secretNumber = request.getParameter("secretNumber");
                    Part filePart = request.getPart("inputFile01");
                    PrintWriter out = response.getWriter();
		    System.out.println(" ownerPhone: "+ownerPhone);
//                    out.println("<p>Hello World!</p> ownerPhone: "+ownerPhone
//                                +"\n filePart: "+filePart.getSubmittedFileName()
//                                +"\n getFileName(filePart): "+getFileName(filePart));                    
            }
            
            private String getFileName(final Part part) {
                final String partHeader = part.getHeader("content-disposition");
                //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
                for (String content : part.getHeader("content-disposition").split(";")) {
                    if (content.trim().startsWith("filename")) {
                        return content.substring(
                                content.indexOf('=') + 1).trim().replace("\"", "");
                    }
                }
                return null;
            }


}
