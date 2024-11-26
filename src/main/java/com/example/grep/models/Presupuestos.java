package com.example.grep.models;

import jakarta.persistence.*;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "PRESUPUESTOS")
public class Presupuestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRESUPUESTO", nullable = false)
    private Integer id_presupuesto;

    @Column(name = "AÑO", nullable = false)
    private Integer año;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)
    private Departamentos id_departamento;

    @ManyToOne
    @JoinColumn(name = "ID_FINALIDAD", nullable = false)
    private Finalidades id_finalidad;

    @Column(name = "PRESUPUESTO", nullable = false)
    private Double presupuesto;

    public Presupuestos() {}

    public Integer getIdPresupuesto() { return id_presupuesto; }
    public void setIdPresupuesto(Integer id_presupuesto) { this.id_presupuesto = id_presupuesto; }

    public Integer getAño() { return año; }
    public void setAño(Integer año) { this.año = año; }

    public Departamentos getIdDepartamento() { return id_departamento; }
    public void setIdDepartamento(Departamentos id_departamento) { this.id_departamento = id_departamento; }

    public Finalidades getIdFinalidad() { return id_finalidad; }
    public void setIdFinalidad(Finalidades id_finalidad) { this.id_finalidad = id_finalidad; }

    public Double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(Double presupuesto) { this.presupuesto = presupuesto; }
}
