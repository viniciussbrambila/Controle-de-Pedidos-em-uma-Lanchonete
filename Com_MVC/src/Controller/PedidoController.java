package Controller;

import Model.Pedido;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private List<Pedido> bancoDePedidos = new ArrayList<>();

    public Pedido abrirPedido(String data) {
        Pedido novoPedido = new Pedido(data);
        bancoDePedidos.add(novoPedido);
        return novoPedido;
    }

    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto) {
        pedido.adicionarProduto(produto);
    }

    public void finalizarPedido(Pedido pedido) {
        pedido.finalizarPedido();
    }

    public List<Pedido> consultarPedidosDoDia(String data) {
        List<Pedido> pedidosDoDia = new ArrayList<>();
        for (Pedido p : bancoDePedidos) {
            if (p.getDataPedido().equals(data) && p.isFinalizado()) {
                pedidosDoDia.add(p);
            }
        }
        return pedidosDoDia;
    }

    public double calcularFaturamentoDoDia(String data) {
        double total = 0;
        for (Pedido p : consultarPedidosDoDia(data)) {
            total += p.getValorTotal();
        }
        return total;
    }
}