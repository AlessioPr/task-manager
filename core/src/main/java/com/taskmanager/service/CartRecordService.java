package com.taskmanager.service;

import com.taskmanager.dto.CartRecordChangeCartDto;
import com.taskmanager.dto.CartRecordDto;

public interface CartRecordService {

  CartRecordDto saveCartRecord(CartRecordDto cartRecordDto, Long cartId);

  void changeRecordsOrder(Long cartRecordId, Integer changeIndex, Long cartId);

  Long countAllByCartId(Long cartRecordId);

  void changeCart(CartRecordChangeCartDto cartRecordChangeCartDto);

  CartRecordDto getOne(Long cartRecordId);

}
