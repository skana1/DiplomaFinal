package com.example.LoginApp.authenticate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateRequest {
    private String name;
    private int duration;
    private String source;
    private int company_id;
}
