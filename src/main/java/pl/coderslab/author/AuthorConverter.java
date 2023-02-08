package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.publisher.PublisherDao;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;
    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }
}
