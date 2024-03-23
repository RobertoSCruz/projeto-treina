package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private Float valorhoraaula;

	public Professor(int id, String nome, String email, String telefone, Float valorhoraaula) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.valorhoraaula = valorhoraaula;
	}

	public Professor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Float getValorhoraaula() {
		return valorhoraaula;
	}

	public void setValorhoraaula(Float valorhoraaula) {
		this.valorhoraaula = valorhoraaula;
	}

	
}