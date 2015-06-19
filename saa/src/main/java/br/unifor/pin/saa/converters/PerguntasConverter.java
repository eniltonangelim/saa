package br.unifor.pin.saa.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unifor.pin.saa.entity.Perguntas;

@FacesConverter(value = "perguntaConverter")
public class PerguntasConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null && !"".equals(value) && !value.isEmpty()) {	
			return this.getAttributesFrom(component).get(value);
		}	
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value instanceof Perguntas){
			this.addAttribute(component, ((Perguntas) value));
			Long id = ((Perguntas) value).getId();
			return String.valueOf(id);
		}
		
	    return (String) value;
	}
	
	
	protected void addAttribute(UIComponent component, Perguntas o) {
		String key = o.getId().toString();
		this.getAttributesFrom(component).put(key, o);
	}
	
	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
