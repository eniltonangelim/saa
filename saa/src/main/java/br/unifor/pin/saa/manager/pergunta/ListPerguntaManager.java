package br.unifor.pin.saa.manager.pergunta;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.unifor.pin.saa.bussines.PerguntasBO;
import br.unifor.pin.saa.entity.Perguntas;

/**
 * @author pyangel
 *
 */

@RequestScoped
@ManagedBean(name = "listPergunta")
@Component(value = "listPergunta")
public class ListPerguntaManager implements Serializable {

	private static final long serialVersionUID = 9071972981596893664L;

	@Autowired
	private PerguntasBO perguntasBO;
	private String pergunta;
	private List<Perguntas> perguntas;
	
	public void lista(){
		perguntas = perguntasBO.ListarPorNome(pergunta);
	}
	
	public void excluir(Perguntas pergunta){
		perguntasBO.excluir(pergunta);
		perguntas = perguntasBO.ListarPorNome(pergunta.getPergunta());
	}
	
	public String preparaAtualizar(Perguntas pergunta){
		System.out.println(pergunta.getPergunta());
		return null;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public List<Perguntas> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Perguntas> perguntas) {
		this.perguntas = perguntas;
	}
}