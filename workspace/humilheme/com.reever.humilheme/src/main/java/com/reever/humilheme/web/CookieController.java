/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reever.humilheme.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 *
 * @author iuriandreazza
 */
public class CookieController {
    
    private final static Logger _logger = LoggerFactory.getLogger(CookieController.class);
    
    private String nomeCookie;
	private Integer expiry;

	public String getNomeCookie() {
		return nomeCookie;
	}

	public void setNomeCookie(String nomeCookie) {
		this.nomeCookie = nomeCookie;
	}

	public Integer getExpiry() {
		return expiry;
	}

	public void setExpiry(Integer expiry) {
		this.expiry = expiry;
	}

	public Cookie createCookie(HttpServletRequest request, HttpServletResponse response, String conteudo){
		String path = StringUtils.isEmpty(request.getContextPath())?"/":request.getContextPath();
		try {
			conteudo = URLEncoder.encode(conteudo, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			_logger.error("Erro no encode do cookie", e);
		}
		Cookie cookie = new Cookie(nomeCookie, conteudo);
		cookie.setMaxAge(expiry);
		cookie.setPath(path);
		cookie.setVersion(1);		
		response.addCookie(cookie);		
		return cookie;
	}

	public String getCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie iterator : cookies){
				if (iterator.getName().equals(nomeCookie)){
					String value = iterator.getValue();
					try {
						return URLDecoder.decode(value, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						_logger.error("Erro no encode do cookie", e);
					}
					break;
				}
			}
		}
		return null;
	}
    
}
