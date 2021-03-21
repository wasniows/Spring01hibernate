package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

public class StringToBookConverter implements Converter<String, Book> {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book convert(String s) {
        return bookDao.findById(Long.parseLong(s));
    }
}
