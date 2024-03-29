import axios, { AxiosPromise } from "axios"
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { ProductDataDto } from "../interface/ProductDataDto";
import { useContext } from "react";
import { UserContext } from "../context/userContext";



const API_URL = 'http://localhost:8080'



export function useProductMutate(){

    const { user } = useContext(UserContext);
    
    const postData = async (data : ProductDataDto) : AxiosPromise<any> => {
        const response = await axios.post(API_URL + "/loja/admin/cadastrar-produto", data, 
        {
            headers : {
                'Authorization' : user.token,
               
            }
        }) 
        console.log(response);
        return response;
    }
    const queryClient = useQueryClient();
    const mutate = useMutation({
        
        mutationFn: postData,//função usada para fazer fetch dos dados
        retry: 2,
        onSettled: () => {
            queryClient.invalidateQueries({queryKey: ['product-data']});
        }
    
    })
    
    return mutate;
}
