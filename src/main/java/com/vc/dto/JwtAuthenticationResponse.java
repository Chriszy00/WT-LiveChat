package com.vc.dto;

public class JwtAuthenticationResponse {

//	private String accessToken;
//	private String tokenType = "Bearer";
//	private String roleName;
//	private String firstName;
//	private Long userId;
//	private String email;
//	
//
//	public JwtAuthenticationResponse(String accessToken, String roleName, String firstName,
//			Long userId, String email) {
//		super();
//		this.accessToken = accessToken;
//		this.roleName = roleName;
//		this.firstName = firstName;
//		this.userId = userId;
//		this.email = email;
//	}
//
//	public String getAccessToken() {
//		return accessToken;
//	}
//
//	public void setAccessToken(String accessToken) {
//		this.accessToken = accessToken;
//	}
//
//	public String getTokenType() {
//		return tokenType;
//	}
//
//	public void setTokenType(String tokenType) {
//		this.tokenType = tokenType;
//	}
//
//	public String getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
    private String accessToken;
    private String tokenType = "Bearer";
    

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
	
}
