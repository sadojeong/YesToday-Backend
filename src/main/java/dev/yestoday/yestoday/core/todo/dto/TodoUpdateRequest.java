package dev.yestoday.yestoday.core.todo.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class TodoUpdateRequest {
    public Long id;

    public String name;
    public String todoDescription;
}
