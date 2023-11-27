package br.itau.cadastroclienteservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "TB_CLIENTE")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @Column(name = "CPF")
    public String cpf;

    @Column(name = "NOME")
    public String nome;

    @Column(name = "EMAIL")
    public String email;

    @Column(name = "TELEFONE")
    public String telefone;

    @Column(name = "NR_CONTA_CORRENTE")
    public String numeroContaCorrente;

    @Column(name = "STATUS_CONTA")
    public int statusConta;
}
