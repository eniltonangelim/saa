package br.unifor.pin.saa.manager.instituicao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicaoBO;

import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listInstituicao")
@Component(value="listInstituicao")
public class ListInstituicaoManager {

	@Autowired
	private InstituicaoBO instituicaoBO;
	private String nome;
	private List<Instituicoes> instituicoes;
	
	public void lista(){
		
		instituicoes = instituicaoBO.listaPorNome(nome);
		
	}
	
	public void excluir(Instituicoes instituicao){
		instituicaoBO.excluir(instituicao);
		instituicoes = instituicaoBO.listaPorNome(nome);
	}
	
	public String preparaAtualizar(Instituicoes instituicoes){
		System.out.println(instituicoes.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.instituicoes = null;
	}
	
	
	public String salvar(){
		return null;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Instituicoes> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicoes> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
}
