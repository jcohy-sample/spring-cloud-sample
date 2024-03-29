package com.jcohy.provider.service;

import com.jcohy.provider.model.Course;

import cn.xuanwuai.provider.dto.CourseDto;

import java.util.List;


public interface CourseService {
	public CourseDto add(Course course);

	public CourseDto get(Long id);

	public List<CourseDto> list();

	public CourseDto getByByName(String name);
}
