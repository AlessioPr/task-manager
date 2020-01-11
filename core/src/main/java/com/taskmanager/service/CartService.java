package com.taskmanager.service;

import com.taskmanager.dto.CartDto;

import java.util.List;

public interface CartService {

  List<CartDto> getAllByBoardId(Long boarId);
  CartDto saveNewCart(CartDto cartDto, Long boardId);
}
