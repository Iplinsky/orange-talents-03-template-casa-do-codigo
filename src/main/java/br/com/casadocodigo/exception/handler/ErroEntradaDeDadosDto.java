package br.com.casadocodigo.exception.handler;

public class ErroEntradaDeDadosDto {

	private String campo;
	private String erro;

	public ErroEntradaDeDadosDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
