package com.example.studentmanagement.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.classRoom.ClassRoomCreate;
import com.example.studentmanagement.dtos.classRoom.ClassRoomUpdate;
import com.example.studentmanagement.entities.ClassRoom;
import com.example.studentmanagement.mappers.ClassRoomMapper;
import com.example.studentmanagement.mappers.StudentMapper;
import com.example.studentmanagement.repositories.ClassRoomRepository;
import com.example.studentmanagement.services.ClassRoomService;
import com.example.studentmanagement.services.StudentService;
import com.example.studentmanagement.services.SubjectService;

@Service
public class ClassRoomServiceImpl
		extends
		CRUDServiceImpl<ClassRoom, UUID, ClassRoomCreate, ClassRoomUpdate, ClassRoomRepository, ClassRoomMapper>
		implements ClassRoomService {
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentMapper studentMapper;

	public void linkWithSubject(UUID classId, UUID subjectId) {
		var classRoom = find(classId);
		var subject = subjectService.find(subjectId);
		classRoom.getSubjects().add(subject);
		repo.save(classRoom);
	}

	public void unLinkWithSubject(UUID classId, UUID subjectId) {
		var classRoom = find(classId);
		var subject = subjectService.find(subjectId);
		classRoom.getSubjects().remove(subject);
		repo.save(classRoom);
	}

	public void linkWithStudent(UUID classId, UUID studentId) {
		var classRoom = find(classId);
		var student = studentService.find(studentId);
		student.setClassRoom(classRoom);
		var studentCreateDto = studentMapper.toUpdateDto(student);
		studentService.update(studentCreateDto, studentId);
	}

	public void unLinkWithStudent(UUID classId, UUID studentId) {
		var classRoom = find(classId);
		var student = studentService.find(studentId);
		classRoom.getStudents().remove(student);
		repo.save(classRoom);
	}
}
