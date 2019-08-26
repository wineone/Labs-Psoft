package ufcg.psoft.contoller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufcg.psoft.entidades.Disciplina;
import ufcg.psoft.entidades.Nome;
import ufcg.psoft.servicos.Services;

@RequestMapping("/v1/api/")
@RestController
public class controller {
	
	@Autowired
	private Services ser;
	
	 
	@PostMapping("disciplinas")
	public ResponseEntity<Disciplina> add(@RequestBody Disciplina dis){
		return new ResponseEntity<Disciplina>(ser.adiciona(dis),HttpStatus.CREATED);
	}
	
	@RequestMapping("disciplinas")
	public ResponseEntity<Collection<Disciplina>> lista(){
		return new ResponseEntity<Collection<Disciplina>>(ser.pega(),HttpStatus.OK);
	}
	
	@RequestMapping("disciplinas/{id}")
	public ResponseEntity<Disciplina> uma(@PathVariable(value = "id") int id){
		if(ser.temPessoa(id))
			return new ResponseEntity<Disciplina>(ser.uma(id),HttpStatus.OK);
		else
			return new ResponseEntity<Disciplina>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atuNome(@PathVariable(value = "id") int id,@RequestBody Nome nome){
		if(ser.temPessoa(id))
			return new ResponseEntity<Disciplina>(ser.atuNome(id, nome.nome),HttpStatus.OK);
		else
			return new ResponseEntity<Disciplina>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("disciplinas/{id}")
	public ResponseEntity<Disciplina> deleta(@PathVariable(value = "id") int id){
		if(ser.temPessoa(id))
			return new ResponseEntity<Disciplina>(ser.deleta(id),HttpStatus.OK);
		else
			return new ResponseEntity<Disciplina>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}



















