package br.unifor.pin.saa.manager.resposta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.RespostasBO;
import br.unifor.pin.saa.entity.Respostas;
import br.unifor.pin.saa.utils.Navigation;


@RequestScoped
@ManagedBean(name = "atualizaResposta")
@Component(value = "atualizaResposta")

public class AtualizaRespostaManager {

	@Autowired
	private RespostasBO respostasBO;
	private Respostas respostasSelecionado;
	
	public String atualizar(){
		respostasBO.atualizar(respostasSelecionado);
		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Respostas respostas){
		respostasSelecionado = respostasBO.buscarPorId(respostas.getId());
		
		return Navigation.ATUALIZA;
	}
	
	public Respostas getAlunosSelecionado() {
		return respostasSelecionado;
	}
	
	public void setAlunosSelecionado(Respostas respostasSelecionado) {
		this.respostasSelecionado = respostasSelecionado;
	}
	
}
