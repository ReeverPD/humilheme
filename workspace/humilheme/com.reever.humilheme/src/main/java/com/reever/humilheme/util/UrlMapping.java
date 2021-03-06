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
    public static final String TERMOS_UTILIZACAO = "/Termos-de-Utilização";
    public static final String POLITICA_PRIVACIDADE = "/Politica-de-Privacidade";
    public static final String CONTATO = "/Contato";
    
    /* Humilhar */
    public static final String CONVIDAR_AMIGO = "/app/Convidar";
    public static final String CONVIDAR_AMIGO_INVITE = "/app/Convidar/Invite";
    public static final String CONVIDAR_PESQUISAR_AMIGO = "/app/Convidar/pesquisar";
    public static final String BATALHAR_AMIGO = "/app/Batalhar/{profileA}/{profileB}/{requestId}";
    public static final String HUMILHAR_AMIGO = "/app/Humilhar/{profileA}/{profileB}/{requestId}";
    
    public static final String BATALHAR_AMIGO_POST = "/app/Batalhar/Humiliate/{requestId}";
    public static final String HUMILHAR_AMIGO_POST = "/app/Humilhar/Humiliate/{requestId}";
    
    
    public static final String BATALHAR_INVITE_AMIGO = "/app/invite/Batalhar/{profileA}/{profileB}";
    public static final String HUMILHAR_INVITE_AMIGO = "/app/invite/Humilhar//{profileA}/{profileB}";
    
    
    /* Login com Facebook */
    public static final String LOGIN_FACEBOOK = "/Login-Facebook";
}
