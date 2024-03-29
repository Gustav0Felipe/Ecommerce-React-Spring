import axios from "axios";
import { useContext } from "react";
import { useQueryClient, useMutation } from "@tanstack/react-query";
import { UserContext } from "../context/userContext";

const API_URL = 'http://localhost:8080'

export function usePedidoDetailsMutate(){

    const { user } = useContext(UserContext);
    const putData = async (pedidoId : any) => {
        const finalizarPedido = await axios.put(API_URL + "/loja/admin/listar/pedido?pedido=" + pedidoId, null,
        {
            headers : {
                'Authorization': user.token
            }

        });
        return finalizarPedido;
    }
    const queryClient = useQueryClient();
    const mutate = useMutation({
        
        mutationFn: putData,
        retry: 2,
        onSettled: () => {
            queryClient.invalidateQueries({queryKey: ['pedido-details']});
        }
    
    })
    
    return mutate;
}
