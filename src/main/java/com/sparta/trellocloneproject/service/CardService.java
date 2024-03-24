package com.sparta.trellocloneproject.service;

import com.sparta.trellocloneproject.dto.board.responseDto.BoardResponseDto;
import com.sparta.trellocloneproject.dto.card.CardRequestDto;
import com.sparta.trellocloneproject.dto.card.CardResponseDto;
import com.sparta.trellocloneproject.entity.Card;
import com.sparta.trellocloneproject.entity.Columns;
import com.sparta.trellocloneproject.repository.CardRepository;
import com.sparta.trellocloneproject.repository.ColumnsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final ColumnsRepository columnsRepository;
    public Card createCard(CardRequestDto requestDto,Columns column){
        Card card = new Card(requestDto,column);
        return cardRepository.save(card);
    }

    public Card updateCardTitle(String title,Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()-> new IllegalArgumentException("해당 카드이 존재하지 않습니다"));
        card.updateTitle(title);
        return cardRepository.save(card);
    }

    public Card updateCardDescription(String description,Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()-> new IllegalArgumentException("해당 카드이 존재하지 않습니다"));
        card.updateDescription(description);
        return cardRepository.save(card);
    }

    public Card updateCardColor(String title,Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()-> new IllegalArgumentException("해당 카드이 존재하지 않습니다"));
        card.updateColor(title);
        return cardRepository.save(card);
    }

    public Card updateCardStartDate(String startDate,Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()-> new IllegalArgumentException("해당 카드이 존재하지 않습니다"));
        card.updateStartDate(startDate);
        return cardRepository.save(card);
    }

    public Card updateCardDueDate(String dueDate,Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()-> new IllegalArgumentException("해당 카드이 존재하지 않습니다"));
        card.updateDueDate(dueDate);
        return cardRepository.save(card);
    }

    public void deleteCard(Long cardId){
        cardRepository.deleteById(cardId);

    }

    public Card getCard(Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()-> new IllegalArgumentException("해당 카드이 존재하지 않습니다"));
        return card;
    }

    public List<CardResponseDto> getAllCardOfColumn(Long columId){
        List<Card> cardList =  columnsRepository.getReferenceById(columId).getCards();
        return cardList.stream().map(CardResponseDto::new).toList();
    }

}