package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> listaProd = new ArrayList<>();

		System.out.print("QUANTOS PRODUTOS IRÁ CADASTRAR?");
		int qtd = sc.nextInt();

		for (int i = 1; i <= qtd; i++) {
			System.out.println("PRODUTO [C]omum - [I]mportado - [U]sado");
			char op = sc.next().charAt(0);
			sc.nextLine();

			if (op == 'c' || op == 'C') {
				System.out.println("PRODUTO: ");
				String nome = sc.nextLine();
				System.out.println("PREÇO: ");
				Double preco = sc.nextDouble();

				Produto produto = new Produto(nome, preco);
				listaProd.add(produto);

			} else if (op == 'i' || op == 'I') {
				System.out.println("PRODUTO: ");
				String nome = sc.nextLine();
				System.out.println("PREÇO: ");
				Double preco = sc.nextDouble();
				System.out.println("TAXA IMPORTACAO: %");
				Double taxaImportacao = sc.nextDouble();

				Produto produto = new ProdutoImportado(nome, preco, taxaImportacao);
				listaProd.add(produto);

			} else if (op == 'u' || op == 'U') {
				System.out.println("PRODUTO: ");
				String nome = sc.nextLine();
				System.out.println("PREÇO: ");
				Double preco = sc.nextDouble();
				System.out.println("DATA DE FABRICAÇÃO (dd/MM/aaaa)");
				Date dataFabricacao = sdf.parse(sc.next());

				Produto produto = new ProdutoUsado(nome, preco, dataFabricacao);
				listaProd.add(produto);

			}

			if (i == qtd) {
				for (Produto produto : listaProd) {
					System.out.println(produto.etiqueta());
				}
			}

		}

		sc.close();

	}

}
