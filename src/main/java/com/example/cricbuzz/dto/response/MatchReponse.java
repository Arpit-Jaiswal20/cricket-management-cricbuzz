package com.example.cricbuzz.dto.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MatchReponse {

    String title;

    String venue;

    Date created;

    List<TeamReponse> teams;
}
