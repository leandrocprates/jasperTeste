/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rdtecnologia.model;

import lombok.Data;


/**
 *
 * @author lprates
 */
@Data
public class Cliente {
    
        private int id;
	private String nome;
	private String endereco;
	private String complemento;
	private String uf;
	private String telefone;    
    
}
