package ufcg.psoft.entidades;

public class Disciplina {
	private String nome;
	private float nota;
	private int id;
	
	
	public Disciplina(String nome, float nota) {
		this.nome = nome;
		this.nota = nota;
		id = 0;
	}

	
	public String getNome() {
		return nome;
	}
	
	public float getNota() {
		return nota;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
