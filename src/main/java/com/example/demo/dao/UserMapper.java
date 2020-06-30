package com.example.demo.dao;

import com.example.demo.domain.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper {

	@Select("select count(*) from user where username = #{param1} and password = #{param2} ")
	int login(String username,String password);

	@Select("select `user_id`, `username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name`, `departmentid`, `persontype` from sys_user where user_id = #{id}")
	UserDO get(Long userId);

	@Select("<script>" +
	"select * from sys_user " +
			"<where>" +
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
		  		  "<if test=\"departmentid != null and departmentid != ''\">"+ "and departmentid = #{departmentid} " + "</if>" +
		  		  "<if test=\"persontype != null and persontype != ''\">"+ "and persontype = #{persontype} " + "</if>" +
		  			"</where>"+
			" <choose>" +
	            "<when test=\"sort != null and sort.trim() != ''\">" +
	                "order by ${sort} ${order}" +
	            "</when>" +
				"<otherwise>" +
	                "order by user_id desc" +
				"</otherwise>" +
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" +
			"</if>"+
			"</script>")
	List<UserDO> list(Map<String, Object> map);

	@Select("<script>" +
			"select u.user_id,u.username,u.password,u.email,u.mobile,u.status,u.user_id_create,u.gmt_create,u.gmt_modified,u.name,u.departmentid,u.persontype,d.departmentname as 'departmentname' from sys_user u,sys_department d  " +
			"<where>" +
			"<if test=\"userId != null and userId != ''\">"+ "and u.user_id = #{userId} " + "</if>" +
			"<if test=\"username != null and username != ''\">"+ "and u.username LIKE CONCAT(CONCAT('%', #{username}),'%')  " + "</if>" +
			"<if test=\"password != null and password != ''\">"+ "and u.password = #{password} " + "</if>" +
			"<if test=\"email != null and email != ''\">"+ "and u.email = #{email} " + "</if>" +
			"<if test=\"mobile != null and mobile != ''\">"+ "and u.mobile = #{mobile} " + "</if>" +
			"<if test=\"status != null and status != ''\">"+ "and u.status = #{status} " + "</if>" +
			"<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and u.user_id_create = #{userIdCreate} " + "</if>" +
			"<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and u.gmt_create = #{gmtCreate} " + "</if>" +
			"<if test=\"gmtModified != null and gmtModified != ''\">"+ "and u.gmt_modified = #{gmtModified} " + "</if>" +
			"<if test=\"name != null and name != ''\">"+ "and u.name = #{name} " + "</if>" +
			"<if test=\"departmentid != null and departmentid != ''\">"+ "and u.departmentid = #{departmentid} " + "</if>" +
			"<if test=\"persontype != null and persontype != ''\">"+ "and u.persontype = #{persontype} " + "</if>" +
			"and u.departmentid=d.id " +
			"and u.status!=2 " +
			"</where>"+
			" <choose>" +
			"<when test=\"sort != null and sort.trim() != ''\">" +
			"order by ${sort} ${order}" +
			"</when>" +
			"<otherwise>" +
			"order by user_id desc" +
			"</otherwise>" +
			"</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" +
			"</if>"+
			"</script>")
	List<UserDO> listByDepartment(Map<String, Object> map);

	@Select("<script>" +
	"select count(*) from sys_user " +
			"<where>" +
			"<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
			"<if test=\"username != null and username != ''\">"+ "and username LIKE CONCAT(CONCAT('%', #{username}),'%') " + "</if>" +
			"<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
			"<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
			"<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
			"<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
			"<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
			"<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
			"<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
			"<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
			"<if test=\"departmentid != null and departmentid != ''\">"+ "and departmentid = #{departmentid} " + "</if>" +
			"<if test=\"persontype != null and persontype != ''\">"+ "and persontype = #{persontype} " + "</if>" +
			"and status!=2 " +
			"</where>"+
			"</script>")
	int count(Map<String, Object> map);

	@Options(useGeneratedKeys = true, keyProperty = "userId")
	@Insert("insert into sys_user (`username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name`, `departmentid`, `persontype`)"
	+ "values (#{username}, #{password}, #{email}, #{mobile}, #{status}, #{userIdCreate}, #{gmtCreate}, #{gmtModified}, #{name}, #{departmentid}, #{persontype})")
	int save(UserDO sysUser);
	
	@Update("<script>"+ 
			"update sys_user " + 
					"<set>" + 
		            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"username != null\">`username` = #{username}, </if>" + 
                    "<if test=\"password != null\">`password` = #{password}, </if>" + 
                    "<if test=\"email != null\">`email` = #{email}, </if>" + 
                    "<if test=\"mobile != null\">`mobile` = #{mobile}, </if>" + 
                    "<if test=\"status != null\">`status` = #{status}, </if>" + 
                    "<if test=\"userIdCreate != null\">`user_id_create` = #{userIdCreate}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">`gmt_modified` = #{gmtModified}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"departmentid != null\">`departmentid` = #{departmentid}, </if>" + 
                    "<if test=\"persontype != null\">`persontype` = #{persontype}, </if>" + 
          					"</set>" + 
					"where user_id = #{userId}"+
			"</script>")
	int update(UserDO sysUser);
	
	@Delete("delete from sys_user where user_id =#{userId}")
	int remove(Long user_id);

	@Update("update sys_user set status=2 where user_id =#{userId}")
	int removeSale(Long user_id);

	@Delete("<script>"+ 
			"delete from sys_user where user_id in " + 
					"<foreach item=\"userId\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{userId}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] userIds);
}
