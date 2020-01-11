package com.taskmanager.controller;

import com.taskmanager.dto.CartDto;
import com.taskmanager.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("{boardId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CartDto> getAllByBoardId(@PathVariable Long boardId){
        return cartService.getAllByBoardId(boardId);
    }

    @PostMapping("/{boardId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CartDto createCart(@PathVariable Long boardId,
                              @RequestBody CartDto cartDto){
        return cartService.saveNewCart(cartDto, boardId);
    }
}
