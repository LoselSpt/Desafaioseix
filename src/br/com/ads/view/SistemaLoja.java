package br.com.ads.view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.ads.dao.ProdutoDAO;
import br.com.ads.model.Produto;

public class SistemaLoja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        int opcao = 0;

        System.out.println("=== SISTEMA DE ESTOQUE COM OPTIONAL E LAMBDAS ===");

        while (opcao != 3) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Listar todos os produtos ");
            System.out.println("2 - Buscar produto por ID");
            System.out.println("3 - Sair");
            System.out.print("Sua opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                scanner.next();
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Lista de Produtos ---");
                    List<Produto> produtos = dao.listarTodos();

                    produtos.forEach(p -> System.out.println(p));

                    if (produtos.isEmpty())
                        System.out.println("Nenhum produto cadastrado.");
                    break;

                case 2:
                    System.out.print("\nDigite o ID do produto: ");
                    int idBusca = scanner.nextInt();

                    Optional<Produto> resultado = dao.buscarPorId(idBusca);

                    System.out.println("Resultado da busca:");

                    resultado.ifPresentOrElse(
                            (prod) -> {
                                System.out.println("✅ ENCONTRADO: " + prod.getNome());
                                System.out.println("   Detalhes: " + prod.toString());
                            },
                            () -> {
                                System.out.println("❌ ERRO: Produto com ID " + idBusca + " não existe no banco.");
                            });
                    break;

                case 3:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}