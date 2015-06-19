package br.unifor.pin.saa.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unifor.pin.saa.entity.Alunos;


@FacesConverter(value = "alunoConverter")
public class AlunosConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {	
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value instanceof Alunos){
			this.addAttribute(component, ((Alunos) value));
			Long id = ((Alunos) value).getId();
			return String.valueOf(id);
		}
		
	    return (String) null;
	}
	
	
	protected void addAttribute(UIComponent component, Alunos o) {
		String key = o.getId().toString();
		this.getAttributesFrom(component).put(key, o);
	}
	
	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
