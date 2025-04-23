package com.stream.playload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomMessage {

    private String message;
    private boolean success=false;
}
