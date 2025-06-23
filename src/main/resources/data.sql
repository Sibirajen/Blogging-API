-- Insert sample tags
INSERT INTO TAGS (ID, TAG) VALUES (10, 'spring boot');
INSERT INTO TAGS (ID, TAG) VALUES (20, 'java');
INSERT INTO TAGS (ID, TAG) VALUES (30, 'jpa');
INSERT INTO TAGS (ID, TAG) VALUES (40, 'docker');
INSERT INTO TAGS (ID, TAG) VALUES (50, 'mysql');
INSERT INTO TAGS (ID, TAG) VALUES (60, 'backend');

-- Insert sample blogs
INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(10, 'Getting Started with Spring Boot', 'This is a beginner guide for Spring Boot.', 'Programming', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(20, 'Understanding JPA Relationships', 'Let’s dive into OneToMany and ManyToMany.', 'Database', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(30, 'Deploying Spring Boot with Docker', 'Steps to containerize your Spring Boot app using Docker.', 'DevOps', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(40, 'Optimizing MySQL Queries', 'Learn how to write efficient queries for large databases.', 'Database', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(50, 'Java Tips for Backend Developers', 'Here are some lesser-known but powerful tips for Java backend devs.', 'Programming', NOW(), NOW());

-- Blog <-> Tag mapping
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (10, 10); -- Spring Boot
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (10, 20); -- Java
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (10, 60); -- Backend

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (20, 30); -- JPA
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (20, 20); -- Java
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (20, 60); -- Backend

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (30, 10); -- Spring Boot
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (30, 40); -- Docker

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (40, 50); -- MySQL
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (40, 60); -- Backend

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (50, 20); -- Java
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (50, 60); -- Backend
