package br.unifor.pin.saa.manager.resposta;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.PerguntasBO;
import br.unifor.pin.saa.bussines.RespostasBO;
import br.unifor.pin.saa.entity.Perguntas;
import br.unifor.pin.saa.entity.Respostas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadResposta")
@Component(value="cadResposta")
public class CadRespostaManager {

	@Autowired
	private RespostasBO respostasBO;
	@Autowired
	private PerguntasBO perguntasBO;
	
	private String resposta;
	private Integer nota;
	
	public String salvar(){
		Respostas salvaResposta = new Respostas();
		salvaResposta.setResposta(resposta);
		salvaResposta.setNota(nota);
		salvaResposta.setRegistro(new Timestamp(System.currentTimeMillis()));
		respostasBO.salvar(salvaResposta);
	
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limparDados();
		
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.resposta = "";
	}

	
	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	public Collection<SelectItem> getPergunta() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem("", "Selecione a Pergunta"));
		List<Perguntas> perguntas = perguntasBO.buscarTodos();
		for (Perguntas pergunta : perguntas) {
			items.add(new SelectItem(pergunta, pergunta.getPergunta()));
		}
		return items;
	}
	
}
