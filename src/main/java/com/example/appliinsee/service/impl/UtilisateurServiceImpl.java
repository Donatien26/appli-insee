package com.example.appliinsee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.appliopensource.model.Utilisateur;
import com.example.appliopensource.service.UtilisateurService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnMissingBean(type = "UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

	private static List<Utilisateur> utilisateurs = new ArrayList<>();

	static {
		utilisateurs.add(new Utilisateur("ystfg5", "Donatien"));
		utilisateurs.add(new Utilisateur("qwerty", "Tutu"));
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurs;
	}

	@Override
	public Utilisateur whoIam() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		authentication.getName();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdep(authentication.getName());
		utilisateur.setRoles(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.map(String::toUpperCase).collect(Collectors.toList()));
		return utilisateur;
	}

}
