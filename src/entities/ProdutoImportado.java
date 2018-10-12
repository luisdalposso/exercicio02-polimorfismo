package entities;

public class ProdutoImportado extends Produto{

	private Double taxaImportacao;
	
	public ProdutoImportado() {
	}

	public ProdutoImportado(String nome, Double preco, Double taxaImportacao) {
		super(nome, preco);
		this.taxaImportacao = taxaImportacao;
	}

	public Double getTaxaImportacao() {
		return taxaImportacao;
	}

	public void setTaxaImportacao(Double taxaImportacao) {
		this.taxaImportacao = taxaImportacao;
	}
	
	public double custoFinal() {
		return preco * ((1 + taxaImportacao) / 10); 
	}
	
	@Override
	public String etiqueta() {
		return super.etiqueta() + "TAXA DE IMPORTAÇÃO: " + taxaImportacao + "% \n"
				+ "PREÇO FINAL: R$" + custoFinal() + "\n";
	}
	
}
