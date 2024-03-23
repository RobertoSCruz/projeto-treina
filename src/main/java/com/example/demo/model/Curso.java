package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int chaula;
	private int chtotal;

	public Curso() {
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

	public int getChaula() {
		return chaula;
	}

	public void setChaula(int chaula) {
		this.chaula = chaula;
	}

	public int getChtotal() {
		return chtotal;
	}

	public void setChtotal(int chtotal) {
		this.chtotal = chtotal;
	}
	
}
