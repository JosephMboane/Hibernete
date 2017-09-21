/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author joseph
 */
@Entity
public class Pessoa {

    private Integer id;
    private Integer contacto;
    private String nome;
    private Morada morada;
    private EstadoCivil estdoCivil;
    private Date dataNasc;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContacto() {
        return contacto;
    }

    public void setContacto(Integer contacto) {
        this.contacto = contacto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "numero",column=@Column(name = "numero_de_casa"))
    })
    public Morada getMorada() {
        return morada;
    }

    public void setMorada(Morada morada) {
        this.morada = morada;
    }
    @Column(name = "Estado_civil")                            
    @Enumerated(EnumType.STRING)
    public EstadoCivil getEstdoCivil() {
        return estdoCivil;
    }
    
    public void setEstdoCivil(EstadoCivil estdoCivil) {
        this.estdoCivil = estdoCivil;
    }
    @Temporal(TemporalType.DATE)
    @Column(name =" Data_de_Nascimento")
    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    

}
