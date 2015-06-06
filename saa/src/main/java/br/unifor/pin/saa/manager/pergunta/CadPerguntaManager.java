package br.unifor.pin.saa.manager.pergunta;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.PerguntasBO;
import br.unifor.pin.saa.entity.Perguntas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadPergunta")
@Component(value = "cadPergunta")
public class CadPerguntaManager implements Serializable {

	private static final long serialVersionUID = 8802911325048188932L;
	
	@Autowired
	private PerguntasBO perguntaBO;
	
	private String pergunta;
	
	public String salvar(){
		Perguntas perguntas = new Perguntas();
		perguntas.setPergunta(pergunta);
		perguntas.setRegistro(new Timestamp(System.currentTimeMillis()));
		return Navigation.SUCESSO;
	}

	public String preparaSalvar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.pergunta = "";
		
	}
	
	public PerguntasBO getPerguntaBO() {
		return perguntaBO;
	}

	public void setPerguntaBO(PerguntasBO perguntaBO) {
		this.perguntaBO = perguntaBO;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}	
}