-- Insert sample tags
INSERT INTO TAGS (ID, TAG) VALUES (1, 'Spring Boot');
INSERT INTO TAGS (ID, TAG) VALUES (2, 'Java');
INSERT INTO TAGS (ID, TAG) VALUES (3, 'JPA');
INSERT INTO TAGS (ID, TAG) VALUES (4, 'Docker');
INSERT INTO TAGS (ID, TAG) VALUES (5, 'MySQL');
INSERT INTO TAGS (ID, TAG) VALUES (6, 'Backend');

-- Insert sample blogs
INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(1, 'Getting Started with Spring Boot', 'This is a beginner guide for Spring Boot.', 'Programming', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(2, 'Understanding JPA Relationships', 'Let’s dive into OneToMany and ManyToMany.', 'Database', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(3, 'Deploying Spring Boot with Docker', 'Steps to containerize your Spring Boot app using Docker.', 'DevOps', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(4, 'Optimizing MySQL Queries', 'Learn how to write efficient queries for large databases.', 'Database', NOW(), NOW());

INSERT INTO BLOGS (ID, TITLE, CONTENT, CATEGORY, CREATED_AT, UPDATED_AT) VALUES
(5, 'Java Tips for Backend Developers', 'Here are some lesser-known but powerful tips for Java backend devs.', 'Programming', NOW(), NOW());

-- Blog <-> Tag mapping
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (1, 1); -- Spring Boot
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (1, 2); -- Java
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (1, 6); -- Backend

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (2, 3); -- JPA
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (2, 2); -- Java
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (2, 6); -- Backend

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (3, 1); -- Spring Boot
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (3, 4); -- Docker

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (4, 5); -- MySQL
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (4, 6); -- Backend

INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (5, 2); -- Java
INSERT INTO BLOG_TAG_MAPPING (BLOG_ID, TAG_ID) VALUES (5, 6); -- Backend
