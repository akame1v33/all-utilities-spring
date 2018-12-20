//package com.myallutilities.utilities.config;
//
//import com.oauth2.server.server.service.CustomClientDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig implements AuthorizationServerConfigurer {
//
//    @Autowired private AuthenticationManager authenticationManager;
//
//    @Autowired private CustomClientDetailService customClientDetailService;
//
//
//    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
//            "MIIEpAIBAAKCAQEAxIfYXUZkWyNtfBXtaggdU/SvRedRnd8cMj9PBuNg/R3LuLBG\n" +
//            "vP6hkoYZyLqF9ElfFlOh2aCxwUtMewY6x9cunGdBWMdZiBEhePkKN9i4j5dNSmKt\n" +
//            "6nBvtMOMa20svhTcWLSOCqFsPaU/HFX++Quw9O3RlkE74H1bbvp2oGjFLTliXEEt\n" +
//            "Dv/7mqkv6XC4Cx0ALD68r6FXDfnjYhaxIARnRqKbm0LLFswdPFXrOhXqURSWNXKD\n" +
//            "gFh4LtpO0lB6F9cBmNnzzkYnWgl6hVjNR7A56w34nY2J1BuRYkXw5gIghMaQkkpC\n" +
//            "WMX21APgowawmZxBFDxE4si08Jl5Hod7yGde8QIDAQABAoIBAQCmJaZALNt4xTmx\n" +
//            "FqSQ6G1K5egrs8SnL9CZljYMP7xmIINzDuuuqaIUynQP48iNXl4Z9Pg2kQjVvf/Z\n" +
//            "Xcnh2sQYC58OG/JP+xOOPxRpZDmbgzEfes9HDGkTq+IRi8mwpNgn0fTnfdKRRxtU\n" +
//            "rEsTZtPiLQ/r9BhX0AK1jt8s+4X+lTD/dC6oPudTWBr3S2e/hPVBCT4sa1CysJMS\n" +
//            "qeliQysNTAZ6S67QUReq9iSuFi5QzjdHYsT0DTIykYsr0dJZuqiITcnFriGEo070\n" +
//            "+1sjdsIg5ISYRoKdLzmFVfY1yKa+YsMhJIrp51utQZbzIwhXkG68STl+Cz53mPBx\n" +
//            "LYCy8RYVAoGBAPXHnQVX75fnl52R4YKAybpQJw1AQCnmIYwKEnm/ErZiPKD2Ibiw\n" +
//            "xYYKTFww8s55hHqbJfpau45eF/vJ0n13ZYV1IQy9oE5dOVpouc8lhhXVClfhAklL\n" +
//            "+p3kB0q0pSeFyn+lo6m+S6ZE7fGL+zzqY7Oq5Po0CF6ZcTeAvSXEyqA/AoGBAMyz\n" +
//            "9oGVDxtfkbc8K/9CQEnIV5TeXxsZP2Jw8umJNGx5Vf0OMvikzPMdqWXpd/7AVUY6\n" +
//            "mAiSjz11DVqESQHTr1H1f0GxxBCddchBgCjPNn5V7BfjCEw6SsqUmLlG2WfM84eV\n" +
//            "n/ALc/Hma+qRWsnlYQuV2vMsXuNa2g702ItvPTTPAoGAD1mJH/VO/GC1YlzjBaB/\n" +
//            "eMhauAQkPbmmrLVQVBQv2f4mpTLaBkvb+jQYcsWH1IdYU8PuykTyY8DSpKIFKFrV\n" +
//            "l1EqYD5TjbFazJ+vwxUn26MzgyuFVgiNvWCpZ+wCSIadj/1LTGWbGeZCKgzBAxvs\n" +
//            "YCMzK8EmKKpSnNHIflxc/0cCgYAbQ8kMf2cQtUz6Q+h0SkW3zhhkOq4eNOGtYe/o\n" +
//            "zR6PaCXc27xMQ98MbqH2cf9KjiGNhhZj5elwPRv3N3Fl7eUHHJTDkkLUF7TtZFQG\n" +
//            "m3rdnuIgWFvtk0IM83fYDai9W54ALByuY0ghKxiqmIuoIoYnfeE4zGsjCyHKJjCF\n" +
//            "ed6EHwKBgQCsKqWpWup6E/pIN+HjYgXbYWSEF3f3XJ8IO9CRtykJNIPUPWAuNJSN\n" +
//            "y9a8FH4CDlEWwv5vLfF9ZiCKaS2a+fwDtnkx/kKKNrpd2okQvSQp5r+yga7/9aHq\n" +
//            "jKRn+FKWpoudCABwatfKk1yzcFNsTslP3A8AVxzh7rORbd3OTFXJFw==\n" +
//            "-----END RSA PRIVATE KEY-----";
//
//    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
//            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxIfYXUZkWyNtfBXtaggd\n" +
//            "U/SvRedRnd8cMj9PBuNg/R3LuLBGvP6hkoYZyLqF9ElfFlOh2aCxwUtMewY6x9cu\n" +
//            "nGdBWMdZiBEhePkKN9i4j5dNSmKt6nBvtMOMa20svhTcWLSOCqFsPaU/HFX++Quw\n" +
//            "9O3RlkE74H1bbvp2oGjFLTliXEEtDv/7mqkv6XC4Cx0ALD68r6FXDfnjYhaxIARn\n" +
//            "RqKbm0LLFswdPFXrOhXqURSWNXKDgFh4LtpO0lB6F9cBmNnzzkYnWgl6hVjNR7A5\n" +
//            "6w34nY2J1BuRYkXw5gIghMaQkkpCWMX21APgowawmZxBFDxE4si08Jl5Hod7yGde\n" +
//            "8QIDAQAB\n" +
//            "-----END PUBLIC KEY-----";
//
//
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(customClientDetailService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(
//                Arrays.asList(tokenEnchancer(), accessTokenConverter()));
//
//        endpoints.authenticationManager(authenticationManager)
//                .tokenStore(tokenStore())
//
//                .tokenEnhancer( tokenEnhancerChain );
//    }
//
//
//    @Bean
//    public TokenEnhancer tokenEnchancer(){
//        return new CustomTokenEnhancer();
//    }
//
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(privateKey);
//        converter.setVerifierKey(publicKey);
//        return converter;
//    }
//
//    @Bean
//    public JwtTokenStore tokenStore(){
//        return new JwtTokenStore(accessTokenConverter());
//    }
//
////
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore());
//        return defaultTokenServices;
//    }
//
//    @Autowired private BCryptPasswordEncoder passwordEncoder;
//
//
//}
