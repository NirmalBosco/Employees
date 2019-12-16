package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.model.EmployeeModel;
import com.example.model.Student;

public class StudentDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Student s) {
		String sql = "insert into stu(name,dgree,desgination,address) values ('" + s.getName() + "','" + s.getDgree()
				+ "','" + s.getDesgination() + "','" + s.getAddress() + "')";
		return template.update(sql);
	}

	public int deleteStudent(Long id) {
		String sql = "delete from stu where id=" + id + "";
		return template.update(sql);

	}

	public List<Student> getStudents() {
		return template.query("select * from stu", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setDgree(rs.getString(3));
				st.setDesgination(rs.getString(4));
				st.setAddress(rs.getString(5));

				return st;
			}
		});

	}

	public Student getStuedentById(int id) {
		String sql = "select * from stu where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public int update(Student s) {
		String sql = "update stu set name='" + s.getName() + "',dgree='" + s.getDgree() + "',desgination='"
				+ s.getDesgination() + "',address='" + s.getAddress() + "' where id =" + s.getId() + "";
		return template.update(sql);

	}

	// second template for employees

	public int empsave(EmployeeModel em) {
		String sql = "insert into employees (name,position,education,phonenumber,address,state,country) values('"
				+ em.getName() + "','" + em.getPosition() + "','" + em.getEducation() + "','" + em.getPhonenumber()
				+ "','" + em.getAddress() + "','" + em.getState() + "','" + em.getCountry() + "')";
		return template.update(sql);
	}

	public List<EmployeeModel> getEmployeesList() {

		return template.query("select * from employees", new RowMapper<EmployeeModel>() {

			public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeModel em = new EmployeeModel();
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setPosition(rs.getString(3));
				em.setEducation(rs.getString(4));
				em.setPhonenumber(rs.getInt(5));
				em.setAddress(rs.getString(6));
				em.setState(rs.getString(7));
				em.setCountry(rs.getString(8));
				return em;
			}

		});
	}
	
	
}
