package com.sbdigital.webapp.SecurityService.Domain;

import com.sbdigital.webapp.SecurityService.Enum.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleName rolename;

    public Role(Long s, RoleName role_admin) {
        this.id =s;
        this.rolename = role_admin;
    }
}
