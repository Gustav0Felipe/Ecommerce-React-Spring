import axios, { AxiosPromise } from "axios"
import { ProductData } from "../interface/ProductData";
import { useQuery } from "@tanstack/react-query";


const API_URL = 'http://localhost:8080'

const fetchData = async () : AxiosPromise<ProductData[]> => {
    const response = await axios.get(API_URL + "/loja") //segundo parametro seriam headers
    console.log("fazendo o fetch")
    return response;
}

export function useProductData(){
    const query = useQuery({
        queryFn: fetchData,//função usada para fazer fetch dos dados
        queryKey: ['product-data'],
        retry: 2
    })
    
    return { ...query,
        data: query.data?.data};
    
}
