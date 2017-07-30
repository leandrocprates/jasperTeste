/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rdtecnologia.relatorio;

/**
 *
 * @author lprates
 */


import java.util.List;
 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.rdtecnologia.model.Cliente;
import br.com.rdtecnologia.model.Usuario;
import br.com.rdtecnologia.model.Empresa;
import java.util.HashMap;
 
public class ClienteREL 
{
	private String path = "C:/Users/lprates/Documents/git/jasperTeste/"; //Caminho base
        private String pathClassBase = "projetoJasper/src/main/java/br/com/rdtecnologia/jasper/";

        private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public ClienteREL() {
		//this.path = this.getClass().getClassLoader().getResource("").getPath();
                this.pathToReportPackage =  path + pathClassBase; 
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir(List<Cliente> clientes, List<Usuario> usuarios, List<Empresa> empresas) throws Exception	
	{
            
                HashMap parametros = new HashMap();
                parametros.put("listaUsuarios", usuarios);   
                parametros.put("listaEmpresas", empresas);  
                parametros.put("SUBREPORT_DIR", this.getPathToReportPackage() );        
                
                
            
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Clientes.jrxml");
		
                JasperPrint print = JasperFillManager.fillReport(report, parametros , new JRBeanCollectionDataSource(clientes,false) ) ;
                
		JasperExportManager.exportReportToPdfFile(print,  this.path + "Relatorio_de_Clientes.pdf" );		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}


}


