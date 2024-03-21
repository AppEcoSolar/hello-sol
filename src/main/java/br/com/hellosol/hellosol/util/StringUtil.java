package br.com.hellosol.hellosol.util;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final int MAX_CHARACTERS = 50;
    private StringUtil() {
    }

    public static boolean isEmpty(final String str) {
        return (str == null) || (str.trim().equals(""));
    }
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }
    public static String defaultString(final Object str) {
        String resultado = null;
        if (str == null) {
            resultado = "";
        } else {
            resultado = (str.toString() != null ? str.toString() : "");
        }
        return resultado;
    }

    public static String defaultString(final Object str, final String defaultStr) {
        String resultado = null;
        if (str == null || isEmpty(str.toString())) {
            resultado = defaultStr;
        } else {
            resultado = (str.toString() != null ? str.toString() : defaultStr);
        }
        return resultado;
    }

    public static String defaultStringPropriedade() {
        Object o = null;
        return defaultString(o);
    }

    public static String defaultStringPropriedade(final String valorDefault) {
        Object o = null;
        return defaultString(o, valorDefault);
    }

    public static String removerArquivoDaURL(final String url) {
        if (url == null) {
            return null;
        }
        int indice = url.lastIndexOf("/");
        return indice < 0 ? url : url.substring(0, indice + 1);
    }

    public static String getValueMaskFormat(final String pValue,
                                            final String pMask,
                                            final boolean pReturnValueEmpty) {
        String resultado;

        if (pReturnValueEmpty && (pValue == null || pValue.trim().equals(""))) {
            return "";
        }

        resultado = pMask.replace("**", "#");
        resultado = resultado.replace("9", "#");
        resultado = resultado.toUpperCase().replace("X", "#");

        for (int i = 0; i < pValue.length(); i++) {
            resultado = resultado.replaceFirst("#", pValue.substring(i, i + 1));
        }

        return resultado.replace("#", "");
    }

    public static String formataCPF(final String value) {
        if (isEmpty(value)) {
            return null;
        }
        String cpf = somenteNumeros(value);
        cpf = leftFill(cpf, '0', 11);
        return getValueMaskFormat(cpf, "###.###.###-##", true);
    }

    public static String formataTelefoneComDDD(final String value) {
        if (isEmpty(value)) {
            return null;
        }
        String telefone = somenteNumeros(value);
        telefone = leftFill(telefone, '0', 10);
        return getValueMaskFormat(telefone, "(##) ####-####", true);
    }

    public static String formataMesAno(final String value) {
        if (isEmpty(value)) {
            return null;
        }
        String mesAno = somenteNumeros(value);
        mesAno = leftFill(mesAno, '0', 6);
        return getValueMaskFormat(mesAno, "##/####", true);
    }

    public static String formataRG(final String rg) {
        if (rg == null) {
            return "";
        }
        if (rg.length() > 9) {
            return getValueMaskFormat(rg, "#########-#", true);
        } else {
            return getValueMaskFormat(rg, "#########", true);
        }
    }

    public static String somenteNumeros(final String value) {
        String resultado = value;
        if (value != null) {
            resultado = value.replaceAll("\\D", "");
        }
        return resultado;
    }

    public static String formataCep(final String value) {
        if (isEmpty(value)) {
            return null;
        }
        String cep = somenteNumeros(value);
        cep = leftFill(cep, '0', 8);
        return getValueMaskFormat(cep, "#####-###", true);
    }

    public static String leftFill(final String texto, final char caracter,
                                  final int size) {
        String resultado = null;
        if (texto != null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < (size - texto.length()); i++) {
                str.append(caracter);
            }
            str.append(texto);
            resultado = str.toString();
        }
        return resultado;
    }

    public static String rightFill(final String texto, final char caracter,
                                   final int size) {
        StringBuilder str = new StringBuilder(texto);
        for (int i = 0; i < (size - texto.length()); i++) {
            str.append(caracter);
        }
        return str.toString();
    }

    public static String formataMoeda(final Double numero) {
        if (numero != null) {
            DecimalFormat formato = (DecimalFormat) NumberFormat
                    .getInstance(new Locale("pt", "br"));
            formato.applyPattern("#,##0.00###");
            return formato.format(numero);
        }
        return null;
    }

    public static Double converteMoeda(final String numero)
            throws ParseException {
        if (numero != null) {
            DecimalFormat formato = (DecimalFormat) NumberFormat
                    .getInstance(new Locale("pt", "br"));
            formato.applyPattern("#,##0.00###");
            return formato.parse(numero).doubleValue();
        }
        return null;
    }

    public static String toEllipsis(final String input, final int maxCharacters) {
        if (input == null || input.length() <= maxCharacters) {
            return input;
        }
        return input.substring(0, maxCharacters) + "...";
    }

    public static String toEllipsis(final String input) {
        return toEllipsis(input, StringUtil.MAX_CHARACTERS);
    }

    public static String toNoSpaceEllipsis(final String input, final int maxCharacters) {
        if (input == null || input.length() <= maxCharacters) {
            return input;
        }
        if (input.matches(".*\\s+.*")) {
            return input;
        }
        return input.substring(0, maxCharacters) + "...";
    }

    public static String toNoSpaceEllipsis(final String input) {
        return toNoSpaceEllipsis(input, StringUtil.MAX_CHARACTERS);
    }
    public static String incluirBarraAdicionalParaEncodingURL(final String texto) {
        StringBuilder result = new StringBuilder();
        char[] caracteres = texto.toCharArray();
        for (char carac : caracteres) {
            if (carac == '\\') {
                result.append(carac);
                result.append("\\");
            } else {
                result.append(carac);
            }
        }
        return result.toString();
    }
    public static String converterJSONAspas(String jsonRetorno) {
        String[] array = jsonRetorno.split(": ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : array) {
            if (string.trim().startsWith("}")) {
                continue;
            }
            if (string.startsWith("\"") || string.trim().startsWith("{")){
                stringBuilder.append(string);
                if (!string.trim().endsWith("}")){
                    stringBuilder.append(": ");
                }
                continue;
            }
            stringBuilder.append("\"");
            stringBuilder.append(string.substring(0, string.indexOf(",")));
            stringBuilder.append("\",");
            stringBuilder.append(string.substring(string.indexOf(",") + 1, string.length()));
            stringBuilder.append(": ");
        }
        return stringBuilder.toString();
    }
    public static String converterAtributosInteirosJSONEmString(String json) {
        String[] vetorAux = json.split("\":");
        StringBuilder sb = new StringBuilder();
        for (String strObjeto : vetorAux) {
            String[] vetor = strObjeto.split(",");
            boolean adicionouVirgula = false;
            for (String strAtributoValor : vetor) {
                if (StringUtils.isNumeric(strAtributoValor)){
                    sb.append("\"");
                    sb.append(strAtributoValor);
                    sb.append("\"");
                }else{
                    sb.append(strAtributoValor);
                }
                if (strObjeto.equals(strAtributoValor)) {
                    continue;
                }
                if (!adicionouVirgula) {
                    sb.append(",");
                    adicionouVirgula = true;
                }
            }
            sb.append("\":");
        }
        String result = sb.toString();
        if (result.endsWith("\":")) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }
    public static String preencherComEspacos(final String texto, final int size) {
        String result = null;
        if (texto == null) {
            result = leftFill(" ", ' ', size);
        } else {
            result = leftFill(texto, ' ', size);
        }
        return result;
    }
    public static String preencherComZeros(final BigInteger value, final int size) {
        String result = null;
        if (value == null) {
            result = preencherComZeros("0", size);
        } else {
            result = preencherComZeros(value.toString(), size);
        }
        return result;
    }
    public static String preencherComEspacosMoeda(final BigDecimal value, final int size) {
        String result = null;
        if (value == null) {
            result = preencherComEspacos(" ", size);
        } else {
            result = preencherComEspacos(somenteNumeros(value.toPlainString()), size);
        }
        return result;
    }
    public static String preencherComZeros(final String texto, final int size) {
        String result = null;
        if (texto == null) {
            result = leftFill("0", '0', size);
        } else {
            result = leftFill(texto, '0', size);
        }
        return result;
    }
    public static String preencherComZerosMoeda(final BigDecimal value, final int size) {
        String result = null;
        if (value == null) {
            result = preencherComZeros("0", size);
        } else {
            result = preencherComZeros(somenteNumeros(value.toPlainString()), size);
        }
        return result;
    }

    public static boolean isNumeric(String agCliPagdr) {
        return StringUtils.isNumeric(agCliPagdr);
    }
    public static boolean possuiCaracterEspecial(String texto) {
        Pattern padrao = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        Matcher matcher = padrao.matcher(texto);
        return matcher.find();
    }
    public static boolean isTamanhoValido(String str, int maxLength) {
        return str != null && str.length() <= maxLength;
    }


}


