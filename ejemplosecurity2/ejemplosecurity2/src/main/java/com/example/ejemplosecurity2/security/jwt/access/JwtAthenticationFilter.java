package com.example.ejemplosecurity2.security.jwt.access;

import com.example.ejemplosecurity2.user.model.User;
import com.example.ejemplosecurity2.user.repo.UserRepository;
import com.example.ejemplosecurity2.user.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
//clase que sirve para saber el ususario que trata de autenticarse con el roken
public class JwtAthenticationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    //private final UserService userService;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtAccessTokernFromRequest(request);

        //validar el token
        //si es valido autenticar al usuario

        if(StringUtils.hasText(token) && jwtService.validatedAccessToken(token))

            //obtener el sub del token que es el id del usuario

            UUID id = jwtService.getUserIdFromAccessToken(token);

        Optional<User> result = userRepository.findById(id);

        if(result.isPresent()){
            User user = result.get();
            UsernamePasswordAuthenticationToken
                    authenticationToken = new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            user.getAuthorities()
            );
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtAccessTokernFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(JwtService.TOKEN_HEADER);

        //bearer "token"
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtService.TOKEN_HEADER))
            return bearerToken.substring(JwtService.TOKEN_PREFIX.length());
        return null;
    }

    public UUID getUserIdFromAccessToken(String token){
        String sub = jwtParser.parseClaimsJws(token).
    }


    public boolean validateAccessToken(String token) {

        try{
        jwtParser.parseClaimsJws(token);
        return true;
    }catch(StringIndexOutOfBoundsException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException)
            throw new JwtException(ex.getMessage());
    }
}
