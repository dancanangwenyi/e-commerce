package com.example.ecommerce.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;


/**
 * For this implementation, Spring calculates the MD5 hash from the cached content written to the response.
 * * Next time, when it receives a request with the If-None-Match header, it again creates the MD5 hash from
 * * the cached content written to the response and then compares these two hashes. If both are the same,
 * * it sends the 304 NOT MODIFIED response. This way it will save bandwidth but computation will be performed
 * * there using the same CPU computation.
 *
 * We can use the HTTP cache control (org.springframework.http.CacheControl) class and use the version or similar
 * * attribute that gets updated for each change, if available, to avoid unecessary CPU computation and for better
 * * ETag handling as shown next:*
 *
 *
 * Return ResponseEntity.ok()
 *
 *        .cacheControl(CacheControl.maxAge(5, TimeUnit.DAYS))
 *
 *        .eTag(prodcut.getModifiedDateInEpoch())
 *
 *        .body(product);
 *
 * Adding an ETag to the response also allows UI apps to determine whether a page/object refresh is required,
 * * or an event needs to be triggered, especially where data changes frequently in applications such as providing
 * * live scores or stock quotes.* * *
 */



@Configuration
public class AppConfig {
    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
