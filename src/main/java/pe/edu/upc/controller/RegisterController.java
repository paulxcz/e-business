package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.entities.Rol;
import pe.edu.upc.entities.User;
import pe.edu.upc.service.IEmprendedorService;
import pe.edu.upc.service.IRolService;

@Named
@ViewScoped
public class RegisterController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private IEmprendedorService cS;

	@Inject
	private IRolService rS;

	private Emprendedor emprendedor;
	private User user;

	@PostConstruct
	public void init() {
		this.emprendedor = new Emprendedor();
		this.user = new User();
	}

	public String registerUser() {
		String redirect = null;
		try {
			String password = this.user.getPassword();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPassword(passwordHash);
			this.user.setState("A");
			this.emprendedor.setUser(user);
			this.user.setEmprendedor(emprendedor);
			this.cS.insert(emprendedor);

			List<Rol> roles = new ArrayList<Rol>();
			int TIPO_USUARIO = 1;
			Rol r = new Rol();
			r.setId(TIPO_USUARIO);
			roles.add(r);
			rS.assignRolesToUser(user, roles);
			redirect = "index?faces-redirect=true";
		} catch (Exception e) {

		}

		return redirect;
	}

	public Emprendedor getEmprendedor() {
		return emprendedor;
	}

	public void setEmprendedor(Emprendedor emprendedor) {
		this.emprendedor = emprendedor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
