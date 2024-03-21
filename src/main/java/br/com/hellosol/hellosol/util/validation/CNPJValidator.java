package br.com.hellosol.hellosol.util.validation;

public class CNPJValidator {
    public static boolean isValidCNPJ(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || isBlocked(cnpj)) return false;

        try {
            Long.parseLong(cnpj);
        } catch (NumberFormatException e) {
            return false; // CNPJ não contém somente números
        }

        int[] weights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Integer.parseInt(cnpj.substring(i, i + 1)) * weights[i + 1];
        }

        int remaining = sum % 11;
        String digit1 = (remaining < 2) ? "0" : Integer.toString(11 - remaining);

        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Integer.parseInt(cnpj.substring(i, i + 1)) * weights[i];
        }

        remaining = sum % 11;
        String digit2 = (remaining < 2) ? "0" : Integer.toString(11 - remaining);

        return cnpj.equals(cnpj.substring(0, 12) + digit1 + digit2);
    }

    private static boolean isBlocked(String cnpj) {
        return cnpj.equals(cnpj.substring(0, 1).repeat(cnpj.length()));
    }
}
