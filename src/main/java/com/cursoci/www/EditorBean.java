package com.cursoci.www;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name= "editor")
@ViewScoped
public class EditorBean {

	private UsuarioWizard usuarioWizard = new UsuarioWizard();
	

	public UsuarioWizard getUsuarioWizard() {
		return usuarioWizard;
	}

	public void setUsuarioWizard(UsuarioWizard usuarioWizard) {
		this.usuarioWizard = usuarioWizard;
	}
}