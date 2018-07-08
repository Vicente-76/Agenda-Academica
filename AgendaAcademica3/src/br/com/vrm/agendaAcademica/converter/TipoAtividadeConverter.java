package br.com.vrm.agendaAcademica.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vrm.agendaAcademica.DAO.TiposAtividadesDAO;
import br.com.vrm.agendaAcademica.Domain.TiposAtividades;

@FacesConverter("tipoAtividadeConverter")
public class TipoAtividadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fC, UIComponent component, String valor) {
		try {
			Integer codigo = Integer.parseInt(valor);

			TiposAtividadesDAO tDAO = new TiposAtividadesDAO();
			TiposAtividades tipoAtividade = tDAO.listarPorCodigo(codigo);

			return tipoAtividade;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fC, UIComponent component, Object objeto) {
		try {
			TiposAtividades tipoAtividade = (TiposAtividades) objeto;
			Integer codigo = tipoAtividade.getCodTipoAtividade();

			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
