package com.api.dto.InputDto;

import java.util.List;

public record PedidoDto(String clienteId, String nome, String cpf, List<CartItemDto> produtos) {}