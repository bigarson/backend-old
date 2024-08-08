package com.bigarson.base.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        try {
            String client = source.getClaimAsString("azp");
            Map<String, Object> resourceAccess = source.getClaimAsMap("resource_access");
            Map<String, Object> clientAccess = (Map<String, Object>) resourceAccess.get(client);
            List<String> clientRoles = (List<String>) clientAccess.get("roles");
            return clientRoles.stream()
                    .map(rn -> new SimpleGrantedAuthority("ROLE_" + rn))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return List.of();
        }
    }

}