package br.unifor.pin.saa.manager.disciplina;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.DisciplinasBO;
import br.unifor.pin.saa.bussines.PerguntasBO;
import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.entity.Perguntas;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadDisciplina")
@Component(value="cadDisciplina")
public class CadDisciplinaManager {

	@Autowired
	private DisciplinasBO disciplinaBO;
	@Autowired
	private PerguntasBO perguntasBO;
	
	private String nome;
	private Disciplinas disciplina;
	
	public CadDisciplinaManager() {
		disciplina = new Disciplinas();
	}
	
	public String salvar(){
		disciplina.setNome(nome);
		disciplina.setRegistro(new Timestamp(System.currentTimeMillis()));
		disciplinaBO.salvar(disciplina);
	
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limparDados();
		
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
	}
	
	public String proximaTela(){
		return Navigation.PROXIMA;
	}
	
	public String anteriorTela(){
		return Navigation.ANTERIOR;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	public Collection<SelectItem> getPergunta() {
		Collection<SelectItem> items = new ArrayList<SelectItem>();
		List<Perguntas> perguntas = perguntasBO.buscarTodos();
		for (Perguntas pergunta : perguntas) {
			items.add(new SelectItem(pergunta, pergunta.getPergunta()));
		}
		return items;
	}
	
	
}
