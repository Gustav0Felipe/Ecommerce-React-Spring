package com.api.InputDto;

import java.util.List;

public record PedidoDto(String id, String Cliente,List<CartItemDto> Produtos) {}