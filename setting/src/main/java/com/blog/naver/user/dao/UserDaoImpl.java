package com.blog.naver.user.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.naver.user.vo.UserVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	
	@Override
	public int insertNewUser(UserVO usersVO) {
		
		return getSqlSession().insert("UserDao.insertNewUser", usersVO);
		
		/*Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer query = new StringBuffer();
			
			query.append(" INSERT INTO USRS (USR_ID "    );
			query.append("                  , USR_NM "   );
			query.append("                  , USR_PWD "  );
			query.append("                  , JOIN_DT  ");
			query.append("                  )  "         );
			query.append(" VALUES ( ? "                    );
			query.append("        , ? "                  );
			query.append("        , ? "                  );
			query.append("        , SYSDATE ) "          );

			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, usersVO.getUserId());
			stmt.setString(2, usersVO.getUserName());
			stmt.setString(3, usersVO.getUserPassword());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally{
			instancesClose(conn, stmt, rs);
		}*/
	}

	@Override
	public UserVO selectOneUser(UserVO userVO) {
		
		return getSqlSession().selectOne("UserDao.selectOneUser", userVO);
		
		/*Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT  USR_ID "     );
			query.append("        , USR_NM "   );
			query.append("        , USR_PWD "  );
			query.append("        , JOIN_DT "  );
			query.append(" FROM    USRS "       );
			query.append(" WHERE   USR_ID = ? " );
			query.append(" AND     USR_PWD = ? " );
			
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserPassword());
			
			rs = stmt.executeQuery();
			
			userVO = null;
			
			if(rs.next()){
				userVO = new UserVO();
				userVO.setUserId(rs.getString("USR_ID"));
				userVO.setUserName(rs.getString("USR_NM"));
				userVO.setUserPassword(rs.getString("USR_PWD"));
				userVO.setJoinDate(rs.getString("JOIN_DT"));
				
			}
			return userVO;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally{
			instancesClose(conn, stmt, rs);
		}*/
	}

	/*private void loadOracleDriver() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private void instancesClose(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {	}
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {	}
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {	}
	}*/
	
}