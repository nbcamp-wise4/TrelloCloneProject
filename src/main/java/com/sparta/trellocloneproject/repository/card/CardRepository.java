package com.sparta.trellocloneproject.repository.card;

import com.sparta.trellocloneproject.entity.Card;
import com.sparta.trellocloneproject.entity.Columns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
List<Card> findCardsByColumns(Columns column);
}