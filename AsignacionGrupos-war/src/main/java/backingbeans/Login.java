package backingbeans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class Login {
	private String username;
	private String password;

	public void login() {

		FacesContext context = FacesContext.getCurrentInstance();

		if (this.username.equals("secretaria") && this.password.equals("secretaria")) {
			context.getExternalContext().getSessionMap().put("user", username);
			try {
				context.getExternalContext().redirect("Main.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (this.username.equals("alumno") && this.password.equals("alumno")) {
			context.getExternalContext().getSessionMap().put("user", username);

			try {
				context.getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();

			}
		} else {
			// Send an error message on Login Failure
			context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));

		}
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("Login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Login.xhtml";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
