package com.sparta.trellocloneproject.controller.card;

import com.sparta.trellocloneproject.dto.card.requestDto.CardRequestDto;
import com.sparta.trellocloneproject.dto.card.responseDto.CardResponseDto;
import com.sparta.trellocloneproject.dto.card.requestDto.CardUpdateRequestDto;
import com.sparta.trellocloneproject.repository.column.ColumnsRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import com.sparta.trellocloneproject.service.card.CardService;
import com.sparta.trellocloneproject.service.board.BoardMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/card")
@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final BoardMemberService boardMemberService;
    private final ColumnsRepository columnsRepository;

    @PostMapping("/{boardId}/{columnId}")
    public String createCard(@RequestBody CardRequestDto requestDto,@PathVariable Long boardId,@PathVariable Long columnId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            cardService.createCard(requestDto,columnsRepository.getReferenceById(columnId));
            return "ok"; }
        throw new RuntimeException("");
    }
    @PutMapping("{boardId}/{cardId}/title")
    public String updateCardTitle(@RequestBody CardUpdateRequestDto requestDto, @PathVariable Long cardId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            cardService.updateCardTitle(requestDto.getDataToUpdate(),cardId);
            return "ok";
        }
        throw new RuntimeException("");
    }

    @PutMapping("{boardId}/{cardId}/description")
    public String updateCardDescription(@RequestBody CardUpdateRequestDto requestDto, @PathVariable Long cardId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            cardService.updateCardDescription(requestDto.getDataToUpdate(),cardId);
            return "ok";
        }
        throw new RuntimeException("");
    }

    @PutMapping("{boardId}/{cardId}/color")
    public String updateCardColor(@RequestBody CardUpdateRequestDto requestDto, @PathVariable Long cardId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            cardService.updateCardColor(requestDto.getDataToUpdate(),cardId);
            return "ok";
        }
        throw new RuntimeException("");
    }

    @PutMapping("{boardId}/{cardId}/date1")
    public String updateStartDate(@RequestBody CardUpdateRequestDto requestDto, @PathVariable Long cardId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            cardService.updateCardStartDate(requestDto.getDataToUpdate(),cardId);
            return "ok";
        }
        throw new RuntimeException("");
    }

    @PutMapping("{boardId}/{cardId}/date2")
    public String updateDueDate(@RequestBody CardUpdateRequestDto requestDto, @PathVariable Long cardId, @PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            cardService.updateCardDueDate(requestDto.getDataToUpdate(),cardId);
            return "ok";
        }
        throw new RuntimeException("");
    }
@DeleteMapping("{boardId}/{cardId}")
    public String deleteCard(@PathVariable Long cardId,@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
    if(boardMemberService.isUserMember(userDetails,boardId)) {
        cardService.deleteCard(cardId);
        return "ok";
    }
    throw new RuntimeException("");
}

    @GetMapping("/{boardId}/{columnId}")
    public ResponseEntity<List<CardResponseDto>> getCardList(@PathVariable Long boardId,@PathVariable Long columnId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(boardMemberService.isUserMember(userDetails,boardId)){
            List<CardResponseDto> CardList = cardService.getAllCardOfColumn(columnId);
            return new ResponseEntity<>(CardList, HttpStatus.OK);
        }
        return null;

    }

}