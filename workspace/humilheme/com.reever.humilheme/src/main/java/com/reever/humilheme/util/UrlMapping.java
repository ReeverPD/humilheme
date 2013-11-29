package com.reever.humilheme.util;

/**
 *
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
public class UrlMapping {
    
    /* Home URL */
    public static final String HOME = "/home";
    public static final String ROOT = "/";
    
    /* DOAR URL */
    public static final String DOAR = "/Doar/{mensagem}";
    
    /* Static Content */
    public static final String TERMOS_UTILIZACAO = "/app/Termos-de-Utilização";
    public static final String POLITICA_PRIVACIDADE = "/app/Politica-de-Privacidade";
    public static final String CONTATO = "/app/Contato";
    
    /* Humilhar */
    public static final String CONVIDAR_AMIGO = "/app/Convidar";
    public static final String BATALHAR_AMIGO = "/app/Batalhar/{battalhaHash}";
    public static final String HUMILHAR_AMIGO = "/app/Humilhar/{profileA}/{profileB}";
    
    
    /* Login com Facebook */
    public static final String LOGIN_FACEBOOK = "/Login-Facebook";
}
