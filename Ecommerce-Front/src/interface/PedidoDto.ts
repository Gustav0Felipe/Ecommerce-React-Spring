import { OrderProduct } from "./OrderProduct";

export interface Pedido{
    Cliente : number,
    Produtos : OrderProduct[]
}