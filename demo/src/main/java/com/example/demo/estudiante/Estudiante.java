package com.example.demo.estudiante;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Estudiante {

    @Id
    @SequenceGenerator(
            name = "estudiante_sequence",
            sequenceName = "estudiante_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "estudiante_sequence"
    )

    private Long ID;
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;
    @Transient
    private Integer edad;


    public Estudiante(String nombre, Long ID, String emal, LocalDate fechaNacimiento) {
        this.ID = ID;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = emal;


    }

    public Estudiante(String nombre, String emal, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.email = emal;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Estudiante() {

    }

    public Long getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Integer getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", emal='" + email + '\'' +
                ", edad=" + edad +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
