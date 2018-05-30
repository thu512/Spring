package com.gsitm.csrf;

import java.util.regex.Pattern;



import javax.servlet.http.HttpServletRequest;



import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import org.springframework.security.web.util.matcher.RequestMatcher;

import org.springframework.stereotype.Component;



//@Component

public class CsrfSecurityRequestMathcer implements RequestMatcher {

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS|POST)$");

    private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/unprotected", null);



    public boolean matches(HttpServletRequest request) {

        if(allowedMethods.matcher(request.getMethod()).matches()){

            return false;

        }



        return !unprotectedMatcher.matches(request);

    }

}