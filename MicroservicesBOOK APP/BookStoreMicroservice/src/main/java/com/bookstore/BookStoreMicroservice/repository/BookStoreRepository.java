package com.bookstore.BookStoreMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.BookStoreMicroservice.model.Book;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookStoreRepository extends JpaRepository<Book, UUID> {

    @Query("UPDATE Book SET quantity=?1 WHERE bookId=?2")
    @Modifying
    public void updateQuantityAfterOrder(Integer quantity, UUID bookId);



    @Query(value = "select * from book where book_name LIKE %?1% ", nativeQuery = true)
    public List<Book> findBooksByBookName(String bookName);

}