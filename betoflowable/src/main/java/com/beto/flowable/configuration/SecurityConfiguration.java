/*
package com.beto.flowable.configuration;

import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.spring.security.FlowableAuthenticationProvider;
import org.flowable.spring.security.FlowableUserDetailsService;
import org.flowable.spring.security.SpringSecurityAuthenticationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IdmIdentityService idmIdentityService;

    public SecurityConfiguration() {
        Authentication.setAuthenticationContext(new SpringSecurityAuthenticationContext());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public FlowableAuthenticationProvider authenticationProvider(IdmIdentityService idmIdentityService, UserDetailsService userDetailsService) {
        return new FlowableAuthenticationProvider(idmIdentityService, userDetailsService);
    }

    @Bean
    public FlowableUserDetailsService userDetailsService(IdmIdentityService identityService) {
        return new FlowableUserDetailsService(identityService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider(idmIdentityService, userDetailsService(idmIdentityService)))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .not().authenticated().and().httpBasic();
    }

    // Needed for allowing slashes in urls, needed for getting deployment resources
    @Bean
    public HttpFirewall defaultFireWall() {
        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.httpFirewall(defaultFireWall());
        super.configure(web);
    }

}
*/
