package model;

public class Konobar {
	private String user;
	private String pass;
	private boolean isAdmin;

	public Konobar(String user, String pass, boolean isAdmin) {
		super();
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
	}

	public Konobar() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
