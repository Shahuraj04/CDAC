package com.libraryms.DTO;

import java.time.LocalDate;

import com.libraryms.entities.Genre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	@NotNull
	@NotBlank
	private String title;
	@NotNull
	@NotBlank
	private String author;
	@NotNull
	private Genre genre;
	@NotNull
	private LocalDate publishDate;
	@NotNull
	private Double price;
	@NotNull
	private boolean available;

}
