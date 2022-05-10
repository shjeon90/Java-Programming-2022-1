
public class App {

	public static void main(String[] args) {
		MailServer mailServer = MailServer.getInstance();
		User user1 = new User("a@korea.ac.kr");
		User user2 = new User("b@korea.ac.kr");
		User user3 = new User("c@korea.ac.kr");
		User user4 = new User("d@korea.ac.kr");
		User user5 = new User("e@korea.ac.kr");
		
		mailServer.registerUser(user1);
		mailServer.registerUser(user2);
		mailServer.registerUser(user3);
		mailServer.registerUser(user4);
		mailServer.registerUser(user5);
		
		while (true) {
			user1.sendMail(mailServer);
			user2.sendMail(mailServer);
			user3.sendMail(mailServer);
			user4.sendMail(mailServer);
			user5.sendMail(mailServer);
			
			mailServer.distributeMail();
			
			user1.readMail();
			user2.readMail();
			user3.readMail();
			user4.readMail();
			user5.readMail();
		}
	}

}
