//package com.example.meconnect.auth;
//
//import com.example.meconnect.service.myUserDetailService;
//import com.example.meconnect.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////import com.meConnect2.meConnect2.serviceImpl.myUserDetailService;
////import com.meConnect2.meConnect2.util.JwtUtil;
//
//@Component
//public class TokenAuthFilter extends OncePerRequestFilter
//{
//
//	  @Autowired
//	   private myUserDetailService userDetailService;
//
//	 @Autowired
//	 private JwtUtil jwtUtil;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		String authorizationHeader=request.getHeader("Authorization");
//
//		String userName=null;
//		String  jwt=null;
//
//		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
//			jwt=authorizationHeader.substring(7);
//			userName=jwtUtil.extractUsername(jwt);
//		}
//
//		if(userName !=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
//			UserDetails userDetail= this.userDetailService.loadUserByUsername(userName);
//
//			if(jwtUtil.validateToken(jwt, userDetail)) {
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(
//						userDetail,null,userDetail.getAuthorities());
//
//				usernamePasswordAuthenticationToken
//				.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//			}
//
//
//
//		}
//
//		filterChain.doFilter(request, response);
//	}
//
//}
