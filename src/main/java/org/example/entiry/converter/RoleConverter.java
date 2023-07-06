package org.example.entiry.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.entiry.protection.Role;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role state) {
        if (state == null) {
            return null;
        }
        return state.getCode();
    }

    @Override
    public Role convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Role.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
