package com.telran.scheduler.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class AuthResponseDto {
    boolean registration;
    String status;
    String token;

}
