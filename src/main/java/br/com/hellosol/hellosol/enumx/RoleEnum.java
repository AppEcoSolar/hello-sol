package br.com.hellosol.hellosol.enumx;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

}
