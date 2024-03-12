package br.com.hellosol.hellosol.Response;

import br.com.hellosol.hellosol.enumx.MensagemRetorno;
import br.com.hellosol.hellosol.enumx.TipoRetorno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OperacaoResponse {
    private TipoRetorno tipoRetorno;
    private String dsMensagem;
    private Integer codMensagem;
    public OperacaoResponse(MensagemRetorno mensagem) {
        this.tipoRetorno = mensagem.getTipoRetorno();
        this.dsMensagem = mensagem.getDsMensagem();
        this.codMensagem = mensagem.getCodMensagem();
    }
}