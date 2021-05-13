package com.bookstore.BookStoreMicroservice.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.bookstore.BookStoreMicroservice.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	
	private UUID bookId;
	//@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = " author Name is Invalid")
	private String authorName;

	//@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = " Book Name is Invalid")
	private String bookName;
	
	//@NotNull(message = "quantity Should Not be empty")
	private Integer quantity;
	
	//@NotBlank(message = "Price Cannot be empty")
	public Double price;
	
	private String bookDetails;

	@CreationTimestamp
	@Column(name = "created_date_and_time")
	private Date createdDateAndTime;

	@UpdateTimestamp
	@Column(name = "updated_date_and_time")
	private Date updatedDateAndTime;

	public Book(BookDTO bookDTO) {
		this.updateBookDataByBookId(bookDTO);
	}

	public void updateBookDataByBookId(BookDTO bookDTO) {

		this.authorName = bookDTO.authorName;
		this.bookName = bookDTO.bookName;
		this.quantity = bookDTO.quantity;
		this.price = bookDTO.price;
		this.bookDetails = bookDTO.bookDetails;

	}

}