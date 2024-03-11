import { Footer } from "../../components/footer/footer";
import Header from "../../components/header/header";
import { Link, useParams } from "react-router-dom";
import { usePedidoDetails } from "../../hooks/usePedidoDetails";
import axios from "axios";

const API_URL = 'http://localhost:8080'

export function DetalhesDoPedido(){
	const { pedidoId } = useParams();
	const pedidoEProdutos = usePedidoDetails(pedidoId).data;
	var pedidoDetails : any;
	if(pedidoEProdutos != null){
		pedidoDetails = pedidoEProdutos[Object.keys(pedidoEProdutos)[0]].pedidosProdutosId.num_ped
	}
	
	const finalizarPedido = async () =>{
		const response = await axios.put(API_URL + "/loja/admin/listar/pedido?pedido=" + pedidoId);
		return response;
	}
    return(
    <>
    <Header></Header>
    <section id="section-principal">
	<div>
		<table className="pedidos">
            <tbody>
				<tr className="pedido">
					<th scope="col">Pedido</th> 
					<th scope="col">Cliente</th> 
					<th scope="col">Data inicial</th> 
					<th scope="col">Data Final</th> 
					<th scope="col">Valor Total</th> 
					<th scope="col">Status</th> 
				</tr>
				{pedidoDetails != null &&
				<tr className="pedido">
				<td>{pedidoDetails.num_ped}</td> 
				<td>{pedidoDetails.cod_cli.nome_cli}</td>
				<td>{pedidoDetails.data_inicial} </td>
				<td>{pedidoDetails.data_final} </td>
				<td>{pedidoDetails.valor_total} </td>
				<td>{pedidoDetails.status_ped}</td>
				</tr>
				}
				<tr></tr>
				<tr>
					<th scope="col">Codigo</th>
					<th scope="col">Produto</th>
					<th scope="col">Categoria</th>
					<th scope="col">Quantidade</th>
					<th scope="col">Valor</th>
					<th scope="col">Total</th>
				</tr> 
                { 
				pedidoEProdutos?.map((produto : any) => 
                <tr className="pedido" key={produto.pedidosProdutosId.num_ped.num_ped + produto.pedidosProdutosId.id_prod.id_prod}>
                    <td>{produto.pedidosProdutosId.num_ped.num_ped}</td>
					<td>{produto.pedidosProdutosId.id_prod.id_prod}</td>
					<td>{produto.pedidosProdutosId.id_prod.cod_cat.nome_cat}</td>
                    <td>{produto.qtd_prod}</td> 
                    <td>{produto.val_prod} </td>
					<td>{produto.qtd_prod * produto.val_prod}</td>
                </tr>
                )
                } 
				{pedidoDetails != null &&	
				<tr className="pedido">
					<th scope="row" colSpan={5}>Total: </th>
					<td>{pedidoDetails.valor_total}</td>
				</tr>
				} 
            </tbody>
		</table>
		
		<button onClick={finalizarPedido}>
			<Link to={"/loja/admin/pedidos/" + pedidoId}>	Finalizar Pedido</Link>
		</button>
		
		<button>
		<Link to={"/loja/admin/pedidos"} className="material-symbols-outlined">
				arrow_back
		</Link>
		</button>
    </div>
	</section>
    <Footer></Footer>
    </>
    )
}