package org.example.entiry;

public enum Role {

    ADMIN("ADMIN"),
    CLIENT("CLIENT");

    private String code;

    Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}

