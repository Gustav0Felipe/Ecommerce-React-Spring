import axios, { AxiosPromise } from "axios"
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { ProductDataDto } from "../interface/ProductDataDto";



const API_URL = 'http://localhost:8080'

const postData = async (data : ProductDataDto) : AxiosPromise<any> => {
    const response = await axios.post(API_URL + "/loja/admin/cadastrar-produto", data) //segundo parametro seriam headers
    console.log(response);
    return response;
}

export function useProductMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,//função usada para fazer fetch dos dados
        retry: 2,
        onSuccess: () => {queryClient.invalidateQueries({queryKey: ['product-data']})} //quando eu postar um produto novo, a query de pegar produtos sera invalidada, por que ela esta desatualizada e tem de atualizar.
    })
    
    return mutate;
}
