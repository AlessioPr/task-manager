package com.taskmanager.service;

import com.taskmanager.dto.BoardDto;

import java.util.List;

public interface BoardService {

  void saveBoard(BoardDto boardDto);
  List<BoardDto> getAll();
  BoardDto getBoardByUserId();
  BoardDto getById(Long boardId);
  void deleteBoardById(Long boardId);
}
