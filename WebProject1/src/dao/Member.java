package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDto;

public class Member {
	public void joinMember(String username, String password, String name) {
        	Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO member (id, pw, name) VALUES (?, ?, ?)";
            PreparedStatement pstmt = null;
            
            try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            pstmt.setString(3, name);
	            pstmt.executeUpdate();
            } catch(SQLException e) {
            	e.printStackTrace();
            } finally {
            	try {
	            	pstmt.close();
	            	conn.close();
            	} catch(SQLException e) {
            		e.printStackTrace();
            	}
            }
    }
	
	public boolean loginSuccess(String id, String pw){
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT COUNT(*) AS cnt" + 
				" FROM member" + 
				" WHERE id= ? AND pw = ?";
				
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginSuccess = false;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int cnt = rs.getInt("cnt");
                if(cnt==1) {
                	loginSuccess=true;
                }
            }
        } catch(SQLException e) {
        	e.printStackTrace();
        } finally {
        	try {
                rs.close();
                pstmt.close();
                conn.close();
        	} catch(SQLException e) {
        		e.printStackTrace();
        	}
        }

        return loginSuccess;
    }
	public String getMember (String id) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT name, mpoint" + 
				" FROM member" + 
				" WHERE id = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				name = rs.getString("name");
				
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return name;
	}
	public int getPoint (String id) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT mpoint" + 
					" FROM member" + 
					" WHERE id = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				point = rs.getInt("mpoint");
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return point;
	}
	public ArrayList<MemberDto> getMembers() {
		Connection conn = DBConnection.getConnection();
        ArrayList<MemberDto> members = new ArrayList<>();


            String sql = "SELECT * FROM member";
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	
	            while (rs.next()) {
	                String id = rs.getString("id"); 
	                String pw = rs.getString("pw"); 
	                String name = rs.getString("name"); 
	                int point = rs.getInt("mpoint");
	
	                MemberDto dto = new MemberDto(id, pw, name, point);
	                members.add(dto);
	            }
            } catch(SQLException e) {
            	e.printStackTrace();
            } finally {
            	try {
		            rs.close();
		            pstmt.close();
		            conn.close();
            	} catch(SQLException e) {
            		e.printStackTrace();
            	}
            }
        return members;
    }
	public ArrayList<MemberDto> getOneMember(String id) {
		Connection conn = DBConnection.getConnection();
		ArrayList<MemberDto> members = new ArrayList<>();
		
		
		String sql = "SELECT * FROM member WHERE id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("pw"); 
				String name = rs.getString("name"); 
				int point = rs.getInt("mpoint");
				
				MemberDto dto = new MemberDto(id, pw, name, point);
				members.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
	}
	public void MemberDelete(String id){
		Connection conn = DBConnection.getConnection();
		String sql = "DELETE FROM member WHERE id=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void MemberUpdate(String pw, String name, int mpoint, String id){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE member" + 
					" SET pw=?, name = ?, mpoint = ?" + 
					" WHERE id=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setInt(3, mpoint);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}







