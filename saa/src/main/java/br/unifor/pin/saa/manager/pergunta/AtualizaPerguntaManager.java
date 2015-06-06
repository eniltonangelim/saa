package br.unifor.pin.saa.manager.pergunta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.PerguntasBO;
import br.unifor.pin.saa.entity.Perguntas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaPergunta")
@Component(value = "atualizaPergunta")
public class AtualizaPerguntaManager {

	/*
	 * 
	 */
	@Autowired
	private PerguntasBO perguntasBO;
	private Perguntas perguntasSelecionado;
	
	public String atualizar(){
		perguntasBO.atualizar(perguntasSelecionado);
		return Navigation.SUCESSO;
	}
	
	public String preparaAtualizar(Perguntas pergunta){
		perguntasSelecionado = perguntasBO.buscarPorId(pergunta.getId());
		return Navigation.ATUALIZA;
	}
	
	public Perguntas getPerguntasSelecionado() {
		return perguntasSelecionado;
	}
	public void setPerguntasSelecionado(Perguntas perguntasSelecionado) {
		this.perguntasSelecionado = perguntasSelecionado;
	}
			
}