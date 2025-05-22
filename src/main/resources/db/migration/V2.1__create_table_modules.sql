CREATE TABLE modules (
     id UUID PRIMARY KEY,
     course_id UUID REFERENCES courses(id),
     title VARCHAR(100),
     position INT,
     created_at TIMESTAMP DEFAULT NOW()
);
