package com.taskmanager.service.impl;

import com.taskmanager.dto.CartDto;
import com.taskmanager.dto.mapper.CartCustomMapper;
import com.taskmanager.entity.Cart;
import com.taskmanager.repository.CartRepository;
import com.taskmanager.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public List<CartDto> getAllByBoardId(Long boarId){
        return CartCustomMapper.mapToCartDtoList(cartRepository.getAllByBoardId(boarId));
    }

    public CartDto saveNewCart(CartDto cartDto, Long boardId){
        Cart save = cartRepository.save(CartCustomMapper.mapToCart(cartDto, boardId));
        return CartCustomMapper.mapToCartDto(save);
    }
}
