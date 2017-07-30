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
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public ClienteREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/rdtecnologia/jasper/";
                
                this.pathToReportPackage = "C:/Users/lprates/Desktop/jasperteste/projetoJasper2/src/main/java/br/com/rdtecnologia/jasper/" ; 
                
		System.out.println(path);
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir(List<Cliente> clientes, List<Usuario> usuarios, List<Empresa> empresas) throws Exception	
	{
            
                HashMap parametros = new HashMap();
                parametros.put("listaUsuarios", usuarios);   
                parametros.put("listaEmpresas", empresas);  
                parametros.put("SUBREPORT_DIR", "C:/Users/lprates/Desktop/jasperteste/projetoJasper2/src/main/java/br/com/rdtecnologia/jasper/");        
                
                
            
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Clientes.jrxml");
		
                JasperPrint print = JasperFillManager.fillReport(report, parametros , new JRBeanCollectionDataSource(clientes,false) ) ;
                
		JasperExportManager.exportReportToPdfFile(print, "C:/Users/lprates/Desktop/jasperteste/Relatorio_de_Clientes.pdf");		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}


