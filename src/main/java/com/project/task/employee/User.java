package com.project.task.employee;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails, CredentialsContainer {

	@Id
	private Long userid;
	@Column(nullable = false, unique = true, name = "Username")
	private String username;
	@Column(nullable = false, name = "Password")
	private String password;

	@OneToOne
	private Role role;

	@CreationTimestamp
	private LocalDateTime createdat;

	@Override
	public void eraseCredentials() {
		this.password = null; // Securely dereference the password field
	}
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Split the authorities string and convert to a list of SimpleGrantedAuthority objects
        return Arrays.stream(this.role.getRolename().split(","))
                     .map(SimpleGrantedAuthority::new)
                     .collect(Collectors.toList());
    }

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
}
