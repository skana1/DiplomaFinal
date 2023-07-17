package com.example.LoginApp.authenticate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.LoginApp.enumerate.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String full_name;
    private String password;
    private Role role;

    private String name;
    private String description;
    private String slug; // o ester, kshu bohet nji program tmm. hajt tashi se spdoo  po ashtu se thua ti.po. edhe sa minuta do na humesh?sa te dua une
}
