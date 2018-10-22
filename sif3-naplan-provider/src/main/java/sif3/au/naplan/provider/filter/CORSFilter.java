package sif3.au.naplan.provider.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

	private static final Logger L = LoggerFactory.getLogger(CORSFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		L.debug("CORS Filter");
		response.addHeader("Access-Control-Allow-Origin", "*");

		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			L.trace("Sending Header....");
			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
			List<String> allowedHeaders = new ArrayList<>(Arrays.asList("Content-Type", "Authorization", "fingerprint",
					"messageid", "requestid", "timestamp", "applicationkey", "authenticateduser", "requestType",
					"navigationpage", "navigationpagesize", "queryintention","serviceType"));
			Enumeration<String> headers = request.getHeaderNames();
			while (headers.hasMoreElements()) {
				allowedHeaders.add(headers.nextElement());
			}
			response.addHeader("Access-Control-Allow-Headers",
					allowedHeaders.stream().distinct().collect(Collectors.joining(",")));
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addHeader("Access-Control-Max-Age", "1");
		}
		filterChain.doFilter(request, response);
	}
}
