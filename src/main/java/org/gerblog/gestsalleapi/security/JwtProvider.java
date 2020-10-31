package org.gerblog.gestsalleapi.security;

import io.jsonwebtoken.Jwts;
import org.gerblog.gestsalleapi.exceptions.SpringRedditException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;


@Service
public class JwtProvider {
    private KeyStore keystore;

    @PostConstruct
    public void init() {
        try {
            keystore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/redditclone.jks");
            keystore.load(resourceAsStream, "grm16pir".toCharArray());
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new SpringRedditException("Exception occurred while loading keystore");
        }
    }

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keystore.getKey("redditclone", "grm16pir".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e){
            throw new SpringRedditException("Exception occurred while retrieving public key from keystore");
        }
    }
}
