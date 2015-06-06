package br.unifor.pin.saa.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.UsuarioBO;
import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "loginUsuario")
@Component(value = "loginUsuario")

public class LoginUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	private String nome;
	private String senha;
	private Usuarios usuario;
	
	public String login(){
		/*
		 * Primeiro Acesso: Página de ajuda
		 */
		try {
			usuario = usuarioBO.buscaLogin(nome);
			if(nome.equalsIgnoreCase(usuario.getNome())
					&&senha.equals(usuario.getSenha())
					&&( usuario.isAtivo() || usuario.isPrimeiroAcesso()) ){
				return Navigation.SUCESSO;
			}
		} catch(NullPointerException e){
			e.printStackTrace();
		} catch(NoResultException e){
			return Navigation.VOLTAR;
		}
		return null;
	}

	public String loginNewLogin(){
		return Navigation.NOVOLOGIN;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
