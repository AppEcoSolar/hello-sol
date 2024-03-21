package br.com.hellosol.hellosol.enumx;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MensagemRetorno {
    SUCESSO_CRIACAO_USUARIO(TipoRetorno.SUCESSO, "Usuário Criado com Sucesso!", 1),
    SUCESSO_ALTERACAO_USUARIO(TipoRetorno.SUCESSO, "Usuário Alterado com Sucesso!", 2),
    SUCESSO_EXCLUSAO_USUARIO(TipoRetorno.SUCESSO, "Usuário Excluído com Sucesso!", 3),
    SUCESSO_CRIACAO_EMPRESA(TipoRetorno.SUCESSO, "Empresa Criada com Sucesso!", 4),
    SUCESSO_ALTERACAO_EMPRESA(TipoRetorno.SUCESSO, "Empresa Alterada com Sucesso!", 5),
    SUCESSO_EXCLUSAO_EMPRESA(TipoRetorno.SUCESSO, "Empresa Excluída com Sucesso!", 6),
    SUCESSO_CRIACAO_USINA(TipoRetorno.SUCESSO, "Usina Criada com Sucesso!", 7),
    SUCESSO_ALTERACAO_USINA(TipoRetorno.SUCESSO, "Usina Alterada com Sucesso!", 8),
    SUCESSO_EXCLUSAO_USINA(TipoRetorno.SUCESSO, "Usina Excluída com Sucesso!", 9);

    private final TipoRetorno tipoRetorno;
    private final String dsMensagem;
    private final Integer codMensagem;
}
