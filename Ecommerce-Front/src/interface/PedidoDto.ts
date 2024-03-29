import { OrderProduct } from "./OrderProduct";

export interface Pedido{
    clienteId: number,
    nome : string,
    cpf: string,
    produtos : OrderProduct[]
}