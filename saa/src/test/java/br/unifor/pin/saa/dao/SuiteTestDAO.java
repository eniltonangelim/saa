package br.unifor.pin.saa.dao;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunosDAOTest.class, DisciplinasDAO.class, InstituicoesDAOTest.class,
ProfessoresDAOTest.class, RespostasDAO.class, TokenDAOTest.class, TurmasDAOTest.class,
UsuarioDAOTest.class })
public class SuiteTestDAO {
	
}