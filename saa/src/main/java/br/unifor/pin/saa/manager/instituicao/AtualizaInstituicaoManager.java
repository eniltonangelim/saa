package br.unifor.pin.saa.manager.instituicao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicaoBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.Navigation;


@RequestScoped
@ManagedBean(name = "atualizaInstituicao")
@Component(value = "atualizaInstituicao")
public class AtualizaInstituicaoManager {

	@Autowired
	private InstituicaoBO instituicaoBO;
	private Instituicoes instituicoesSelecionado;
	
	
	public String atualizar(){
		instituicaoBO.atualizar(instituicoesSelecionado);
		
		return Navigation.SUCESSO;
	}
	
	public String preparaAtualizar(Instituicoes instituicoes){
		instituicoesSelecionado = instituicaoBO.buscaPorId(instituicoes.getId());
		
		return Navigation.ATUALIZA;
	}
	
	public Instituicoes getInstituicoesSelecionado() {
		return instituicoesSelecionado;
	}
	public void setInstituicoesSelecionado(Instituicoes instituicoesSelecionado) {
		this.instituicoesSelecionado = instituicoesSelecionado;
	}
	
	
	
}
