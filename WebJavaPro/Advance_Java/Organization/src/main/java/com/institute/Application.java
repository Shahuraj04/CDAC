package com.institute;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.institute.dto.StudentDTO;
import com.institute.entities.Student;

@SpringBootApplication
@EntityScan(basePackages = "com.institute")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// configure ModelMapper class as a spring bean
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper mapper = new ModelMapper();

	    // Create typeMap first
	    var typeMap = mapper.createTypeMap(Student.class, StudentDTO.class);

	    // Custom mapping: course.courseId -> courseId
	    typeMap.addMappings(m -> m.map(src -> src.getCourse().getCourseId(), StudentDTO::setCourseId));

	    // Apply config
	    mapper.getConfiguration()
	            .setPropertyCondition(Conditions.isNotNull())
	            .setMatchingStrategy(MatchingStrategies.STRICT);

	    return mapper;
	}


}
