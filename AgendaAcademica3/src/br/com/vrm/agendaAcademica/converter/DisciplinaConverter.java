package br.com.vrm.agendaAcademica.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vrm.agendaAcademica.DAO.DisciplinasDAO;
import br.com.vrm.agendaAcademica.Domain.Disciplinas;

@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fC, UIComponent component, String valor) {
		try {
			Integer codigo = Integer.parseInt(valor);

			DisciplinasDAO dDAO = new DisciplinasDAO();
			Disciplinas disciplina = dDAO.listarPorCodigo(codigo);

			return disciplina;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fC, UIComponent component, Object objeto) {
		try {
			Disciplinas disciplina = (Disciplinas) objeto;
			Integer codigo = disciplina.getCodDisciplina();

			return codigo.toString();
		} catch (RuntimeException e) {
			return null;
		}
	}
}
