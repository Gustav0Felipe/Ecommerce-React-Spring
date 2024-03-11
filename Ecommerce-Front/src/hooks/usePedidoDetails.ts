import axios, { AxiosPromise } from "axios"
import { useQuery } from "@tanstack/react-query";


const API_URL = 'http://localhost:8080'



export function usePedidoDetails(pedidoId : any ){

   

    const fetchPedidoDetails = async () : AxiosPromise => {
    const response = await axios.get(API_URL + "/loja/admin/listar/pedido?pedido=" + Number.parseInt(pedidoId)) //segundo parametro seriam headers
    
    return response;
    }
    const query = useQuery({
        queryFn: fetchPedidoDetails,//função usada para fazer fetch dos dados
        queryKey: ['pedido-details'],
        retry: 2
    })
    
    return { ...query,
        data: query.data?.data};
    
}
