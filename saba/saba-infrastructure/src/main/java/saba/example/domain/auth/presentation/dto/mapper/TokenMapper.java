package saba.example.domain.auth.presentation.dto.mapper;

import saba.example.domain.auth.dto.request.EmailAuthRequestApp;
import saba.example.domain.auth.dto.response.TokenResponseApp;
import saba.example.domain.auth.presentation.dto.request.EmailAuthRequestInfra;
import saba.example.domain.auth.presentation.dto.response.TokenResponseInfra;

public class TokenMapper {
    public TokenResponseApp toApp(TokenResponseInfra request){
        return TokenResponseApp.builder()
                .refreshToken(request.getRefreshToken())
                .refreshExpiresTime(request.getRefreshExpiresTime())
                .accessToken(request.getAccessToken())
                .refreshExpiresTime(request.getRefreshExpiresTime())
                .build();
    }
    public TokenResponseInfra toInfra(TokenResponseApp request){
        return TokenResponseInfra.builder()
                .refreshToken(request.getRefreshToken())
                .refreshExpiresTime(request.getRefreshExpiresTime())
                .accessToken(request.getAccessToken())
                .refreshExpiresTime(request.getRefreshExpiresTime())
                .build();
    }
}
