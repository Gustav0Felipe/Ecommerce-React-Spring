package com.api.dto.OutputDto;

public record DtoPedidoDetalhado  (Integer num_ped, String nome_cli, String nome_prod, Integer qtd_prod, Double val_prod, String data_inicial, String data_final, Double valor_total, String status_ped) {}
