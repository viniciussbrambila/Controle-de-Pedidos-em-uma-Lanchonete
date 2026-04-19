package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String dataPedido;
    private List<Produto> produtos;
    private double valorTotal;
    private boolean finalizado;

    public Pedido(String dataPedido) {
        this.dataPedido = dataPedido;
        this.produtos = new ArrayList<>();
        this.valorTotal = 0.0;
        this.finalizado = false;
    }

    public void adicionarProduto(Produto produto) {
        if (finalizado) {
            throw new IllegalStateException("Erro: Não é possível adicionar produtos a um pedido já finalizado.");
        }
        this.produtos.add(produto);
        this.valorTotal += produto.getPreco();
    }

    public void finalizarPedido() {
        if (produtos.isEmpty()) {
            throw new IllegalStateException("Erro: Um pedido não pode ser finalizado sem produtos.");
        }
        this.finalizado = true;
    }

    public void exibirCupom() {
        System.out.println("--- Cupom do Pedido (" + dataPedido + ") ---");
        for (Produto p : produtos) {
            System.out.println("1x " + p.getNome() + " - R$" + p.getPreco());
        }
        System.out.println("Status: " + (finalizado ? "FINALIZADO" : "ABERTO"));
        System.out.println("Total: R$" + valorTotal);
        System.out.println("------------------------------------");
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getDataPedido() { return dataPedido; }
    public double getValorTotal() { return valorTotal; }
    public boolean isFinalizado() { return finalizado; }
}