/*
 * package com.isshelper.utils;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.mail.SimpleMailMessage; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.stereotype.Service;
 * 
 * @Service public class IssHelperMailNotificationHelper {
 * 
 * @Autowired private JavaMailSender javaMailSender;
 * 
 * void sendEmailtoStudents(ArrayList<Student> students) {
 * 
 * for (Student student : students) { SimpleMailMessage msg = new
 * SimpleMailMessage(); msg.setTo(student.getS_Email());
 * 
 * msg.setSubject("Your Ride Is Confirmed");
 * msg.setText("Hello from ISSHelper, We are here for you. Your Ride for"
 * +"is confirmed and will be there to pick you at"+"have a safe travel");
 * 
 * javaMailSender.send(msg);
 * 
 * }
 * 
 * }
 * 
 * 
 * public void sendEmailtoStudents() {
 * 
 * SimpleMailMessage msg = new SimpleMailMessage();
 * msg.setTo("samik.biswas@sjsu.edu");
 * 
 * msg.setSubject("Your Ride Is Confirmed");
 * msg.setText("WHERE ARE YOU GUYS??");
 * 
 * javaMailSender.send(msg);
 * 
 * }
 * 
 * }
 */