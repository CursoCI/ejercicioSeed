package com.cursoci.www;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import com.cursoci.www.entidades.Usuario;

@ViewScoped
public class UsuarioWizard implements Serializable {
 
    private Usuario user = new Usuario();
     
    private boolean skip;
     
    public Usuario getUser() {
        return user;
    }
 
    public void setUser(Usuario user) {
        this.user = user;
    }
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Correcto", "Bienvenido :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}