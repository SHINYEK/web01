package model;

import java.util.*;
import java.sql.*;

public class UserDAO {
	//사용자목록
	public ArrayList<UserVO> list(){
		ArrayList<UserVO> array = new ArrayList<UserVO>();
		try {
			String sql = "select * from users order by join_date desc";
			PreparedStatement ps = DB.CON.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setUid(rs.getString("uid"));
				vo.setUpass(rs.getString("upass"));
				vo.setUname(rs.getString("uname"));
				vo.setAddress(rs.getString("address"));
				vo.setJoin_date(rs.getDate("join_date"));
//				System.out.println(vo.toString());
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("사용자 목록오류"+e.toString());
		}
		return array;
	}
}
