package ufcg.psoft.servicos;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import ufcg.psoft.entidades.Disciplina;

@Service
public class Services {
	
	
	private HashMap<Integer,Disciplina> disciplinas;
	int id;
	
	public Services() {
		disciplinas = new HashMap<Integer,Disciplina>();
		id = 0;
	}

	public Disciplina adiciona(Disciplina dis) {
		dis.setId(id);
		disciplinas.put(id++, dis);
		return dis;
	}
	
	public Collection<Disciplina> pega(){
		return disciplinas.values();
	}
	
	
	public Disciplina uma(int val) {
		return disciplinas.get(val);
	}
	
	public Disciplina atuNome(int val, String nome) {
		disciplinas.get(val).setNome(nome);
		return disciplinas.get(val);
	}
	
	
	public Disciplina deleta(int val) {
		Disciplina aux = disciplinas.get(val);
		disciplinas.remove(val);
		return aux;
	}
	
	public boolean temPessoa(int id) {
		return disciplinas.containsKey(id);
	}
}


















