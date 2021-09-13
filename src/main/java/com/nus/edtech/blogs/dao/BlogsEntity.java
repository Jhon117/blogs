package com.nus.edtech.blogs.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "Blogs")
public class BlogsEntity {
    private String id;
    private String author;
    private String blogTitle;
    private String createDate;
    private String blogText;
    private String blogTag;

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    public String getId() { return id;}
    public void setId(String id) {this.id = id;}

    @DynamoDBAttribute(attributeName = "author")
    public String getAuthor() { return author;}
    public void setAuthor(String author) {this.author = author;}

    @DynamoDBAttribute(attributeName = "createDate")
    public String getCreateDate() { return createDate;}
    public void setCreateDate(String createDate) {this.createDate = createDate;}

    @DynamoDBAttribute(attributeName="blogTitle")
    public String getBlogTitle() { return blogTitle;}
    public void setBlogTitle(String blogTitle) {this.blogTitle = blogTitle;}

    @DynamoDBAttribute(attributeName = "blogText")
    public String getBlogText() { return blogText; }
    public void setBlogText(String blogText) { this.blogText = blogText; }

    @DynamoDBAttribute(attributeName = "blogTag")
    public String getBlogTag() { return blogTag; }
    public void setBlogTag(String blogTag) { this.blogTag = blogTag; }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", blogTitle=" + blogTitle + ", createDate=" + createDate
                + ", blogText=" + blogText + ", author=" + author + ", blogTag=" + blogTag + "]";
    }
}

