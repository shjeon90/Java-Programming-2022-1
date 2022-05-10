
public class MailServer {
	private static final MailServer mailServer = new MailServer();
	private User [] users;
	private Mail[] mailBox;
	private int numOfMailsInBox;
	private int numOfUsers;
	
	public MailServer() {
		this.users = new User[5];
		this.mailBox = new Mail[10];
		this.numOfMailsInBox = 0;
		this.numOfUsers = 0;
		
		for (int i = 0;i < this.users.length;++i) this.users[i] = null;
		for (int i = 0;i < this.mailBox.length;++i) this.mailBox[i] = null;
	}
	
	public static MailServer getInstance() {
		return mailServer;
	}
	
	public void distributeMail() {
		int curNumOfMailsInBox = this.numOfMailsInBox;
		for (int i = 0;i < curNumOfMailsInBox;++i) {
			String receiver = this.mailBox[i].getReceiver();
			for (int j = 0;j < this.numOfUsers;++j) {
				if (receiver.equals(this.users[j].getAddress())) {
					this.users[j].receiveMail(this.mailBox[i]);
					this.mailBox[i] = null;
					this.numOfMailsInBox--;
					break;
				}
			}
		}
	}
	
	public void takeMailFromUser(Mail mail) {
		this.mailBox[this.numOfMailsInBox++] = mail;
	}
	
	public void registerUser(User user) {
		System.out.println("- register user: " + user.getAddress());
		this.users[this.numOfUsers++] = user;
	}
}
