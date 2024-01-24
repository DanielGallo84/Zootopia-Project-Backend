package org.vero_slaves.zootopia.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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

    @Column(name = "admission_date", nullable = false,  updatable = false)
    @CreatedDate
    private Date admission_date;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String typeName;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String familyName;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String genderName;

    public Animal() {
    }

    public Animal(String name, Date admission_date, byte[] photo, Type type, Family family, Gender gender,
            String typeName, String familyName, String genderName) {
        this.name = name;
        this.photo = photo;
        this.type = type;
        this.family = family;
        this.gender = gender;
        this.typeName = typeName;
        this.familyName = familyName;
        this.genderName = genderName;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

}