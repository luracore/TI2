package model;

*import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String DESCRICAO_PADRAO = "Novo Produto";
	public static final int MAX_ESTOQUE = 1000;
	private int id;
	private String descricao;
	private float preco;
	private int quantidade;
	private LocalDateTime dataFabricacao;
	private LocalDate dataValidade;
	
	public Produto() {
		id = -1;
		descricao = DESCRICAO_PADRAO;
		preco = 0.01F;
		quantidade = 0;
		dataFabricacao = LocalDateTime.now();
		dataValidade = LocalDate.now().plusMonths(6);
	}
	
	public Produto (int id, String descricao, float preco, int qualidade, LocalDateTime fabricacao, LocalDate v) {
		setId(id);
		setDescricao(descricao);
		setPreco(preco);
		setQuant(quantidade);
		setDataFabricacao(fabricacao);
		setDataValidade(v);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao.length() >= 3)
			this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		if(preco > 0)
			this.preco = preco;
	}
	public int getQuant() {
		return quantidade;
	}
	public void setQuant(int quantidade) {
		if(quantidade >= 0 && quantidade <= MAX_ESTOQUE)
			this.quantidade = quantidade;
	}
	public LocalDateTime getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(LocalDateTime dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public boolean emValidade() {
		return LocalDateTime.now().isBefore(this.getDataValidade().atTime(23,59));
	}
	
	@Override
	public String toString() {
		return "Produto: " + descricao + " Preço: R$" + preco + "Quant: " + quantidade + " Fabricação: " + dataFabricacao + " Data de Validade: " + dataValidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getId() == ((Produto) obj).getId());
	}
}
