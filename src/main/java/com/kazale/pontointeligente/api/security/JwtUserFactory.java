package com.kazale.pontointeligente.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.kazale.pontointeligente.api.entities.Funcionario;
import com.kazale.pontointeligente.api.enums.PerfilEnum;

public class JwtUserFactory {

    private JwtUserFactory() {}

    /**
     * Converte e gera um JwtUser com base nos dados do funcionário
     *
     * @param funcionario
     * @param JwtUser
     */
    public static JwtUser create(Funcionario funcionario) {
        return new JwtUser(funcionario.getId(), funcionario.getEmail(), funcionario.getSenha(),
                mapToGrantedAuthorities(funcionario.getPerfil()));
    }

    /**
     * Converte o perfil do usuário para o formato utilizado pelo Spring Security
     *
     * @param perfilEnum
     * @param List<GrantedAuthority>
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
        return authorities;
    }

}
