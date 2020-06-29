package br.com.diario.util;


import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joão pedro
 */
public class MenssagensUtil {
    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    
    private static ResourceBundle bundle = ResourceBundle.getBundle("mensagens", LOCALE_PT_BR);
    
    public static final String MSG_ERRO_SENHA = "msg.erro.senha";
    public static final String MSG_ERRO_EXCLUIR = "msg.erro.excluir";
    public static final String MSG_ERRO_SELECIONAR = "msg.erro.selecionar";
    public static final String MSG_CONFIRMACAO_SENHA = "msg.confirmacao.senha";
    public static final String MSG_BUTTON_INSERIR = "msg.button.inserir";
    public static final String MSG_BUTTON_EDITAR = "msg.button.editar";
    public static final String MSG_BUTTON_EXCLUIR = "msg.button.excluir";
    public static final String MSG_BUTTON_ENTRAR = "msg.button.entrar";
    public static final String MSG_BUTTON_SALVAR = "msg.button.salvar";
    public static final String MSG_BUTTON_VISUALIZAR = "msg.button.vizualizar";
    public static final String MSG_TITULO_INICIO = "msg.titulo.inicio";
    public static final String MSG_TABELA_DATA = "msg.tabela.data";
    public static final String MSG_TABELA_TEXTO = "msg.tabela.texto";
    public static final String MSG_LABEL_SENHA = "msg.label.senha";

    public static String getString(String key){
        return bundle.getString(key);
    }
    public static void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle("mensagens", locale);
    }
}

