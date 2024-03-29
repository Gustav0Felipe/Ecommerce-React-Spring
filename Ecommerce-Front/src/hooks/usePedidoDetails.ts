import axios, { AxiosPromise } from "axios"
import { useQuery } from "@tanstack/react-query";
import { useContext } from "react";
import { UserContext } from "../context/userContext";


const API_URL = 'http://localhost:8080'



export function usePedidoDetails(pedidoId : any ){

    const { user } = useContext(UserContext);
   
    const fetchPedidoDetails = async () : AxiosPromise => {
        const response = await axios.get(API_URL + "/loja/admin/listar/pedido?pedido=" + Number.parseInt(pedidoId),
        {
            headers : {
                'Authorization' : user.token
            }
        })
        console.log(response)
        return response;
    }
    const query = useQuery({
        queryFn: fetchPedidoDetails,
        queryKey: ['pedido-details'],
        retry: 2
    })
    
    return { ...query,
        data: query.data?.data};
    
}
