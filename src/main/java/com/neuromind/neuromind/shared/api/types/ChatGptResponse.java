package com.neuromind.neuromind.shared.api.types;

import java.util.List;

public record ChatGptResponse(
        List<Choice> choices
) {
}
