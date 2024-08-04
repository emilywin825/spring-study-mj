package hello.hellospring.domain.KakaoLogin;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getName();
}
