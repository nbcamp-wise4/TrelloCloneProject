package com.sparta.trellocloneproject.service.comment;

import com.sparta.trellocloneproject.dto.comment.CommentRequestDto;
import com.sparta.trellocloneproject.entity.Comment;
import com.sparta.trellocloneproject.repository.card.CardRepository;
import com.sparta.trellocloneproject.repository.comment.CommentRepository;
import com.sparta.trellocloneproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CardRepository cardRepository;
    private final CommentRepository commentRepository;
    public Comment createComment(Long cardId, CommentRequestDto commentRequestDto, UserDetailsImpl userDetails){
       Comment comment = new Comment(commentRequestDto,cardRepository.getReferenceById(cardId),userDetails.getUser().getName());
       return commentRepository.save(comment);

    }

    public void deleteComment(Long ID) {
        commentRepository.deleteById(ID);
    }
}
