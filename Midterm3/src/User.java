import java.util.Scanner;

public class User {
	private Mail[] mailBox;
	private String address;
	private int numOfMailsInBox;
	
	public User(String address) {
		this.address = address;
		this.mailBox = new Mail[10];
		this.numOfMailsInBox = 0;
		for (int i = 0;i < this.mailBox.length;++i) {
			this.mailBox[i] = null;
		}
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void receiveMail(Mail mail) {
		if (this.numOfMailsInBox < 10) this.mailBox[this.numOfMailsInBox++] = mail;
		else System.out.println("cannot receive the email any more.");
	}
	
	public void readMail() {
		System.out.println("- read the mails, user: " + this.address);
		for (int i = 0;i < this.numOfMailsInBox;++i) {
			System.out.println(this.mailBox[i].toString());
		}
		this.numOfMailsInBox = 0;
	}
	
	public void sendMail(MailServer mailServer) {
		Scanner scan = new Scanner(System.in);
		System.out.println("- writing an email, sender: " + this.address);
		System.out.println("do you want to send email?");
		String choice = scan.nextLine();
		if (choice.equals("yes")) {
			System.out.print("- receiver: ");
			String receiver = scan.nextLine();
			System.out.print("- title: ");
			String title = scan.nextLine();
			System.out.print("- contents: ");
			String contents = scan.nextLine();
			
			Mail mail = new Mail(this.address, receiver, title, contents);
			mailServer.takeMailFromUser(mail);
		}
	}
}
