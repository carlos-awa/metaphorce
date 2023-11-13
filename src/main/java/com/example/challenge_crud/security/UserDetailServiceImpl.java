package com.example.challenge_crud.security;

import com.example.challenge_crud.modelo.Usuario;
import com.example.challenge_crud.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.
                findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con email" + email + "no existe"));

return new UserDetailsImpl(usuario);
    }

    @Autowired
    private RepositorioUsuario repositorioUsuario;




}
