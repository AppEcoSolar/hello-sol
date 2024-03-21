package br.com.hellosol.hellosol.util.validation;

public class CPFValidator {
    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || isBlocked(cpf)) return false;

        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            return false; // CPF não contém somente números
        }

        int[] weights = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(cpf.substring(i, i + 1)) * weights[i + 1];
        }

        int remaining = sum % 11;
        String digit1 = (remaining < 2) ? "0" : Integer.toString(11 - remaining);

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(cpf.substring(i, i + 1)) * weights[i];
        }

        remaining = sum % 11;
        String digit2 = (remaining < 2) ? "0" : Integer.toString(11 - remaining);

        return cpf.equals(cpf.substring(0, 9) + digit1 + digit2);
    }

    private static boolean isBlocked(String cpf) {
        return cpf.equals(cpf.substring(0, 1).repeat(cpf.length()));
    }
}
