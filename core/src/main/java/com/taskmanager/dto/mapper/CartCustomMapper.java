package com.taskmanager.dto.mapper;

import com.taskmanager.dto.CartDto;
import com.taskmanager.dto.CartRecordDto;
import com.taskmanager.entity.Board;
import com.taskmanager.entity.Cart;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CartCustomMapper {

    public static List<CartDto> mapToCartDtoList(Collection<Cart> carts){
        return carts.stream()
                .map(CartCustomMapper::mapToCartDto)
                .collect(Collectors.toList());
    }

    public static CartDto mapToCartDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setDescription(cart.getDescription());
        cartDto.setTitle(cart.getTitle());
        List<CartRecordDto> cartRecords = new java.util.ArrayList<>(cart.getCartRecords() != null ? CartRecordCustomMapper
                .mapToCartRecordListDto(cart.getCartRecords()) :
                Collections.emptyList());
        cartRecords.sort(Comparator.comparing(CartRecordDto::getOrder));
        cartDto.setCartRecords(cartRecords);
        return cartDto;
    }

    public static Cart mapToCart(CartDto cartDto, Long boarId){
        Cart cart = new Cart();
        cart.setTitle(cartDto.getTitle());
        cart.setDescription(cartDto.getDescription());
        Board board = new Board();
        board.setId(boarId);
        cart.setBoard(board);
        return cart;
    }
}
