package br.com.hellosol.hellosol.service;

import br.com.hellosol.hellosol.dto.AuthDTO;
import br.com.hellosol.hellosol.dto.TokenResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutenticacaoService extends UserDetailsService {
    public TokenResponseDTO obterToken(AuthDTO authDTO);
    public String validaTokenJwt(String token);

    TokenResponseDTO obterRefreshToken(String s);
}