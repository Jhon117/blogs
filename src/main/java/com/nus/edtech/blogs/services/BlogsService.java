package com.nus.edtech.blogs.services;

import com.nus.edtech.blogs.common.utils.BlogsValidator;
import com.nus.edtech.blogs.dao.BlogsEntity;
import com.nus.edtech.blogs.dao.ComplexBlogs;
import com.nus.edtech.blogs.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogsService {

    @Autowired
    private BlogsRepository blogsRepository;

    @Autowired
    private BlogsValidator blogsValidator;

    public void postBlogByAuthor(BlogsEntity blogsEntity){
        blogsValidator.validateInputBlogs(blogsEntity);
         blogsRepository.saveBlog(blogsEntity);
    }

    public List<String> findBlogsByAuthor(String author) {
        List<BlogsEntity> items = blogsRepository.findBlogsByAuthor(author);
        List<String> idList = new ArrayList<>();
        for(BlogsEntity item: items) {
            idList.add(item.getId());
        }
        return idList;
    }

    public BlogsEntity getBlogById(String id) {
        return blogsRepository.findBlogById(id);
    }

    public void updateBlog(BlogsEntity requestBlogsEntity) {
        BlogsEntity originalBlogEntity = blogsRepository.findBlogById(requestBlogsEntity.getId());
        originalBlogEntity = blogsValidator.updateBlogsEntity(requestBlogsEntity,originalBlogEntity);
        blogsRepository.saveBlog(originalBlogEntity);
    }

    public void deleteBlogById(String id) {
        BlogsEntity blogsEntity = blogsRepository.findBlogById(id);
        blogsRepository.deleteBlog(blogsEntity);
    }

    public void deleteBlogsByAuthor(String author) {
        List <BlogsEntity> blogsByAuthor = blogsRepository.findBlogsByAuthor(author);
        for (BlogsEntity blogEntity:blogsByAuthor) {
            blogsRepository.deleteBlog(blogEntity);
        }
    }

    public List<ComplexBlogs> findComplexBlogsByAuthorAndId(String author, String blogId) {
        List<ComplexBlogs> items = blogsRepository.findComplexBlogsByAuthorAndId(author, blogId);
        return items;
    }

    public void postComplexBlogByAuthor(ComplexBlogs requestBlog) {
        blogsRepository.saveComplexBlog(requestBlog);
    }

    public List<ComplexBlogs> findComplexBlogsByAuthor(String author) {
        return blogsRepository.findComplexBlogsByAuthor(author);
    }

    public void queryIndex(String author) {
         blogsRepository.queryIndex(author);
    }

    public void addCommentToBlog(String blogId, BlogsEntity.Comments comments) {
        BlogsEntity originalBlogEntity = blogsRepository.findBlogById(blogId);
        originalBlogEntity = blogsValidator.addCommentToBlog(comments,originalBlogEntity);
        blogsRepository.saveBlog(originalBlogEntity);
    }
}
