package br.com.vrm.agendaAcademica.Util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {
	public static void addMsgInfo(String msg) {
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, message);
	}

	public static void addMsgError(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, message);
	}
	
	public static String getParam(String nome) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext externalContext = ctx.getExternalContext();
		Map<String, String> parametros = externalContext.getRequestParameterMap();
		String valor = parametros.get(nome);
		return valor;
	}
}
