CREATE TABLE courses (
    id UUID PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    instructor_id UUID REFERENCES users(id),
    price DECIMAL(10, 2) NOT NULL,
    is_published BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW()
)