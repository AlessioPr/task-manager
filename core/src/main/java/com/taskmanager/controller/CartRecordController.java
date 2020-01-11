package com.taskmanager.controller;

import com.taskmanager.dto.CartRecordChangeCartDto;
import com.taskmanager.dto.CartRecordDto;
import com.taskmanager.dto.CartRecordQuery;
import com.taskmanager.service.CartRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart-record")
public class CartRecordController {

    private final CartRecordService cartRecordService;

    public CartRecordController(CartRecordService cartRecordService) {
        this.cartRecordService = cartRecordService;
    }

    @PostMapping("{cartId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CartRecordDto saveCartRecord(@PathVariable Long cartId,
                                        @RequestBody CartRecordDto cartRecordDto){
        return cartRecordService.saveCartRecord(cartRecordDto, cartId);
    }

    @PutMapping("{cartId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CartRecordDto updateCartRecord(@PathVariable Long cartId,
                                          @RequestBody CartRecordDto cartRecordDto){

        return cartRecordService.saveCartRecord(cartRecordDto, cartId);
    }

    @GetMapping("{cartRecordId}")
    public Long getAllByCartIdRecord(@PathVariable Long cartRecordId){
        return cartRecordService.countAllByCartId(cartRecordId);
    }

    @PutMapping("/change-order")
    @CrossOrigin(origins = "http://localhost:4200")
    public void changeOrder(@RequestBody CartRecordQuery cartRecordQuery){
        cartRecordService.changeRecordsOrder(cartRecordQuery.getCartRecordId(),
            cartRecordQuery.getChangeIndex(), cartRecordQuery.getCartId());
    }

    @PutMapping("/change-cart")
    @CrossOrigin(origins = "http://localhost:4200")
    public void changeCart(@RequestBody CartRecordChangeCartDto cartRecordChangeCartDto){
        cartRecordService.changeCart(cartRecordChangeCartDto);
    }
}
