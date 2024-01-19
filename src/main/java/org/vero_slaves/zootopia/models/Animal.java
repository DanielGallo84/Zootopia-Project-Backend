package org.vero_slaves.zootopia.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_animal")
    private Long id;

    @Column
    private String name;

    @Column(name = "admission_date", nullable = false, updatable = false)
    @CreatedDate
    private Date admission_date;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id")
    @JsonBackReference
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id")
    @JsonBackReference
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gender_id")
    @JsonBackReference
    private Gender gender;

    public Animal() {
    }

    public Animal(String name, Date admission_date, byte[] photo, Type type, Family family, Gender gender) {
        this.name = name;
        this.admission_date = admission_date;
        this.photo = photo;
        this.type = type;
        this.family = family;
        this.gender = gender;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getAdmission_date() {
        return admission_date;
    }


    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }


    public byte[] getPhoto() {
        return photo;
    }


    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


    public Type getType() {
        return type;
    }


    public void setType(Type type) {
        this.type = type;
    }


    public Family getFamily() {
        return family;
    }


    public void setFamily(Family family) {
        this.family = family;
    }


    public Gender getGender() {
        return gender;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }

}