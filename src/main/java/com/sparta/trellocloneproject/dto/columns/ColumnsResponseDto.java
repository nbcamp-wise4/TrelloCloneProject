package com.sparta.trellocloneproject.dto.columns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.sparta.trellocloneproject.entity.Columns;
@Getter
@NoArgsConstructor
public class ColumnsResponseDto {
    private String title;
    private Long position;

    public ColumnsResponseDto(Columns columns){
    this.title = columns.getTitle();
    this.position = columns.getPosition();

    }
}
