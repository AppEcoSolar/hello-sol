package br.com.hellosol.hellosol.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj constraintAnnotation) {
        // Esta implementação é intencionalmente deixada em branco; não é necessária nesta versão.
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        // Remove non-digits characters
        String numberOnly = value.replaceAll("\\D", "");

        // Validate based on length
        if (numberOnly.length() == 11) {
            return CPFValidator.isValidCPF(numberOnly);
        } else if (numberOnly.length() == 14) {
            return CNPJValidator.isValidCNPJ(numberOnly);
        }

        return false;
    }
}

