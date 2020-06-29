/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.view;

import br.com.diario.dao.AnotacaoDAO;
import br.com.diario.model.Anotacao;
import br.com.diario.util.DateUtil;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joão pedro
 */
public class Diario {
    
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        String op = null;
        AnotacaoDAO dao = new AnotacaoDAO();
        Anotacao a,aData = null;
        
        do{
            System.out.println("DIARIO\n");
            System.out.println("Inserir\n");
            System.out.println("Editar\n");
            System.out.println("Remover\n");
            System.out.println("consultar");
            op=input.nextLine();
            
            if(op.equals("1")){
                a = new Anotacao();
                    
                    System.out.println("Texto:");
                    a.setTexto(input.nextLine());
                    System.out.println("Data");
                    a.setData(DateUtil.stringToDate(input.nextLine()));
                    
                    
                    dao.inserir(a);
                    System.out.println("Anotacao salva com sucesso");
           
            }else if(op.equals("2")){
                System.out.println("Informe a data");
                Date data = DateUtil.stringToDate(input.nextLine());
                //aData.setData(data);
                a = dao.buscar(data);
                
                if(a!=null){
                    System.out.println("Novo Texto: ");
                    String novoTexto = input.nextLine();
                    a.setTexto((novoTexto.equals("")) ? a.getTexto() : novoTexto);
                    
                    dao.editar(a);
                    System.out.println("Anotacao edita com sucesso");
                }else{
                    System.out.println("Anotacao nao encontrada");
                }
            }else if(op.equals("3")){
                System.out.println("Informe a data: ");
                    Date data = DateUtil.stringToDate(input.nextLine());
                
                    a = dao.buscar(data);
                
                    if(a != null){
                    dao.remover(a);
                    System.out.println("Anotacao excluida com sucesso!");
                    }
                    else{
                        System.out.println("Anotacao não encontrada!");
                    }
            }else if(op.equals("4")){
                List<Anotacao> anotacao = dao.listar();
                for(Anotacao an : anotacao){
                    System.out.println(an);
                }
            }
            
                
        }while(!op.equals("0"));
    }
    
}
