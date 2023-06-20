package com.works.services;

import com.works.entities.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class LoginService {

    final DB db;

    public boolean loginStatus(Admin admin) {
        try {
            String sql = "select * from admin where email = ? and password = ?";
            PreparedStatement st = db.dataSource().getConnection().prepareStatement(sql);
            st.setString(1, admin.getEmail());
            st.setString(2, admin.getPassword());
            ResultSet rs = st.executeQuery();
            return rs.next();
        }catch (Exception ex) {
            System.err.println("Login Error : " + ex);
        }
        return false;
    }

}
