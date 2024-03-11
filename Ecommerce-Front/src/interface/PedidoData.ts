import { ClientData } from "./ClientData";

export interface PedidoData {
    num_ped: number,
    cod_cli: ClientData, 
    data_inicial: string, 
    data_final: string, 
    status_ped : string,
    valor_total: number,
}
