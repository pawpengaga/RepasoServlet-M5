package com.modulocinco.modelo;

public class Usuario {

  private String nombre;
  private String usuario;
  private String clave;

  public Usuario(String nombre, String usuario, String clave) {
    this.nombre = nombre;
    this.usuario = usuario;
    this.clave = clave;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUsuario() {
    return this.usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getClave() {
    return this.clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }


}
