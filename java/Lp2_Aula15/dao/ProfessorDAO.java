package br.ufrn.imd.dao;

import java.util.ArrayList;
import br.ufrn.imd.modelo.Professor;
import br.ufrn.imd.modelo.ProfessorHorista;
import br.ufrn.imd.modelo.ProfessorIntegral;

public class ProfessorDAO {
	
	private ArrayList<Professor> professores;
	
	public ProfessorDAO() {
		this.professores = new ArrayList<Professor>();
	}
	
	// m�todo add
	public void addProfessor(Professor p) {
		professores.add(p);
		System.out.println("Professor inserido!!!");
	}
		
	// m�todo remove
	public void removeProfessor(Professor p) {
		professores.remove(p);
		System.out.println("Professor removido!!!");
	}
		
	// m�todo para retornar a quantidade
	public int quantidadeDeProfessores() {
		return professores.size();
	}
		
	// m�todo para retornar o maior sal�rio
	public Professor maiorSalario() {
		Professor p = null;
		if (professores.size() > 0) {
			double maior = 0;
			for(int i = 0; i < professores.size(); i++) {
				if(professores.get(i).getSalario() >= maior) {
					p = professores.get(i);
					maior = p.getSalario();
				}
			}
		}
		return p;
	}
		
	// m�todo para retornar a menor idade
	public Professor maisNovo(){ 
		if (professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado.");
			return null;
		}
		Professor mais_novo = (this.professores).get(0);
		for (Professor p : this.professores) {
			if (mais_novo.getDataNascimento().before(p.getDataNascimento())) {
				mais_novo = p;
			}
		} 
		return mais_novo; 
	}
	
	// m�todo para retornar a maior idade
	public Professor maisVelho() {
		Professor aux = null;
		
		if (professores.size() <= 0) {
			System.out.println("Nenhum professor cadastrado.");
			return null;
		}
		
		for (Professor p : this.professores) {
			if (p instanceof ProfessorIntegral) {
				aux = p;
			}
		}
		
		Professor mais_velho = aux;
		for (Professor p : this.professores) {
			if (p instanceof ProfessorIntegral) { 
				if (((ProfessorIntegral) mais_velho).getDataInicio().after(((ProfessorIntegral)p).getDataInicio())) {
					mais_velho = p;
				}
			}
			
		} 
		return mais_velho; 
	}
	
	// Total de sal�rios
	public String totalSalarios() {
	    double total = 0;
	    for (Professor professorIterador : this.professores) {
	      total = total + professorIterador.getSalario();
	    }
	    return "Total de Salarios a Serem Pagos: R$ " + total;
	}
	
	public String mediaHoristas() {
	    double total = 0;
	    int contador = 0;
	    for (Professor professorIterador : this.professores) {
	      if (professorIterador instanceof ProfessorHorista) {
	        contador += 1;
	        total = total + ((ProfessorHorista) professorIterador).getHorasTrabalhadas();
	      }
	    }
	    total = total / contador;
	    return "M�dia dos Professores Horistas: " + total;
	}
	
	// Professores que lecionam Portugu�s e Matem�tica
	public String professoresMaterias() {
	    String result = "\n";
	    for (Professor professorIterador : this.professores) {
	      if (professorIterador.getDisciplina().equals("Portugu�s")
	          || professorIterador.getDisciplina().equals("Matem�tica")) {
	        result += professorIterador.getNome() + " - " + professorIterador.getDisciplina() + " ("
	            + professorIterador.getMatricula() + ")\n";
	      }
	    }
	    return "Professores de Portugues e Matematica: " + result;
	}
	
	// Professores com n�vel superior
	public String professoresSuperior() {
	    String result = "\n";
	    for (Professor professorIterador : this.professores) {
	      if (professorIterador.getNivelEscolaridade().equals("Mestrado")
	          || professorIterador.getNivelEscolaridade().equals("Doutorado")) {
	        result += professorIterador.getNome() + " - " + professorIterador.getNivelEscolaridade() + " ("
	            + professorIterador.getMatricula() + ")\n";
	      }
	    }
	    return "Professores com Mestrado e Doutorado: " + result;
	}
}
