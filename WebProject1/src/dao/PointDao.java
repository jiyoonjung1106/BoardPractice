package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointDao {
	public int subjectProgramPoint(){
		Connection conn = DBConnection.getConnection();
        String sql = "SELECT point" + 
        		" FROM ITPROJECT " + 
        		" WHERE subject = 'PROGRAM'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int point = 0;
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	point = rs.getInt("point");
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
        return point;
	}
	public int subjectJavaPoint(){
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT point" + 
				" FROM ITPROJECT " + 
				" WHERE subject = 'JAVA'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				point = rs.getInt("point");
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
		return point;
	}
	public int subjectCPoint(){
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT point" + 
				" FROM ITPROJECT " + 
				" WHERE subject = 'C'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				point = rs.getInt("point");
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
		return point;
	}
	public void subjectProgramMinus(String id){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE member" + 
					" SET mpoint = mpoint - 100000" + 
					" WHERE id = ?";
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
	public void subjectJavaMinus(String id){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE member" + 
				" SET mpoint = mpoint - 500000" + 
				" WHERE id = ?";
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
	public void subjectCMinus(String id){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE member" + 
				" SET mpoint = mpoint - 300000" + 
				" WHERE id = ?";
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
	public void pointPlus(){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE member SET Mpoint = mpoint + 1";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
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
