package com.luv2code.web.jdbc;

public class Student {

	private int id;
	private String nombre;
	private String apellido;
	private String correo;

	public Student(String nombre, String apellido, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	public Student(int id, String nombre, String apellido, String correo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}

	public String getcorreo() {
		return correo;
	}

	public void setcorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + "]";
	}	
}
