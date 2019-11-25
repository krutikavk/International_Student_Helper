
package com.isshelper.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class IssHelperMailNotificationHelper {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmailtoStudent(String studentEmail, String rideProviderEmail, String address,
			long studentPhoneNumber, long rideProviderPhoneNumber, String rideProviderName, String studentName,
			String date, String time, String from, int zip) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("intlstudenthelper@gmail.com");
		msg.setTo(studentEmail);

		msg.setSubject("Your Ride Is Confirmed for: " + date);
		msg.setText("Hello " + studentName + " , we are happy to help you." + System.lineSeparator()
				+ " Your ride from " + from + " to " + address + " " + zip + System.lineSeparator() + "for Date: "
				+ date + "at time: " + time + " is confirmed." + System.lineSeparator() + System.lineSeparator()
				+ "Your RideProvider is: " + rideProviderName + "." + System.lineSeparator() + System.lineSeparator()
				+ "RideProviderEmail: " + rideProviderEmail + "." + System.lineSeparator() + System.lineSeparator()
				+ "RideProvider Phone number: " + rideProviderPhoneNumber + System.lineSeparator()
				+ System.lineSeparator() + "Please contact your ride provider prior to your journey."
				+ System.lineSeparator() + "Have a safe journey!" + System.lineSeparator() + System.lineSeparator()
				+ "Thanks and Regards," + System.lineSeparator() + "ISSHelper Team." + System.lineSeparator());

		javaMailSender.send(msg);

	}

	public void sendEmailtoRideProvider(String studentEmail, String rideProviderEmail, String address,
			long studentPhoneNumber, long rideProviderPhoneNumber, String rideProviderName, String studentName,
			String date, String time, String from, int zip) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(rideProviderEmail);

		msg.setSubject("Your Ride Is Confirmed for: " + date);
		msg.setText("Hello " + rideProviderName + ", we are happy to help you." + System.lineSeparator()
				+ "Your ride from " + from + " to " + address + " " + zip + System.lineSeparator() + "for Date: " + date
				+ " at time: " + time + " is confirmed." + System.lineSeparator() + System.lineSeparator()
				+ "Student for this ride is: " + studentName + "." + System.lineSeparator() + System.lineSeparator()
				+ "Student Email:" + studentEmail + "." + System.lineSeparator() + System.lineSeparator()
				+ "Student Phone number: " + studentPhoneNumber + System.lineSeparator() + System.lineSeparator()
				+ "Please contact student prior to your journey."+System.lineSeparator()+ "Have a safe journey!" + System.lineSeparator() + System.lineSeparator()
				+ "Thanks and Regards," + System.lineSeparator() + "ISSHelper Team." + System.lineSeparator());

		javaMailSender.send(msg);

	}
}
