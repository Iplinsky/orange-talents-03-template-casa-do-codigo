package br.com.casadocodigo.entityFormDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.casadocodigo.entity.Cliente;
import br.com.casadocodigo.entity.Estado;
import br.com.casadocodigo.entity.Pais;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.validator.CountryContains;
import br.com.casadocodigo.validator.UniqueValue;
import br.com.casadocodigo.validator.ValidCpfCnjp;

@CountryContains
public class ClienteFormDto {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@ValidCpfCnjp
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpf_cnpj")
	private String cpf_cnpj;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull(message = "É necessário informar um país!")
	private Long codPais;

	private Long codEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getCodPais() {
		return codPais;
	}

	public Long getCodEstado() {
		return codEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.getOne(codPais);
		Estado estado = codEstado != null ? estadoRepository.getOne(codEstado) : null;

		return new Cliente(email, nome, sobrenome, cpf_cnpj, endereco, complemento, cidade, pais, estado, telefone,
				cep);
	}
}
