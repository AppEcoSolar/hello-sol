package br.com.hellosol.hellosol.enumx;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MensagemRetorno {
    SUCESSO_CRIACAO_USUARIO(TipoRetorno.SUCESSO, "Usuário Criado com Sucesso!", 1),
    SUCESSO_ALTERACAO_USUARIO(TipoRetorno.SUCESSO, "Usuário Alterado com Sucesso!", 2);

    private final TipoRetorno tipoRetorno;
    private final String dsMensagem;
    private final Integer codMensagem;
}
