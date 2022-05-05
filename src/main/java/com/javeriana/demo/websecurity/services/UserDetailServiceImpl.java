package com.javeriana.demo.websecurity.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.javeriana.demo.websecurity.entities.Usuario;
import com.javeriana.demo.websecurity.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private UsuarioRepository usuarioRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);

    if (usuarioOpt.isPresent()) {
      Usuario usuario = usuarioOpt.get();

      var authorities = List.of(new SimpleGrantedAuthority("ROLE_"+usuario.getRole().getName().toUpperCase()));

      return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }

    throw new UsernameNotFoundException(username);
  }
}
