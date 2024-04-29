package br.com.hellosol.hellosol.service.impl;

import br.com.hellosol.hellosol.dto.AuthDTO;
import br.com.hellosol.hellosol.dto.TokenResponseDTO;
import br.com.hellosol.hellosol.exception.BusinessException;
import br.com.hellosol.hellosol.exception.JWTCreationException;
import br.com.hellosol.hellosol.exception.JWTVerificationException;
import br.com.hellosol.hellosol.exception.UnauthorizedException;
import br.com.hellosol.hellosol.model.Usuario;
import br.com.hellosol.hellosol.repository.UsuarioRepository;
import br.com.hellosol.hellosol.service.AutenticacaoService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Value("${auth.jwt.token.secret}")
    private String secretKey;

    @Value("${auth.jwt.token.expiration}")
    private Integer horaExpiracaoToken;

    @Value("${auth.jwt.refresh-token.expiration}")
    private Integer horaExpiracaoRefreshToken ;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByCpfCnpj(login);
    }

    @Override
    public TokenResponseDTO obterToken(AuthDTO authDto) {
        Usuario usuario = usuarioRepository.findByCpfCnpj(authDto.login());

        return TokenResponseDTO
                .builder()
                .token(geraTokenJwt(usuario,horaExpiracaoToken))
                .refreshToken(geraTokenJwt(usuario,horaExpiracaoRefreshToken))
                .build();
    }

    public  String geraTokenJwt(Usuario usuario, Integer expiration) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getCpfCnpj())
                    .withExpiresAt(geraDataExpiracao(expiration))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new BusinessException("Erro ao tentar gerar o token! " +exception.getMessage());
        }
    }

    public String validaTokenJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    @Override
    public TokenResponseDTO obterRefreshToken(String refreshToken) {

        String login = validaTokenJwt(refreshToken);
        Usuario usuario = usuarioRepository.findByCpfCnpj(login);

        if (usuario == null) {
            throw new UnauthorizedException("Usuário não possui Autorização");
        }

        var autentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(autentication);

        return TokenResponseDTO
                .builder()
                .token(geraTokenJwt(usuario,horaExpiracaoToken))
                .refreshToken(geraTokenJwt(usuario,horaExpiracaoRefreshToken))
                .build();
    }

    private Instant geraDataExpiracao(Integer expiration) {
        return LocalDateTime.now()
                .plusHours(expiration)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
