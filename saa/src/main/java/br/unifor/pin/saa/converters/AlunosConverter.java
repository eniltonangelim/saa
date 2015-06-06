package br.unifor.pin.saa.converters;

import java.io.Serializable;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unifor.pin.saa.entity.Alunos;


@FacesConverter(value = "alunoConverter")
public class AlunosConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 235457803076473148L;

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {	
			return this.getAttributesFrom(component);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		// TODO Auto-generated method stub
	    Long id = (value instanceof Alunos) ? ((Alunos) value).getId() : null;
	    return (id != null) ? String.valueOf(id) : null;
	}
	
	
	protected void addAttribute(UIComponent component, Alunos o) {
		String key = o.getId().toString();
		this.getAttributesFrom(component).put(key, o);
	}
	
	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
