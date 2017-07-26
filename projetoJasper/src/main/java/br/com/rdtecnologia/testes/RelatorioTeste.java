/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rdtecnologia.testes;

/**
 *
 * @author lprates
 */

import java.util.ArrayList;
import java.util.List;
 
import br.com.rdtecnologia.model.Cliente;
import br.com.rdtecnologia.model.Usuario;
import br.com.rdtecnologia.relatorio.ClienteREL;
 
public class RelatorioTeste 
{
	public static void main(String[] args)
	{
		try{
			List<Cliente> clientes = new ArrayList<Cliente>();
                        List<Usuario> usuarios = new ArrayList<Usuario>();
			
			Cliente Cliente1 = new Cliente();
			Cliente1.setNome("RD Tecnologia");
			Cliente1.setEndereco("Rua Guaranis, Ipatinga");
			Cliente1.setComplemento("Sala 105");
			Cliente1.setTelefone("8888-5566");
			Cliente1.setUf("MG");
			
			Cliente Cliente2 = new Cliente();
			Cliente2.setNome("Romero Gonçalves Dias");
			Cliente2.setEndereco("Av Uruguai, Belo Horizonte");
			Cliente2.setComplemento("3º Andar");
			Cliente2.setUf("RJ");
			
			Cliente Cliente3 = new Cliente();
			Cliente3.setNome("FLC Tecnologia");
			Cliente3.setEndereco("Rua Aricanduva, São Paulo");
			Cliente3.setComplemento("Sala 23");
			Cliente3.setTelefone("98523-1234");
			Cliente3.setUf("SP");
			
			
			clientes.add(Cliente1);
			clientes.add(Cliente2);
			clientes.add(Cliente3);
			
			
                        Usuario usuario = new Usuario();
                        usuario.setId(50);
                        usuario.setNome("Teste 1 ");

                        Usuario usuario2 = new Usuario();
                        usuario2.setId(90);
                        usuario2.setNome("Teste 2 ");

                        
                        usuarios.add(usuario);
                        usuarios.add(usuario2);
                        
                        
			ClienteREL relatorio = new ClienteREL();
			relatorio.imprimir(clientes, usuarios );
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}