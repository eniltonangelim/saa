package br.unifor.pin.saa.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unifor.pin.saa.entity.Professores;

@FacesConverter(value = "professorConverter")
public class ProfessorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null && !"".equals(value) && !value.isEmpty()) {
			return this.getAttributesFrom(component).get(value);
		}
			return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
	    Long id = (value instanceof Professores) ? ((Professores) value).getId() : null;
	    return (id != null) ? String.valueOf(id) : null;
	}
	
	protected void addAttribute(UIComponent component, Professores o) {
		String key = o.getId().toString();
		this.getAttributesFrom(component).put(key, o);
	}
	
	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
