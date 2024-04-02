package com.example.gerenciadorDeEstoque.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;
@Entity
@Table(name = "acesso")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private Date data;

    private LocalTime horarioEntrada;

    private LocalTime horarioSaida;

    public Acesso(Long id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
}
