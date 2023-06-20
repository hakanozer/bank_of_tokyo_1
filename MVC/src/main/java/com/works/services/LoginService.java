package com.works.services;

import com.works.entities.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class LoginService {

    final DB db;
    final HttpServletRequest req;

    public boolean loginStatus(Admin admin) {
        try {
            String sql = "select * from admin where email = ? and password = ?";
            PreparedStatement st = db.dataSource().getConnection().prepareStatement(sql);
            st.setString(1, admin.getEmail());
            st.setString(2, admin.getPassword());
            ResultSet rs = st.executeQuery();
            boolean status = rs.next();
            if( status ) {
                Admin adm = new Admin();
                adm.setAid( rs.getLong("aid") );
                adm.setEmail( rs.getString("email") );
                req.getSession().setAttribute("admin", adm);
            }
            return status;
        }catch (Exception ex) {
            System.err.println("Login Error : " + ex);
        }
        return false;
    }

}
